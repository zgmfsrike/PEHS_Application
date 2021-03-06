<?php

namespace App\Http\Controllers\Api;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;
use Carbon\Carbon;
use App\User;
use DB;

class ApiController extends Controller
{
  /**
  * Create user
  *
  * @param  [string] name
  * @param  [string] email
  * @param  [string] password
  * @param  [string] password_confirmation
  * @return [string] message
  */


  /**
  * Login user and create token
  *
  * @param  [string] email
  * @param  [string] password
  * @param  [boolean] remember_me
  * @return [string] access_token
  * @return [string] token_type
  * @return [string] expires_at
  */
  public function login(Request $request)
  {
    $request->validate([
      'username' => 'required|string',
      'password' => 'required|string',
    ]);
    $credentials = request(['username', 'password']);
    if(!Auth::attempt($credentials))
    return response()->json([
      'message' => 'Unauthorized'
    ], 401);
    $user = $request->user();
    $tokenResult = $user->createToken('Personal Access Token');
    $token = $tokenResult->token;
    if ($request->remember_me)
    $token->expires_at = Carbon::now()->addWeeks(1);
    $token->save();
    return response()->json([
      'access_token' => $tokenResult->accessToken,
      'token_type' => 'Bearer',
      'expires_at' => Carbon::parse(
        $tokenResult->token->expires_at
        )->toDateTimeString()
      ]);
    }



    /**
    * Logout user (Revoke the token)
    *
    * @return [string] message
    */
    public function logout(Request $request)
    {
      $request->user()->token()->revoke();
      return response()->json([
        'message' => 'Successfully logged out'
      ]);
    }

    /**
    * Get the authenticated User
    *
    * @return [json] user object
    */
    public function getInformation(Request $request)
    {
      $user_information = array();
      $user_id = $request->user()->id;
      $personal_information = DB::table('user_informations as ui')->
      join('genders as g','ui.gender','g.gender_id')->
      join('users as u','u.user_id','ui.user_id')->
      join('blood_types as bt','bt.blood_type_id','ui.blood_type')->
      select('ui.name','ui.surname','ui.email','ui.address','g.gender','ui.telephone_number',
      'ui.drug_allergy','ui.underlying_disease','ui.date_of_birth')
      ->where('u.user_id',$user_id)->get();

      $health_information = array();



      $health_record_id = DB::table('health_records as hr')->
      join('user_informations as ui','hr.user_id','ui.user_id')->
      select('hr.health_record_id','hr.health_record_date')->
      where('hr.user_id',$user_id)->get();

      // array_push($user_information,$personal_information);
      // $user_information['personal_information'] = $personal_information;
      // $user_information = ["personal_information"=>$personal_information];

      foreach ($health_record_id as $value) {
        $hr_id = $value->health_record_id;
        $hr_date = $value->health_record_date;
        $hr_info = array();

        //physical information
        $physical_detail = DB::table('health_records as hr')->
        join('physical_examination as p','hr.health_record_id','p.health_record_id')->
        join('physical_examination_types as pt','p.physical_ex_id','pt.physical_ex_id')->
        where('hr.health_record_id',$hr_id)->
        select('pt.physical_ex_name','p.physical_ex_value')->get();

        //blood information
        $blood_detail = DB::table('health_records as hr')->
        join('blood_examination as b','hr.health_record_id','b.health_record_id')->
        join('blood_examination_types as bt','b.blood_ex_id','bt.blood_ex_id')->
        where('hr.health_record_id',$hr_id)->
        select('bt.blood_ex_name','b.blood_ex_value')->get();

        //urine information
        $urine_detail = DB::table('health_records as hr')->
        join('urine_examination as u','hr.health_record_id','u.health_record_id')->
        join('urine_examination_types as ut','u.urine_ex_id','ut.urine_ex_id')->
        where('hr.health_record_id',$hr_id)->
        select('ut.urine_ex_name','u.urine_ex_value')->get();

        //chemistry information
        $chemistry_detail = DB::table('health_records as hr')->
        join('clinical_chemistry as c','hr.health_record_id','c.health_record_id')->
        join('clinical_chemistry_types as ct','c.clinical_chemistry_id','ct.clinical_chemistry_id')->
        where('hr.health_record_id',$hr_id)->
        select('ct.clinical_chemistry_name','c.clinical_chemistry_value')->get();



        // $hr_info[] = ['id'=>$hr_id,'date'=>$hr_date];
        $hr_info['id'] = $hr_id;
        $hr_info['date'] = $hr_date;



        foreach ($physical_detail as $key =>$value) {
          $health_name = $value->physical_ex_name;
          $healh_value = $value->physical_ex_value;
          $hr_info[$health_name] = $healh_value;

        }

        foreach ($blood_detail as $key =>$value) {
          $health_name = $value->blood_ex_name;
          $healh_value = $value->blood_ex_value;
          $hr_info[$health_name] = $healh_value;

        }

        foreach ($urine_detail as $key =>$value) {
          $health_name = $value->urine_ex_name;
          $healh_value = $value->urine_ex_value;
          $hr_info[$health_name] = $healh_value;

        }

        foreach ($chemistry_detail as $key =>$value) {
          $health_name = $value->clinical_chemistry_name;
          $healh_value = $value->clinical_chemistry_value;
          $hr_info[$health_name] = $healh_value;

        }

        array_push($health_information, $hr_info);
          // array_push($user_information, array($hr_info));






        // $health_information[] =['health_record' => $hr_info];
      }
      $user_information = array(
        "personal_information" => $personal_information,
        "health_information" => $health_information

      );
      // $user_information['personal_information'] = array($personal_information);











      return json_encode($user_information);
    }
  }
