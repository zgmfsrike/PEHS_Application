<?php

namespace App\Http\Controllers\Auth;
use Illuminate\Support\Facades\Input;
use App\User;
use App\Patient;
use DB;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;
use Illuminate\Foundation\Auth\RegistersUsers;
use Illuminate\Http\Request;
use Illuminate\Auth\Events\Registered;
class RegisterController extends Controller
{
  /*
  |--------------------------------------------------------------------------
  | Register Controller
  |--------------------------------------------------------------------------
  |
  | This controller handles the registration of new users as well as their
  | validation and creation. By default this controller uses a trait to
  | provide this functionality without requiring any additional code.
  |
  */

  use RegistersUsers;

  /**
  * Where to redirect users after registration.
  *
  * @var string
  */
  protected $redirectTo = '/';

  /**
  * Create a new controller instance.
  *
  * @return void
  */
  public function __construct()
  {
    $this->middleware('guest');
  }

  /**
  * Get a validator for an incoming registration request.
  *
  * @param  array  $data
  * @return \Illuminate\Contracts\Validation\Validator
  */
  protected function validator(array $data)
  {
    $name = Input::get('name');
    $surname = Input::get('surname');
    $email = Input::get('email');
    $patient_id = $this->checkPatientExist($name,$surname,$email);
    if($patient_id =="none"){
      $email_format ='required|string|email|max:255|unique:patients';
    }else{
      $email_format = 'required|string|email|max:255|';
    }

    return Validator::make($data, [
      'username' => 'required|string|max:255|unique:users',
      'email' => $email_format,
      'password' => 'required|string|min:6|confirmed',
      'role_id' => 'required|in:2,3,4',
      'name' => 'required|string',
      'surname' => 'required|string',
    ]);
  }

  /**
  * Create a new user instance after a valid registration.
  *
  * @param  array  $data
  * @return \App\User
  */
  protected function create(array $data)
  {
    $user_not_exist = false;
    $username = Input::get('username');
    $name = Input::get('name');
    $surname = Input::get('surname');
    $email = Input::get('email');
    $patient_id = $this->checkPatientExist($name,$surname,$email);
    if($patient_id == "none"){
      $patient_id = $this->getPatientId();
      $user_not_exist = true;
    }
    $user = User::create([
      'username' => $data['username'],
      'password' => Hash::make($data['password']),
      'role_id' => $data['role_id'],
      'user_id' =>$patient_id
    ]);
    if($user_not_exist == true){
      $get_role_name = DB::table('users')->join('roles','users.role_id','roles.role_id')->select('roles.role_name')->where('username',$username)->first();
      $role_name = $get_role_name->role_name;
      DB::table('patients')->insert([
        'user_id' => $patient_id,
        'name' => $role_name,
        'surname'=> $surname,
        'email'=>$email
      ]);
    }
    return $user;
  }

  public function getPatientId()
  {
      $query_raw = 'LENGTH(user_id) desc, `user_id` desc ';
      $get_current_id = DB::table('patients')->orderByRaw($query_raw)->first();
      if($get_current_id){
        $split_string = explode("p",$get_current_id->user_id);
        $current_id = intval($split_string[1]);
        $patient_id = "p".(++$current_id);
      }else{
        $patient_id = "p1";
      }
      return $patient_id;
    }


  public function checkPatientExist($name,$surname,$email)
  {
    $check_patient_exist = DB::table('patients')->select('user_id')->where('name',$name)
    ->where('surname',$surname)->where('email',$email)->first();
    if($check_patient_exist){
      $patient_id = $check_patient_exist->user_id;
    }else{
      $patient_id = "none";
    }
    return $patient_id;

  }




  public function register(Request $request)
  {
    $this->validator($request->all())->validate();

    event(new Registered($user = $this->create($request->all())));
    return $this->registered($request, $user)
    ?: redirect($this->redirectPath());
  }
}
