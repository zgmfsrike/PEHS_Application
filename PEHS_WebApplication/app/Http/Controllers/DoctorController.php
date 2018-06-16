<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Auth;
use App\User;
use DB;
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
        // $user = User::where('id', $userid)->first();
        $id = Auth::id();
        $get_user_id = DB::table('users')->select('user_id')->where('id',$id)->first();
        $user_id = $get_user_id->user_id;
        $doctor = DB::table('users')->join('doctors','users.user_id','doctors.user_id')
        ->select('doctors.name','doctors.surname')->where('users.user_id',$user_id)->get();
        // return view('admin',compact('admins'));
        return view('doctor.doctor',["doctor"=>$doctor]);;
    }


}
