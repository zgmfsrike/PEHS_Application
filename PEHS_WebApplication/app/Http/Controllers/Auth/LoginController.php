<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Http\Request;
use Auth;
use DB;
use App\User;
class LoginController extends Controller
{
  /*
  |--------------------------------------------------------------------------
  | Login Controller
  |--------------------------------------------------------------------------
  |
  | This controller handles authenticating users for the application and
  | redirecting them to your home screen. The controller uses a trait
  | to conveniently provide its functionality to your applications.
  |
  */

  use AuthenticatesUsers;

  /**
  * Where to redirect users after login.
  *
  * @var string
  */
  protected $redirectTo = '/home';

  /**
  * Create a new controller instance.
  *
  * @return void
  */
  public function __construct()
  {
    $this->middleware('guest:admin',['except'=>['logout']]);
    $this->middleware('guest:doctor',['except'=>['logout']]);
    $this->middleware('guest:medical_staff',['except'=>['logout']]);

  }

  public function username()
  {
    return 'username';
  }

  public function login(Request $request)
  {
    // if($request->role == 1){
    // $username = User::where('username',$request->username)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    $username = User::where('username',$request->username)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    $password = User::where('password',$request->password)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    // $password = User::where('password',$request->password)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    //validate the form data
    $this->validate($request,[
      'username' => 'required',
      'password' => 'required|min:6',
    ]);
    //Attempt to log the user in
    if (Auth::guard('admin')->attempt(['username'=>$request->username,'password'=>$request->password,'role_id'=>1],$request->remember)) {
      return redirect()->intended(route('admin.home'))->with('login_success', 'Login Success!');
        // return view('admin.home');
    }else if (Auth::guard('doctor')->attempt(['username'=>$request->username,'password'=>$request->password,'role_id'=>2],$request->remember)){
      return redirect()->intended(route('doctor.home'))->with('login_success', 'Login Success!');
    }else if(Auth::guard('medical_staff')->attempt(['username'=>$request->username,'password'=>$request->password,'role_id'=>3],$request->remember)){
      return redirect()->intended(route('medical_staff.home'))->with('login_success', 'Login Success!');
    }else{
        //if unsuccessful, then redirect back to the login with the form data and error message
      return redirect()->back()->withInput($request->only('username','remember'))->with('login_fail','Username or Password is invalid');
    }

    // if(empty($username)){
    //   return redirect()->back()->withInput($request->only('username','remember'))->withErrors([
    //     'username' => 'Username is invalid ',
    //   ]);
    // }else if($password->isEmpty()){
    //   return redirect()->back()->withInput($request->only('username','remember'))->withErrors([
    //     'password' => 'Password is invalid ',
    //   ]);
  // }


  }
  public function logout(Request $request)
  {
    Auth::logout();
    $request->session()->invalidate();
    return redirect()->route('login');

  }

}
