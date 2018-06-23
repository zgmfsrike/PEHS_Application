<?php

namespace App\Http\Controllers\Manage;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Auth;
use App\User;
use DB;
use App\Patient;
use Illuminate\Support\Facades\Hash;

class ManagePatientController extends Controller
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
  public function showListPatient()
  {
    //List Doctor
    $patients = $this->getPatientList();
    return view('manage.list_user',['users'=>$patients,'user_role'=>'patient']);

  }

  public function searchPatientByName(Request $request)
  {
    $name = $request->input('search');
    $patients = DB::table('users')->join('patients','users.user_id','patients.user_id')->
    select('patients.user_id','patients.name','patients.surname','patients.email','users.username')->
    where('patients.name', 'like',$name.'%')->paginate(10);
    return view('manage.list_user',['users'=>$patients,'user_role'=>'patient','search_value'=>$name]);

  }

  public function viewPatientProfile($id)
  {
    $patients = $this->getPatientById($id);
    return view('manage.view_profile',['users'=>$patients,'user_role'=>'patient']);


  }

  /**
  * Show the form for creating a new resource.
  *
  * @return \Illuminate\Http\Response
  */
  public function createPatient()
  {
    return view('manage.create_user',['user_role'=>'patient']);
  }

  /**
  * Store a newly created resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @return \Illuminate\Http\Response
  */
  public function storePatient(Request $request)
  {
    $user_not_exist = false;
    //---------------------------users table---------------------
    $username = $request->input('username');
    $password = $request->input('password');
    //-------------------------------------------------------------

    //----------------------------patients table-----------------------
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

    //-------------------------------------------------------------
    $patient_id = $this->checkPatientExist($name, $surname, $email);
    if($patient_id =="none"){
      $email_format ='required|string|email|max:255|unique:patients';
      $patient_id = $this->getPatientId();
      $user_not_exist = true;
    }elseif($patient_id == "exist"){
      return redirect(route('admin.create_patient'))->with('id_exist','Sorry, your account has been registerd!');

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
      'blood_type'=>'required|string|regex:/^[a-zA-Z+-]+$/',
      'personal_id'=>'required|string|regex:/^[a-zA-Z0-9]+$/',
      'drug_allergy'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
      'underlying_disease'=>'nullable|string|regex:/([- ,\/0-9a-zA-Z]+)/',
    ]);
    DB::table('users')->insert([
      'username' => $username,
      'password' => Hash::make($password),
      'user_id'=>$patient_id,
      'role_id'=> 4,
    ]);
    if($user_not_exist == true){
      DB::table('patients')->insert([
        'user_id' => $patient_id,
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
      ]);

    }
    return redirect(route('admin.list_patient'))->with('success','Patient Created!');
  }



  /**
  * Show the form for editing the specified resource.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function editPatient($id)
  {
    $patients = $this->getPatientById($id);
    return view('manage.edit_user',['users'=>$patients,'user_id'=>$id,'user_role'=>'patient']);
  }

  /**
  * Update the specified resource in storage.
  *
  * @param  \Illuminate\Http\Request  $request
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function updatePatient(Request $request, $id)
  {
    $name = $request->input('name');
    $surname = $request->input('surname');
    $email = $request->input('email');
    $date_of_birth = $request->input('date_of_birth');
    $address = $request->input('address');
    $telephone_number = $request->input('telephone_number');
    $gender = $request->input('gender');
    $drug_allergy = $request->input('drug_allergy');
    $underlying_disease = $request->input('underlying_disease');

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
    $patient = Patient::find($id);
    $patient->name = $name;
    $patient->surname = $surname;
    $patient->date_of_birth = $date_of_birth;
    $patient->address = $address;
    $patient->telephone_number = $telephone_number;
    $patient->gender = $gender;
    $patient->drug_allergy = $drug_allergy;
    $patient->underlying_disease = $underlying_disease;
    $save = $patient->save();

    return redirect(route('admin.list_patient'))->with('success','Update information successful!');


  }

  /**
  * Remove the specified resource from storage.
  *
  * @param  int  $id
  * @return \Illuminate\Http\Response
  */
  public function deletePatient($id)
  {
    $patient = Patient::find($id);
    $patient->delete();

    $user = DB::table('users')->where('user_id',$id)->delete();

    return redirect(route('admin.list_patient'))->with('success','Delete Patient successful!');

  }


  public function getPatientList()
  {
    $query_raw = "LENGTH(users.user_id) desc";
    $patient = DB::table('users')->join('patients','users.user_id','patients.user_id')->
    select('patients.user_id','patients.name','patients.surname','patients.email','users.username')->orderByRaw($query_raw)->orderBy('users.user_id')
    ->where('users.role_id',4)->paginate(10);
    return $patient;
  }
  public function getPatientId()
  {
    $query_raw = 'LENGTH(user_id) desc, `user_id` desc ';
    $get_current_id = DB::table('patients')->orderByRaw($query_raw)->first();
    if($get_current_id){
      $split_string = explode("p",$get_current_id->user_id);
      $current_id = intval($split_string[1]);
      $patients_id = "p".(++$current_id);
    }else{
      $patients_id = "p1";
    }
    return $patients_id;
  }
  public function getPatientById($id)
  {
    $patient = DB::table('users')->join('patients','users.user_id','patients.user_id')->
    select('patients.name','patients.surname','patients.email','patients.address','patients.gender','patients.telephone_number',
    'patients.drug_allergy','patients.underlying_disease','patients.date_of_birth')
    ->where('users.role_id',4)->where('users.user_id',$id)->get();
    return $patient;
  }
  public function checkPatientExist($name,$surname,$email)
  {
    $check_patient_exist = DB::table('patients')->select('user_id')->where('name',$name)
    ->where('surname',$surname)->where('email',$email)->first();
    if($check_patient_exist){
      $user_id = $check_patient_exist->user_id;
      $patient_id = $this->checkUserIdExist($user_id);
    }else{
      $patient_id = "none";
    }
    return $patient_id;

  }
  public function checkUserIdExist($id)
  {
    $check_id_exist = DB::table('users')->select('user_id')->where('user_id',$id)->first();
    if($check_id_exist){
      $patient_id = "exist";
      return $patient_id;
    }
  }



}
