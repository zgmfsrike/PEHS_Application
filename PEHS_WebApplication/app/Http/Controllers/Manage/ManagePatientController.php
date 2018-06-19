<?php

namespace App\Http\Controllers\Manage;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
use DB;
use App\Patient;
use Illuminate\Support\Facades\Hash;

class ManagePatientController extends Controller
{
  public function __construct()
  {
    $this->middleware('auth:admin');
  }
  /**
  * Display a listing of the resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function showListPatient()
  {
    //List Doctor
    $patients = $this->getPatientList();
    return view('manage.list_user',['users'=>$patients,'user_role'=>'patient']);

  }

  /**
  * Show the form for creating a new resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function createPatient()
  {
    return view('manage.create_user',['user_role'=>'patient']);
  }

  /**
  * Store a newly created resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @return \Illuminate\Http\Response
  */
  public function storePatient(Request $request)
  {
    $user_not_exist = false;
    $username = $request->input('username');
    $password = $request->input('password');
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $patient_id = $this->checkPatientExist($name, $surname, $email);
    if($patient_id =="none"){
      $email_format ='required|string|email|max:255|unique:patients';
      $patient_id = $this->getPatientId();
      $user_not_exist = true;
    }else{
      $email_format = 'required|string|email|max:255|';
    }

    $this->validate($request,  [
      'username' => 'required|string|max:255|unique:users',
      'email' => $email_format,
      'password' => 'required|string|min:6|confirmed',
      'name' => 'required|string',
      'surname' => 'required|string',
    ]);
    DB::table('users')->insert([
      'username' => $username,
      'password' => Hash::make($password),
      'user_id'=>$patient_id,
      'role_id'=> 4,
    ]);
    if($user_not_exist == true){
      DB::table('patients')->insert([
        'user_id'=>$patient_id,
        'name' => $name,
        'surname' => $surname,
        'email'=> $email,
      ]);
      return $this->showListPatient();
    }
  }



  /**
  * Show the form for editing the specified resource.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function editPatient($id)
  {
    $patients = $this->getPatientById($id);
    return view('manage.edit_user',['users'=>$patients,'user_id'=>$id,'user_role'=>'patient']);
  }

  /**
  * Update the specified resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function updatePatient(Request $request, $id)
  {
    $name = $request->input('name');
    $surname = $request->input('surname');

    $this->validate($request,[
      'name' => 'required|string',
      'surname' => 'required|string',
    ]);
    $patient = Patient::find($id);
    $patient->name = $name;
    $patient->surname = $surname;
    $patient->save();
    return $this->showListPatient();


  }

  /**
  * Remove the specified resource from storage.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function deletePatient($id)
  {
    $patient = Patient::find($id);
    $patient->delete();

    $user = DB::table('users')->where('user_id',$id)->delete();

    return $this->showListPatient();
  }
  public function getPatientList()
  {
    $patient = DB::table('users')->join('patients','users.user_id','patients.user_id')->
    select('patients.user_id','patients.name','patients.surname','patients.email')->where('users.role_id',4)->get();
    return $patient;
  }
  public function getPatientId()
  {
    $query_raw = 'LENGTH(user_id) desc, `user_id` desc ';
    $get_current_id = DB::table('patients')->orderByRaw($query_raw)->first();
    if($get_current_id){
      $split_string = explode("p",$get_current_id->user_id);
      $current_id = intval($split_string[1]);
      $patients_id = "p".(++$current_id);
    }else{
      $patients_id = "p1";
    }
    return $patients_id;
  }
  public function getPatientById($id)
  {
    $patient = DB::table('users')->join('patients','users.user_id','patients.user_id')->
    select('patients.name','patients.surname','patients.email')->where('users.role_id',4)->where('users.user_id',$id)->get();
    return $patient;
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
}
