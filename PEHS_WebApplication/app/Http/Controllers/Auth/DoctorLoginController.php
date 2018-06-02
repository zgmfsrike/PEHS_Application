<?php

namespace App\Http\Controllers\Auth;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Auth;
use Validator;
use App\Doctor;
class DoctorLoginController extends Controller
{

    public function __construct()
    {
      $this->middleware('guest:doctor',['except'=>['logout']]);
      $this->middleware('guest:admin');
    }
    public function showLoginForm()
    {
      return view('auth.doctor-login');
    }

    public function login(Request $request)
    {
      $doctor_username = Doctor::where('username',$request->username)->get();
      $doctor_password = Doctor::where('password',$request->password)->get();
      //validate the form data
      $validator = Validator::make($request->all(),[
      'username' => 'required|min:4',
      'password' => 'required|min:6'
      ]);

      //Attempt to log the user in
      if (Auth::guard('doctor')->attempt(['username'=>$request->username,'password'=>$request->password],$request->remember)) {
        //if successful, then redirect to theri intended location
        return redirect()->intended(route('doctor.dashboard'));
      }
        //if unsuccessful, then redirect back to the login with the form data
        if($doctor_username->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withErrors([
                  'username' => 'Username is invalid ',
              ]);
        }else if($doctor_password->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withErrors([
                  'password' => 'Password is invalid ',
              ]);
        }

    }
    public function logout(Request $request)
    {
        Auth::guard('doctor')->logout();

        $request->session()->invalidate();

        return redirect()->route('doctor.login');
    }

}
