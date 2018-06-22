<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Auth;
use App\User;
use DB;
use App\Doctor;
class DoctorController extends Controller
{
  public function __construct()
  {
    $this->middleware('auth:doctor');
  }
  /**
  * Show the application dashboard.
  *
  * @return \Illuminate\Http\Response
  */
  public function index()
  {
    $doctor_id = $this->getDoctorId();
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')
    ->select('doctors.name','doctors.surname')->where('users.user_id',$doctor_id)->get();
    // return view('admin',compact('admins'));
    return view('doctor.doctor',["doctor"=>$doctor]);;
  }

  public function profile()
  {
    $doctor_id = $this->getDoctorId();
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')->
    select('doctors.user_id','doctors.name','doctors.surname','doctors.email','doctors.date_of_birth','doctors.gender','doctors.address','doctors.telephone_number')
    ->where('users.role_id',2)->where('users.user_id',$doctor_id)->get();
    return view('manage.view_profile',['users'=>$doctor,'user_role'=>'doctor','user_id'=>$doctor_id]);
  }

  public function editProfile($id)
  {
    $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')->
    select('doctors.user_id','doctors.name','doctors.surname','doctors.email','doctors.date_of_birth','doctors.gender','doctors.address','doctors.telephone_number')
    ->where('users.role_id',2)->where('users.user_id',$id)->get();
    return view('manage.edit_user',['users'=>$doctor,'user_id'=>$id,'user_role'=>'doctor']);
  }

  public function updateProfile(Request $request, $id)
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
    return redirect(route('doctor.profile'));
  }

  public function getDoctorId()
  {
    $id = Auth::id();
    $get_user_id = DB::table('users')->select('user_id')->where('id',$id)->first();
    $doctor_id = $get_user_id->user_id;
    return $doctor_id;
  }


}
