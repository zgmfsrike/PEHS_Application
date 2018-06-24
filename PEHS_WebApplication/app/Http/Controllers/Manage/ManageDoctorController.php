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

  public function searchDoctorByName(Request $request)
  {
    $name = $request->input('search');
    $doctors = DB::table('users')->join('doctors','doctors.user_id','users.user_id')->
    select('doctors.user_id','doctors.name','doctors.surname','doctors.email','users.username')->
    where('doctors.name', 'like',$name.'%')->paginate(10);
    if(count($doctors) == 0){
      return view('manage.list_user',['users'=>$doctors,'user_role'=>'doctor','search_value'=>$name])->with('not_found_user','Sorry!, not found the user name "'.$name.'"');
    }
    return view('manage.list_user',['users'=>$doctors,'user_role'=>'doctor','search_value'=>$name]);
    // return redirect(route('admin.list_doctor'))->with('success','Doctor Created!');

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
    //---------------------------users table---------------------
    $username = $request->input('username');
    $password = $request->input('password');
    //-------------------------------------------------------------

    //----------------------------doctors table-----------------------
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    //-------------------------------------------------------------------
    $doctor_id = $this->checkDoctorExist($name, $surname, $email);
    if($doctor_id =="none"){
      $email_format ='required|string|email|max:255|unique:doctors';
      $doctor_id = $this->getDoctorId();
      $user_not_exist = true;
    }elseif($doctor_id == "exist"){
      return redirect(route('admin.create_doctor'))->with('id_exist','Sorry, your account has been registerd!');

    }else{
      $email_format = 'required|string|email|max:255|';
    }

    $this->validate($request,  [
      'username' => 'required|string|min:4|unique:users|regex:/^[a-zA-Z0-9]+$/',
      'email' => $email_format,
      'password' => 'required|string|min:6|confirmed|regex:/^[a-zA-Z0-9]+$/',
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required|string',
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
        'date_of_birth' =>$date_of_birth,
        'address'=>$address,
        'telephone_number'=>$telephone_number,
        'gender'=>$gender,
      ]);
    }
    return redirect(route('admin.list_doctor'))->with('success','Doctor Created!');
  }

  public function viewDoctorProfile($id)
  {
    $doctors = $this->getDoctorById($id);
    return view('manage.view_profile',['users'=>$doctors,'user_role'=>'doctor']);
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
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');

    $this->validate($request,[
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required|string',
    ]);
    $doctor = Doctor::find($id);
    $doctor->name = $name;
    $doctor->surname = $surname;
    $doctor->date_of_birth = $date_of_birth;
    $doctor->address = $address;
    $doctor->telephone_number = $telephone_number;
    $doctor->gender = $gender;
    $doctor->save();
    return redirect(route('admin.list_doctor'))->with('success','Update information succesful!');


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
    return redirect(route('admin.list_doctor'))->with('success','Delete Doctor succesful!');
  }
  public function getDoctorList()
  {
    $query_raw = "LENGTH(users.user_id) desc";
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')->
    select('doctors.user_id','doctors.name','doctors.surname','doctors.email','users.username')->orderByRaw($query_raw)->orderBy('users.user_id')
    ->where('users.role_id',2)->paginate(10);
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
    select('doctors.user_id','doctors.name','doctors.surname','doctors.email','doctors.date_of_birth','doctors.gender','doctors.address','doctors.telephone_number')
    ->where('users.role_id',2)->where('users.user_id',$id)->get();
    return $doctor;
  }
  public function checkDoctorExist($name,$surname,$email)
  {
    $check_doctor_exist = DB::table('doctors')->select('user_id')->where('name',$name)
    ->where('surname',$surname)->where('email',$email)->first();
    if($check_doctor_exist){
      $user_id = $check_doctor_exist->user_id;
      $doctor_id = $this->checkUserIdExist($user_id);
    }else{
      $doctor_id = "none";
    }
    return $doctor_id;

  }
  public function checkUserIdExist($id)
  {
    $check_id_exist = DB::table('users')->select('user_id')->where('user_id',$id)->first();
    if($check_id_exist){
      $doctor_id = "exist";
      return $doctor_id;
    }
  }
}
