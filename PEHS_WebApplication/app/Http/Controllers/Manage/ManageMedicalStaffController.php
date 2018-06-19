<?php

namespace App\Http\Controllers\Manage;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
use DB;
use App\MedicalStaff;
use Illuminate\Support\Facades\Hash;

class ManageMedicalStaffController extends Controller
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
  public function showListMedicalStaff()
  {
    //List Doctor
    $medical_staff = $this->getMedicalStaffList();
    return view('manage.list_user',['users'=>$medical_staff,'user_role'=>'medical_staff']);

  }

  /**
  * Show the form for creating a new resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function createMedicalStaff()
  {
    return view('manage.create_user',['user_role'=>'medical_staff']);
  }

  /**
  * Store a newly created resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @return \Illuminate\Http\Response
  */
  public function storeMedicalStaff(Request $request)
  {
    $user_not_exist = false;
    $username = $request->input('username');
    $password = $request->input('password');
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $medical_staff_id = $this->checkMedicalStaffExist($name, $surname, $email);
    if($medical_staff_id =="none"){
      $email_format ='required|string|email|max:255|unique:medical_staffs';
      $medical_staff_id = $this->getMedicalStaffId();
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
      'user_id'=>$medical_staff_id,
      'role_id'=> 3,
    ]);
    if($user_not_exist == true){
      DB::table('medical_staffs')->insert([
        'user_id'=>$medical_staff_id,
        'name' => $name,
        'surname' => $surname,
        'email'=> $email,
      ]);
      return $this->showListMedicalStaff();


    }
  }



  /**
  * Show the form for editing the specified resource.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function editMedicalStaff($id)
  {
    $medical_staffs = $this->getMedicalStaffById($id);
    return view('manage.edit_user',['users'=>$medical_staffs,'user_id'=>$id,'user_role'=>'medical_staff']);
  }

  /**
  * Update the specified resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function updateMedicalStaff(Request $request, $id)
  {
    $name = $request->input('name');
    $surname = $request->input('surname');

    $this->validate($request,[
      'name' => 'required|string',
      'surname' => 'required|string',
    ]);
    $medical_staff = MedicalStaff::find($id);
    $medical_staff->name = $name;
    $medical_staff->surname = $surname;
    $medical_staff->save();
    return $this->showListMedicalStaff();


  }

  /**
  * Remove the specified resource from storage.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function deleteMedicalStaff($id)
  {
    $medical_staff = MedicalStaff::find($id);
    $medical_staff->delete();

    $user = DB::table('users')->where('user_id',$id)->delete();

    return $this->showListMedicalStaff();
  }
  public function getMedicalStaffList()
  {
    $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')->
    select('medical_staffs.user_id','medical_staffs.name','medical_staffs.surname','medical_staffs.email')->where('users.role_id',3)->get();
    return $medical_staff;
  }
  public function getMedicalStaffId()
  {
    $query_raw = 'LENGTH(user_id) desc, `user_id` desc ';
    $get_current_id = DB::table('medical_staffs')->orderByRaw($query_raw)->first();
    if($get_current_id){
      $split_string = explode("m",$get_current_id->user_id);
      $current_id = intval($split_string[1]);
      $medical_staff_id = "m".(++$current_id);
    }else{
      $medical_staff_id = "m1";
    }
    return $medical_staff_id;
  }
  public function getMedicalStaffById($id)
  {
    $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')->
    select('medical_staffs.name','medical_staffs.surname','medical_staffs.email')->where('users.role_id',3)->where('users.user_id',$id)->get();
    return $medical_staff;
  }
  public function checkMedicalStaffExist($name,$surname,$email)
  {
    $check_medical_staff_exist = DB::table('medical_staffs')->select('user_id')->where('name',$name)
    ->where('surname',$surname)->where('email',$email)->first();
    if($check_medical_staff_exist){
      $medical_staff_id = $check_medical_staff_exist->user_id;
    }else{
      $medical_staff_id = "none";
    }
    return $medical_staff_id;

  }
}
