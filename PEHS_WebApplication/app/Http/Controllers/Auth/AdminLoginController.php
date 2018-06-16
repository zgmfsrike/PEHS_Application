<?php
namespace App\Http\Controllers\Auth;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Auth;
use App\User;
class AdminLoginController extends Controller
{
    public function __construct()
    {
      $this->middleware('guest:admin',['except'=>['logout']]);    }
    public function login(Request $request)
    {
      // if($request->role == 1){
        $admin_username = User::where('username',$request->username)->where('role_id',1)->get();
        $admin_password = User::where('password',$request->password)->where('role_id',1)->get();
        //validate the form data
        $this->validate($request,[
        'username' => 'required',
        'password' => 'required|min:6',
        ]);
        //Attempt to log the user in
        if (Auth::guard('admin')->attempt(['username'=>$request->username,'password'=>$request->password,'role_id'=>1],$request->remember)) {
          //if successful, then redirect to theri intended location
          return redirect()->intended(route('admin.home'));
        }
          //if unsuccessful, then redirect back to the login with the form data and error message
          if($admin_username->isEmpty()){
            return redirect()->back()->withInput($request->only('username','remember'))->withInput($request->only('role','remember'))->withErrors([
                    'username' => 'Username is invalid ',
                ]);
          }else if($admin_password->isEmpty()){
            return redirect()->back()->withInput($request->only('username','remember'))->withInput($request->only('role','remember'))->withErrors([
                    'password' => 'Password is invalid ',
                ]);
          }
      // }

    }
    public function logout(Request $request)
    {
        Auth::guard('admin')->logout();
        $request->session()->invalidate();
        return redirect()->route('login');
    }
}
