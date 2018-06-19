<?php

namespace App\Http\Controllers\Manage;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
use DB;
use App\Doctor;
use Illuminate\Support\Facades\Hash;

class ManageDoctorController extends Controller
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
  public function showListDoctor()
  {
    //List Doctor
    $doctors = $this->getDoctorList();
    return view('manage.list_user',['users'=>$doctors,'user_role'=>'doctor']);

  }

  /**
  * Show the form for creating a new resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function createDoctor()
  {
    return view('manage.create_user',['user_role'=>'doctor']);
  }

  /**
  * Store a newly created resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @return \Illuminate\Http\Response
  */
  public function storeDoctor(Request $request)
  {
    $user_not_exist = false;
    $username = $request->input('username');
    $password = $request->input('password');
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $doctor_id = $this->checkDoctorExist($name, $surname, $email);
    if($doctor_id =="none"){
      $email_format ='required|string|email|max:255|unique:doctors';
      $doctor_id = $this->getDoctorId();
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
      'user_id'=>$doctor_id,
      'role_id'=> 2,
    ]);
    if($user_not_exist == true){
      DB::table('doctors')->insert([
        'user_id'=>$doctor_id,
        'name' => $name,
        'surname' => $surname,
        'email'=> $email,
      ]);
    return $this->showListDoctor();


    }
  }

  

  /**
  * Show the form for editing the specified resource.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function editDoctor($id)
  {
      $doctors = $this->getDoctorById($id);
      return view('manage.edit_user',['users'=>$doctors,'user_id'=>$id,'user_role'=>'doctor']);
  }

  /**
  * Update the specified resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function updateDoctor(Request $request, $id)
  {
    $name = $request->input('name');
    $surname = $request->input('surname');

    $this->validate($request,[
      'name' => 'required|string',
      'surname' => 'required|string',
    ]);
    $doctor = Doctor::find($id);
    $doctor->name = $name;
    $doctor->surname = $surname;
    $doctor->save();
    return $this->showListdoctor();


  }

  /**
  * Remove the specified resource from storage.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function deleteDoctor($id)
  {
    $doctor = Doctor::find($id);
    $doctor->delete();

    $user = DB::table('users')->where('user_id',$id)->delete();

    return $this->showListDoctor();
  }
  public function getDoctorList()
  {
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')->
    select('doctors.user_id','doctors.name','doctors.surname','doctors.email')->where('users.role_id',2)->get();
    return $doctor;
  }
  public function getDoctorId()
  {
      $query_raw = 'LENGTH(user_id) desc, `user_id` desc ';
      $get_current_id = DB::table('doctors')->orderByRaw($query_raw)->first();
      if($get_current_id){
        $split_string = explode("d",$get_current_id->user_id);
        $current_id = intval($split_string[1]);
        $doctor_id = "d".(++$current_id);
      }else{
        $doctor_id = "d1";
      }
      return $doctor_id;
    }
  public function getDoctorById($id)
  {
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')->
    select('doctors.name','doctors.surname','doctors.email')->where('users.role_id',2)->where('users.user_id',$id)->get();
    return $doctor;
  }
  public function checkDoctorExist($name,$surname,$email)
  {
    $check_doctor_exist = DB::table('doctors')->select('user_id')->where('name',$name)
    ->where('surname',$surname)->where('email',$email)->first();
    if($check_doctor_exist){
      $doctor_id = $check_doctor_exist->user_id;
    }else{
      $doctor_id = "none";
    }
    return $doctor_id;

  }
}
