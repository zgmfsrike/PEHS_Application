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
      'username' => 'required|string|min:4|unique:users|regex:/^[a-zA-Z0-9]+$/',
      'email' => $email_format,
      'password' => 'required|string|min:6|confirmed|regex:/^[a-zA-Z0-9]+$/',
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required|string',
      'blood_type'=>'required|',
      'personal_id'=>'required|string|regex:/^[a-zA-Z0-9]+$/',
      'drug_allergy'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'underlying_disease'=>'nullable|regex:/([- ,\/0-9a-zA-Z]+)/',

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
    //---------------users table------------------------------------
    $username = Input::get('username');
    $name = Input::get('name');
    //--------------------------------------------------------------

    //---------------------patients table--------------------------------
    $surname = Input::get('surname');
    $email = Input::get('email');
    $date_of_birth = Input::get('date_of_birth');
    $address = Input::get('address');
    $telephone_number = Input::get('telephone_number');
    $gender = Input::get('gender');
    $blood_type = Input::get('blood_type');
    $personal_id = Input::get('personal_id');
    $drug_allergy = Input::get('drug_allergy');
    $underlying_disease = Input::get('underlying_disease');
    $patient_id = $this->checkPatientExist($name,$surname,$email);
    $patient_role = 4;
    if($patient_id == "none"){
      $patient_id = $this->getPatientId();
      $user_not_exist = true;
    }
    $user = User::create([
      'username' => $data['username'],
      'password' => Hash::make($data['password']),
      'role_id' => $patient_role,
      'user_id' =>$patient_id
    ]);
    if($user_not_exist == true){
      // $get_role_name = DB::table('users')->join('roles','users.role_id','roles.role_id')->select('roles.role_name')->where('username',$username)->first();
      // $role_name = $get_role_name->role_name;
      DB::table('patients')->insert([
        'user_id' => $patient_id,
        'name' => $name,
        'surname'=> $surname,
        'email'=>$email,
        'date_of_birth' =>$date_of_birth,
        'address'=>$address,
        'telephone_number'=>$telephone_number,
        'gender'=>$gender,
        'blood_type'=>$blood_type,
        'personal_id'=>$personal_id,
        'drug_allergy'=>$drug_allergy,
        'underlying_disease'=>$underlying_disease,
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
