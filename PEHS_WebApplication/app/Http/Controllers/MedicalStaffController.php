<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Auth;
use App\User;
use DB;
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
        $id = Auth::id();
        $get_user_id = DB::table('users')->select('user_id')->where('id',$id)->first();
        $user_id = $get_user_id->user_id;
        $medical_staff = DB::table('users')->join('medical_staffs','users.user_id','medical_staffs.user_id')
        ->select('medical_staffs.name','medical_staffs.surname')->where('users.user_id',$user_id)->get();
        // return view('admin',compact('admins'));
        return view('medical_staff.medical_staff',["medical_staff"=>$medical_staff]);;
    }
}
