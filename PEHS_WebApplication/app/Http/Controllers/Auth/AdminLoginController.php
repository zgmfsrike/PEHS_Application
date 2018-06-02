<?php

namespace App\Http\Controllers\Auth;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Auth;
use App\Admin;
class AdminLoginController extends Controller
{
    public function __construct()
    {
      $this->middleware('guest:admin',['except'=>['logout']]);
      $this->middleware('guest:doctor');
    }
    public function showLoginForm()
    {
      return view('auth.admin-login');
    }

    public function login(Request $request)
    {

      $admin_username = Admin::where('username',$request->username)->get();
      $admin_password = Admin::where('password',$request->password)->get();

      //validate the form data
      $this->validate($request,[
      'username' => 'required|min:4',
      'password' => 'required|min:6'
      ]);

      //Attempt to log the user in
      if (Auth::guard('admin')->attempt(['username'=>$request->username,'password'=>$request->password],$request->remember)) {
        //if successful, then redirect to theri intended location
        return redirect()->intended(route('admin.dashboard'));
      }
        //if unsuccessful, then redirect back to the login with the form data and error message
        if($admin_username->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withErrors([
                  'username' => 'Username is invalid ',
              ]);
        }else if($admin_password->isEmpty()){
          return redirect()->back()->withInput($request->only('username','remember'))->withErrors([
                  'password' => 'Password is invalid ',
              ]);
        }


    }

    public function logout(Request $request)
    {
        Auth::guard('admin')->logout();

        $request->session()->invalidate();

        return redirect()->route('admin.login');


    }




}
