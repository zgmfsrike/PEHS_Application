<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Auth;
use DB;
use App\MedicalStaff;
class MedicalStaffController extends Controller
{
    public function __construct()
    {
    $this->middleware('auth:medical_staff');
    }
    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        // $user = User::where('id', $userid)->first();
        $medical_staff_id = $this->getMedicalStaffId();
        $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')
        ->select('medical_staffs.name','medical_staffs.surname')->where('users.user_id',$medical_staff_id)->get();
        // return view('admin',compact('admins'));
        return view('medical_staff.medical_staff',["medical_staff"=>$medical_staff]);;
    }

    public function profile()
    {
      $medical_staff_id = $this->getMedicalStaffId();
      $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')->
      select('medical_staffs.user_id','medical_staffs.name','medical_staffs.surname','medical_staffs.email','medical_staffs.date_of_birth','medical_staffs.gender',
      'medical_staffs.address','medical_staffs.telephone_number')
      ->where('users.role_id',3)->where('users.user_id',$medical_staff_id)->get();
      return view('manage.view_profile',['users'=>$medical_staff,'user_role'=>'medical_staff','user_id'=>$medical_staff_id]);
    }

    public function editProfile($id)
    {
      $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')->
      select('medical_staffs.user_id','medical_staffs.name','medical_staffs.surname','medical_staffs.email','medical_staffs.date_of_birth','medical_staffs.gender',
      'medical_staffs.address','medical_staffs.telephone_number')
      ->where('users.role_id',3)->where('users.user_id',$id)->get();
      return view('manage.edit_user',['users'=>$medical_staff,'user_id'=>$id,'user_role'=>'medical_staff']);

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
      $medical_staff = MedicalStaff::find($id);
      $medical_staff->name = $name;
      $medical_staff->surname = $surname;
      $medical_staff->date_of_birth = $date_of_birth;
      $medical_staff->address = $address;
      $medical_staff->telephone_number = $telephone_number;
      $medical_staff->gender = $gender;
      $medical_staff->save();
      return redirect(route('medical_staff.profile'));

    }

    public function getMedicalStaffId()
    {
      $id = Auth::id();
      $get_user_id = DB::table('users')->select('user_id')->where('id',$id)->first();
      $medical_staff_id = $get_user_id->user_id;

      return $medical_staff_id;

    }
}
