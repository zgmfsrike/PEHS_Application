<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Auth;
use App\User;
use DB;
class AdminController extends Controller
{
  // public function __construct()
  // {
  //   $this->middleware('auth:admin');
  // }
  /**
  * Display a listing of the resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function index()
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



}
