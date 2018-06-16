<?php

namespace App\Http\Controllers\Auth;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
class DoctorLoginController extends Controller
{
  public function __construct()
  {
    $this->middleware('guest:doctor',['except'=>['logout']]);
  }
  public function login(Request $request)
  {
    // if($request->role == 1){
      $doctor_username = User::where('username',$request->username)->where('role_id',2)->get();
      $doctor_password = User::where('password',$request->password)->where('role_id',2)->get();
      //validate the form data
      $this->validate($request,[
      'username' => 'required',
      'password' => 'required|min:6'
      ]);
      //Attempt to log the user in
      if (Auth::guard('doctor')->attempt(['username'=>$request->username,'password'=>$request->password,'role_id'=>2],$request->remember)) {
        //if successful, then redirect to theri intended location
        return redirect()->intended(route('doctor.home'));
      }
        //if unsuccessful, then redirect back to the login with the form data and error message
        if($doctor_username->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withInput($request->only('role','remember'))->withErrors([
                  'username' => 'Username is invalid ',
              ]);
        }else if($doctor_password->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withInput($request->only('role','remember'))->withErrors([
                  'password' => 'Password is invalid ',
              ]);
        }
    // }

  }
  public function logout(Request $request)
  {
      Auth::guard('doctor')->logout();
      $request->session()->invalidate();
      return redirect()->route('login');
  }



}
