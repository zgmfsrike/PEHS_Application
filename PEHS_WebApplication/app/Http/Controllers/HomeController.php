<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Auth;
use DB;
use App\User;
class HomeController extends Controller
{

  public function getAdminHomepage()
  {
    // $user = User::where('id', $userid)->first();
    $id = Auth::id();
    $get_user_id = User::select('user_id')->where('id',$id)->first();
    $user_id = $get_user_id->user_id;
    $admin = DB::table('users')->join('admins','users.user_id','admins.user_id')
    ->select('admins.name','admins.surname')->where('users.user_id',$user_id)->get();
    // return view('admin',compact('admins'));
    return view('admin.home',["admin"=>$admin]);;
  }


  /**
  * Show the application dashboard.
  *
  * @return \Illuminate\Http\Response
  */
  public function getDoctorHomepage()
  {
    $id = Auth::id();
    $get_user_id = User::select('user_id')->where('id',$id)->first();
    $doctor_id = $get_user_id->user_id;
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')
    ->select('doctors.name','doctors.surname')->where('users.user_id',$doctor_id)->get();
    return view('doctor.home',["users"=>$doctor,'user_role'=>'doctors','user_id'=>$doctor_id]);
  }

  public function getMedicalStaffHomepage()
  {
      // $user = User::where('id', $userid)->first();
      $id = Auth::id();
      $get_user_id = DB::table('users')->select('user_id')->where('id',$id)->first();
      $medical_staff_id = $get_user_id->user_id;
      $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')
      ->select('medical_staffs.name','medical_staffs.surname')->where('users.user_id',$medical_staff_id)->get();
      // return view('admin',compact('admins'));
      return view('medical_staff.home',["users"=>$medical_staff,'user_role'=>'medical_staffs','user_id'=>$medical_staff_id]);
  }


}
