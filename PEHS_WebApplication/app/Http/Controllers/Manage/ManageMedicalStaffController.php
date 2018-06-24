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

  public function searchMedicalStaffByName(Request $request)
  {
    $name = $request->input('search');
    $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')->
    select('medical_staffs.user_id','medical_staffs.name','medical_staffs.surname','medical_staffs.email','users.username')->
    where('medical_staffs.name', 'like',$name.'%')->paginate(10);
    return view('manage.list_user',['users'=>$medical_staff,'user_role'=>'medical_staff','search_value'=>$name]);

  }

  public function viewMedicalStaffProfile($id)
  {
    $medical_staff = $this->getMedicalStaffById($id);
    return view('manage.view_profile',['users'=>$medical_staff,'user_role'=>'medical_staff']);
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
    //---------------------------users table---------------------
    $username = $request->input('username');
    $password = $request->input('password');
    //-------------------------------------------------------------

    //----------------------------medical staffs table-----------------------
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    //-------------------------------------------------------------------
    $medical_staff_id = $this->checkMedicalStaffExist($name, $surname);
    if($medical_staff_id =="none"){
      $email_format ='required|string|email|max:255|unique:medical_staffs';
      $medical_staff_id = $this->getMedicalStaffId();
      $user_not_exist = true;
    }elseif($medical_staff_id =="exist"){
      return redirect(route('admin.create_medical_staff'))->with('id_exist','Sorry, your account has been registerd.');
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
      'user_id'=>$medical_staff_id,
      'role_id'=> 3,
    ]);
    if($user_not_exist == true){
      DB::table('medical_staffs')->insert([
        'user_id'=>$medical_staff_id,
        'name' => $name,
        'surname' => $surname,
        'email'=> $email,
        'date_of_birth' =>$date_of_birth,
        'address'=>$address,
        'telephone_number'=>$telephone_number,
        'gender'=>$gender,
      ]);

    }
    return redirect(route('admin.list_medical_staff'))->with('success','Medical Staff created successfully.');
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
    $medical_staff = MedicalStaff::find($id);
    $medical_staff->name = $name;
    $medical_staff->surname = $surname;
    $medical_staff->date_of_birth = $date_of_birth;
    $medical_staff->address = $address;
    $medical_staff->telephone_number = $telephone_number;
    $medical_staff->gender = $gender;
    $medical_staff->save();
    return redirect(route('admin.list_medical_staff'))->with('success','Update information successfully.');


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

    return redirect(route('admin.list_medical_staff'))->with('success','Delete Medical Staff successfully.');

  }
  public function getMedicalStaffList()
  {
    $query_raw = "LENGTH(users.user_id) desc";
    $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')->
    select('medical_staffs.user_id','medical_staffs.name','medical_staffs.surname','medical_staffs.email','users.username')->orderByRaw($query_raw)->orderBy('users.user_id')
    ->where('users.role_id',3)->paginate(10);
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
    select('medical_staffs.user_id','medical_staffs.name','medical_staffs.surname','medical_staffs.email','medical_staffs.date_of_birth','medical_staffs.gender',
    'medical_staffs.address','medical_staffs.telephone_number')
    ->where('users.role_id',3)->where('users.user_id',$id)->get();
    return $medical_staff;
  }
  public function checkMedicalStaffExist($name,$surname)
  {
    $check_medical_staff_exist = DB::table('medical_staffs')->select('user_id')->where('name',$name)
    ->where('surname',$surname)->first();
    if($check_medical_staff_exist){
      $user_id = $check_medical_staff_exist->user_id;
      $medical_staff_id = $this->checkUserIdExist($user_id);
    }else{
      $medical_staff_id = "none";
    }
    return $medical_staff_id;

  }

  public function checkUserIdExist($id)
  {
    $check_id_exist = DB::table('users')->select('user_id')->where('user_id',$id)->first();
    if($check_id_exist){
      $medical_staff_id = "exist";

    }else{
      $medical_staff_id = $id;
    }
    return $medical_staff_id;
  }
}
