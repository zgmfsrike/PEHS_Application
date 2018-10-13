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
    $username = $request->username;
    $password =$request->password;
    // $role = DB::table('users as u')->join('user_roles as ur','u.user_id','ur.user_id')->select('ur.role_id')
    // ->where('u.username',$username)->first();
    // if($role){
    //   $role_id = $role->role_id;
    // }else{
    //   $role_id = 4;
    // }


    // if($request->role == 1){
    // $username = User::where('username',$request->username)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    // $username = User::where('username',$request->username)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    // $password = User::where('password',$request->password)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    // $password = User::where('password',$request->password)->where('role_id',1)->orWhere('role_id',2)->orWhere('role_id',3)->get();
    //validate the form data
    $this->validate($request,[
      'username' => 'required|string|min:4|regex:/^[a-zA-Z0-9]+$/',
      'password' => 'required|string|min:6|regex:/^[a-zA-Z0-9]+$/',
    ]);
    //Attempt to log the user in
    // if ($role_id ==1 && Auth::guard('admin')->attempt(['username'=>$username,'password'=>$password],$request->remember) ) {
    if (Auth::guard('admin')->attempt(['username'=>$username,'password'=>$password,'role_id'=>1],$request->remember)) {
      return redirect()->intended(route('admin.home'))->with('login_success', 'Login Success!');
      // return view('admin.home');
    }
    else
    // if ($role_id ==2 && Auth::guard('doctor')->attempt(['username'=>$username,'password'=>$password],$request->remember)) {
      if (Auth::guard('doctor')->attempt(['username'=>$username,'password'=>$password,'role_id'=>2],$request->remember) ) {


      return redirect()->intended(route('doctor.home'))->with('login_success', 'Login Success!');

    }else if (Auth::guard('medical_staff')->attempt(['username'=>$username,'password'=>$password,'role_id'=>3],$request->remember) ) {
    // if($role_id ==3 && Auth::guard('medical_staff')->attempt(['username'=>$username,'password'=>$password],$request->remember)){

      return redirect()->intended(route('medical_staff.home'))->with('login_success', 'Login Success!');
    }
    else{
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
    return redirect()->route('about');

  }

}
