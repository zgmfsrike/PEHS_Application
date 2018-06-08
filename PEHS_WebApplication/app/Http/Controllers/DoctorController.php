<?php

namespace App\Http\Controllers;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Doctor;
use Auth;
class DoctorController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */

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
        $doctors = Doctor::where('doctor_id',$id)->get();
        return view('doctor',compact('doctors'));
    }

    public function listDoctor()
    {
      $list_doctors = Doctor::orderBy('doctor_id','asc')->paginate(10);
      return view('doctors.list-doctor')->with('list_doctors',$list_doctors);
    }
}
