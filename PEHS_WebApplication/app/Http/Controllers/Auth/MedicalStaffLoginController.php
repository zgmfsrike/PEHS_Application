<?php

namespace App\Http\Controllers\Auth;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
class MedicalStaffLoginController extends Controller
{
  public function __construct()
  {
    $this->middleware('guest:medical_staff',['except'=>['logout']]);
  }

  public function login(Request $request)
  {
    // if($request->role == 1){
      $medical_staff_username = User::where('username',$request->username)->where('role_id',3)->get();
      $medical_staff_password = User::where('password',$request->password)->where('role_id',3)->get();
      //validate the form data
      $this->validate($request,[
      'username' => 'required',
      'password' => 'required|min:6',
      ]);
      //Attempt to log the user in
      if (Auth::guard('medical_staff')->attempt(['username'=>$request->username,'password'=>$request->password,'role_id'=>3],$request->remember)) {
        //if successful, then redirect to theri intended location
        return redirect()->intended(route('medical_staff.home'));
      }
        //if unsuccessful, then redirect back to the login with the form data and error message
        if($medical_staff_username->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withInput($request->only('role','remember'))->withErrors([
                  'username' => 'Username is invalid ',
              ]);
        }else if($medical_staff_password->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withInput($request->only('role','remember'))->withErrors([
                  'password' => 'Password is invalid ',
              ]);
        }
    // }

  }

  public function logout(Request $request)
  {
      Auth::guard('medical_staff')->logout();
      $request->session()->invalidate();
      return redirect()->route('login');
  }
}
