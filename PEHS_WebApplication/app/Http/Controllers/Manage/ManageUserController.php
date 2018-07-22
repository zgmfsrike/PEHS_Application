<?php

namespace App\Http\Controllers\Manage;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
use DB;
use App\UserInformation;
use Illuminate\Support\Facades\Hash;

class ManageUserController extends Controller
{
  //
  /**
  * Display a listing of the resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function getListUserPage($role)
  {

    switch ($role) {
      case 'doctors':
      $role_id = 2;
      break;

      case 'medical_staffs':
      $role_id = 3;
      break;

      case 'patients':
      $role_id = 4;
      break;

    }
    $users = DB::table('user_informations as ui')->join('user_roles as ur','ui.user_id','ur.user_id')->join('users as u','ui.user_id','u.user_id')->
    select('ui.name','ui.surname','ui.email','u.username','ui.user_id')->
    where('ur.role_id',$role_id)->paginate(10);

    return view('manage.list_user',['users'=>$users,'user_role'=>$role]);


  }

  public function searchUserByName(Request $request,$role)
  {
    $name = $request->input('search');
    $users = DB::table('user_informations as ui')->join("user_roles as ur",'ui.user_id','ur.user_id')->join('users as u','ui.user_id','u.user_id')->
    select('ui.user_id','ui.name','ui.surname','ui.email','u.username')->
    where('ui.name','like',$name.'%')->paginate(10);
    if(count($users) == 0){
      return view('manage.list_user',['users'=>$users,'user_role'=>$role,'search_value'=>$name])->with('not_found_user','Sorry!, not found the user name "'.$name.'"');
    }
    return view('manage.list_user',['users'=>$users,'user_role'=>$role,'search_value'=>$name]);


  }

  /**
  * Show the form for creating a new resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function getCreateUserPage($role)
  {
    $gender_list = DB::table('genders')->get();
    $blood_type_list = DB::table('blood_types')->get();
    return view('manage.create_user',['user_role'=>$role,'gender_list'=>$gender_list,'blood_type_list'=>$blood_type_list]);
  }

  /**
  * Store a newly created resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @return \Illuminate\Http\Response
  */
  public function storeUser(Request $request,$role)
  {
    $user_not_exist = false;
    $username = $request->input('username');
    $password = $request->input('password');

    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    $blood_type = $request->input('blood_type');
    $personal_id = $request->input('personal_id');
    $drug_allergy = $request->input('drug_allergy');
    $underlying_disease = $request->input('underlying_disease');

    switch ($role) {
      case 'patients':
      //set input for patient

      $role_id = 4;
      break;
      //set input for doctor
      case 'doctors':

      $role_id = 2;
      break;
      //set input for medical staff
      case 'medical_staffs':

      $role_id = 3;
      break;
    }



    $email_format ='required|string|email|max:100|unique:user_informations';

    $this->validate($request,  [
      'username' => 'required|string|min:4|unique:users|regex:/^[a-zA-Z0-9]+$/',
      'email' => $email_format,
      'password' => 'required|string|min:6|confirmed|regex:/^[a-zA-Z0-9]+$/',
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required',
      'blood_type'=>'required',
      'personal_id'=>'required|string|unique:user_informations|regex:/^[a-zA-Z0-9]+$/',
      'drug_allergy'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'underlying_disease'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
    ]);
    $information = array(
      'name' => $name,
      'surname'=> $surname,
      'email'=>$email,
      'date_of_birth' =>$date_of_birth,
      'address'=>$address,
      'telephone_number'=>$telephone_number,
      'gender'=>$gender,
      'blood_type'=>$blood_type,
      'personal_id'=>$personal_id,
      'drug_allergy'=>$drug_allergy,
      'underlying_disease'=>$underlying_disease,
    );
    DB::table('user_informations')->insert($information);
    $get_user_id = DB::table('user_informations')->select('user_id')->where('email',$email)->first();
    $id = $get_user_id->user_id;
    // }
    // else{
    //   $this->validate($request,  [
    //     'username' => 'required|string|min:4|unique:users|regex:/^[a-zA-Z0-9]+$/',
    //     'email' => $email_format,
    //     'password' => 'required|string|min:6|confirmed|regex:/^[a-zA-Z0-9]+$/',
    //     'name' => 'required|string|regex:/^[a-zA-Z]+$/',
    //     'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
    //     'date_of_birth' => 'required|date',
    //     'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
    //     'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
    //     'gender'=>'required|string',
    //   ]);
    //   $information = array(
    //     'user_id'=>$user_id,
    //     'name' => $name,
    //     'surname' => $surname,
    //     'email'=> $email,
    //     'date_of_birth' =>$date_of_birth,
    //     'address'=>$address,
    //     'telephone_number'=>$telephone_number,
    //     'gender'=>$gender,
    //   );
    // }

    User::insert([
      'username' => $username,
      'password' => Hash::make($password),
      'user_id'=>$id,
    ]);

    DB::table('user_roles')->insert([
      'user_id'=>$id,
      'role_id'=>$role_id,
    ]);

    // if($user_not_exist == true){

    // }
    // if(Auth()->check()){
    //   return redirect()->route('login')->with('register_success','Register successfully');
    // }
    // else{
    return redirect(route('admin.list_user',['role'=>$role]))->with('success','User created successfully.');
    // }

  }
  public function registerPatient(Request $request,$role)
  {
    $user_not_exist = false;
    $username = $request->input('username');
    $password = $request->input('password');

    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    $blood_type = $request->input('blood_type');
    $personal_id = $request->input('personal_id');
    $drug_allergy = $request->input('drug_allergy');
    $underlying_disease = $request->input('underlying_disease');

    switch ($role) {
      case 'patients':
      //set input for patient

      $role_id = 4;
      break;
      //set input for doctor
      case 'doctors':

      $role_id = 2;
      break;
      //set input for medical staff
      case 'medical_staffs':

      $role_id = 3;
      break;
    }


    // $check_user_exist = DB::table($role)->select('user_id')->where('name',$name)
    // ->where('surname',$surname)->first();

    // if($check_user_exist){
    //   //check that user already has information in database
    //   $id = $check_user_exist->user_id;
    //   $check_id_exist = DB::table('users')->select('user_id')->where('user_id',$id)->first();
    //   if($check_id_exist){
    //     return redirect()->back()->with('id_exist','Sorry, your account has been registerd.');
    //   }else{
    //     $user_id = $id;
    //   }
    //   $email_format = 'required|string|email|max:255|';
    // }else{
    //user does not has information, so we will add the user information to database
    // $user_not_exist = true;
    $email_format ='required|string|email|max:100|unique:user_informations';
    // $query_raw = 'LENGTH(user_id) desc, `user_id` desc ';
    // $get_current_id = DB::table($role)->orderByRaw($query_raw)->first();
    // if($get_current_id){
    //   $split_string = explode($title_id,$get_current_id->user_id);
    //   $current_id = intval($split_string[1]);
    //   $user_id = $title_id.(++$current_id);
    // }else{
    //   $user_id = $title_id."1";
    // }
    // }

    // if($role == "patients"){
    $this->validate($request,  [
      'username' => 'required|string|min:4|unique:users|regex:/^[a-zA-Z0-9]+$/',
      'email' => $email_format,
      'password' => 'required|string|min:6|confirmed|regex:/^[a-zA-Z0-9]+$/',
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required',
      'blood_type'=>'required',
      'personal_id'=>'required|string|unique:user_informations|regex:/^[a-zA-Z0-9]+$/',
      'drug_allergy'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'underlying_disease'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
    ]);
    $information = array(
      'name' => $name,
      'surname'=> $surname,
      'email'=>$email,
      'date_of_birth' =>$date_of_birth,
      'address'=>$address,
      'telephone_number'=>$telephone_number,
      'gender'=>$gender,
      'blood_type'=>$blood_type,
      'personal_id'=>$personal_id,
      'drug_allergy'=>$drug_allergy,
      'underlying_disease'=>$underlying_disease,
    );
    DB::table('user_informations')->insert($information);
    $get_user_id = DB::table('user_informations')->select('user_id')->where('email',$email)->first();
    $id = $get_user_id->user_id;
    // }
    // else{
    //   $this->validate($request,  [
    //     'username' => 'required|string|min:4|unique:users|regex:/^[a-zA-Z0-9]+$/',
    //     'email' => $email_format,
    //     'password' => 'required|string|min:6|confirmed|regex:/^[a-zA-Z0-9]+$/',
    //     'name' => 'required|string|regex:/^[a-zA-Z]+$/',
    //     'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
    //     'date_of_birth' => 'required|date',
    //     'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
    //     'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
    //     'gender'=>'required|string',
    //   ]);
    //   $information = array(
    //     'user_id'=>$user_id,
    //     'name' => $name,
    //     'surname' => $surname,
    //     'email'=> $email,
    //     'date_of_birth' =>$date_of_birth,
    //     'address'=>$address,
    //     'telephone_number'=>$telephone_number,
    //     'gender'=>$gender,
    //   );
    // }

    User::insert([
      'username' => $username,
      'password' => Hash::make($password),
      'user_id'=>$id,
    ]);

    DB::table('user_roles')->insert([
      'user_id'=>$id,
      'role_id'=>$role_id,
    ]);

    // if($user_not_exist == true){

    // }
    // if(Auth()->check()){
    return redirect()->route('login')->with('register_success','Register successfully');
    // }
    // else{
    // return redirect(route('admin.list_user',['role'=>$role]))->with('success','User created successfully.');
    // }

  }

  public function viewUserProfile($role,$id)
  {
    switch ($role) {
      case 'doctors':
      $role_id = 2;
      break;

      case 'medical_staffs':
      $role_id = 3;
      break;

      case 'patients':
      $role_id = 4;
      break;
    }

    // if($role == 'patients'){
    $user = DB::table('user_informations as ui')->join('user_roles as ur','ui.user_id','ur.user_id')->join('genders as g','ui.gender','g.gender_id')->
    select('ui.name','ui.surname','ui.email','ui.address','g.gender','ui.telephone_number',
    'ui.drug_allergy','ui.underlying_disease','ui.date_of_birth')
    ->where('ur.role_id',$role_id)->where('ui.user_id',$id)->get();
    // }
    // else{
    //   $user = DB::table('users')->join($role.' as r','users.user_id','r.user_id')->
    //   select('r.user_id','r.name','r.surname','r.email','r.date_of_birth','r.gender','r.address','r.telephone_number')
    //   ->where('users.role_id',$role_id)->where('users.user_id',$id)->get();
    // }
    return view('manage.view_profile',['users'=>$user,'user_role'=>$role,'user_id'=>$id]);
  }



  /**
  * Show the form for editing the specified resource.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function getEditUserPage($role,$id)
  {
    switch ($role) {
      case 'doctors':
      $role_id = 2;
      break;

      case 'medical_staffs':
      $role_id = 3;
      break;

      case 'patients':
      $role_id = 4;
      break;
    }
    $gender_list = DB::table('genders')->get();
    // if($role == 'patients'){
    $user = DB::table('user_informations as ui')->join('user_roles as ur','ui.user_id','ur.user_id')->join('genders as g','ui.gender','g.gender_id')->
    select('ui.name','ui.surname','ui.email','ui.address','g.gender','ui.telephone_number',
    'ui.drug_allergy','ui.underlying_disease','ui.date_of_birth')
    ->where('ur.role_id',$role_id)->where('ui.user_id',$id)->get();
    // }
    // else{
    //   $user = DB::table('users')->join($role.' as r','users.user_id','r.user_id')->
    //   select('r.user_id','r.name','r.surname','r.email','r.date_of_birth','r.gender','r.address','r.telephone_number')
    //   ->where('users.role_id',$role_id)->where('users.user_id',$id)->get();
    // }
    return view('manage.edit_user',['users'=>$user,'user_role'=>$role,'user_id'=>$id,'gender_list'=>$gender_list]);
  }

  /**
  * Update the specified resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  //admin update user profile
  public function updateUser(Request $request,$role, $id)
  {
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    $blood_type = $request->input('blood_type');
    $personal_id = $request->input('personal_id');
    $drug_allergy = $request->input('drug_allergy');
    $underlying_disease = $request->input('underlying_disease');
    $user = UserInformation::find($id);
    $this->validate($request,[
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required',
      'drug_allergy'=>'nullable|regex:/([- ,\/0-9a-zA-Z]+)/',
      'underlying_disease'=>'nullable|regex:/([- ,\/0-9a-zA-Z]+)/',

    ]);

    $user->name = $name;
    $user->surname = $surname;
    $user->date_of_birth = $date_of_birth;
    $user->address = $address;
    $user->telephone_number = $telephone_number;
    $user->gender = $gender;
    $user->drug_allergy = $drug_allergy;
    $user->underlying_disease = $underlying_disease;
    $user->save();
    return redirect(route('admin.list_user',['role'=>$role]))->with('success','Update information successfully.');
  }
  //user update their profile
  public function updateProfile(Request $request,$role, $id)
  {
    switch ($role) {
      case 'doctors':
      $route = "doctor.view_profile";
      break;

      case 'medical_staffs':
      $route = "medical_staff.view_profile";
      break;
    }
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    $blood_type = $request->input('blood_type');
    $personal_id = $request->input('personal_id');
    $drug_allergy = $request->input('drug_allergy');
    $underlying_disease = $request->input('underlying_disease');
    $user = UserInformation::find($id);
    $this->validate($request,[
      'name' => 'required|string|regex:/^[a-zA-Z]+$/',
      'surname' => 'required|string|regex:/^[a-zA-Z]+$/',
      'date_of_birth' => 'required|date',
      'address' => 'required|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'telephone_number'=> 'required|string|regex:/^[0-9]+$/',
      'gender'=>'required|string',
      'drug_allergy'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'underlying_disease'=>'nullable|regex:/([- ,\/0-9a-zA-Z]+)/',

    ]);

    $user->name = $name;
    $user->surname = $surname;
    $user->date_of_birth = $date_of_birth;
    $user->address = $address;
    $user->telephone_number = $telephone_number;
    $user->gender = $gender;
    $user->drug_allergy = $drug_allergy;
    $user->underlying_disease = $underlying_disease;
    $user->save();

    return redirect(route($route,['role'=>$role,'user_id'=>$id]))->with('success','Update information successfully.');
  }


  /**
  * Remove the specified resource from storage.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function deleteUser($role,$id)
  {
    $delete_user_role = DB::table('user_roles')->where('user_id',$id)->delete();
    $delete_from_user_table = DB::table('users')->where('user_id',$id)->delete();
    $user = UserInformation::find($id);
    $user->delete();
    return redirect(route('admin.list_user',['role'=>$role]))->with('success','Delete user successfully.');

  }


}
