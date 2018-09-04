<?php

namespace App\Http\Controllers\HealthRecord;
use Illuminate\Http\Request;
use App\Http\Controllers\HealthRecord\Blood;
use App\Http\Controllers\HealthRecord\Urine;
use App\Http\Controllers\HealthRecord\Physical;
use App\Http\Controllers\HealthRecord\Chemistry;
use App\Http\Controllers\Controller;
use DB;
use App\HealthRecord;
date_default_timezone_set("Asia/Bangkok");

class HealthRecordController extends Controller
{

  public function __construct(Physical $physical,Blood $blood,Urine $urine,Chemistry $chemistry)
  {
    $this->physical = $physical;
    $this->blood = $blood;
    $this->urine = $urine;
    $this->chemistry = $chemistry;
  }

  public function getHealthRecordList()
  {
    // code...
  }

  public function getHealthRecordDetail($health_record_id,$category)
  {
    // code...
  }

  public function getPatientHealthRecordHistory($user_id)
  {
    // code...
  }

  public function getEditHealthRecordHistory()
  {
    // code...
  }

  public function getCreateHealthRecord()
  {
    return view('health_record.create');
  }

  public function postCreateHealthRecord(Request $request)
  // public function postCreateHealthRecord(Request $request,$user_id)
  {
    $health_record_date = date('Y-m-d H:i:s');

    $health_record = new HealthRecord;
    $health_record->user_id = 5;
    $health_record->health_record_date = $health_record_date;
    if($health_record->save()){
      $hr_id = $health_record->health_record_id;
      //physical information
      $physical_information = array(
        'weight'=>$request->input('weight'),
        'height'=>$request->input('height'),
        'wrist'=>$request->input('wrist'),
        'bmi'=>$request->input('bmi'),
        'systolic'=>$request->input('systolic'),
        'diastolic'=>$request->input('diastolic'),
        'pulse'=>$request->input('pulse'),
      );
      $result_physical = $this->physical->createHealthInformation($hr_id,$physical_information);

      //blood information
      $blood_information = array(
        'blood_wbc'=>$request->input('blood_wbc'),
        'blood_rbc'=>$request->input('blood_rbc'),
        'hgb'=>$request->input('hgb'),
        'hct'=>$request->input('hct'),
        'mcv'=>$request->input('mcv'),
        'mch'=>$request->input('mch'),
        'mchc'=>$request->input('mchc'),
        'plt_count'=>$request->input('plt_count'),
        'neutrophil'=>$request->input('neutrophil'),
        'lymphocyte'=>$request->input('lymphocyte'),
        'monocyte'=>$request->input('monocyte'),
        'eosinophil'=>$request->input('eosinophil'),
        'basophil'=>$request->input('basophil'),

      );
      $result_blood = $this->blood->createHealthInformation($hr_id,$blood_information);

      //urine information
      $urine_information = array(
        'urine_color'=>$request->input('urine_color'),
        'appearance'=>$request->input('appearance'),
        'specific_gravity'=>$request->input('specific_gravity'),
        'ph'=>$request->input('ph'),
        'albumin'=>$request->input('albumin'),
        'sugar'=>$request->input('sugar'),
        'urine_rbc'=>$request->input('urine_rbc'),
        'urine_wbc'=>$request->input('urine_wbc'),
        'epithelial_cell'=>$request->input('epithelial_cell'),
      );
      $result_urine =   $this->urine->createHealthInformation($hr_id,$urine_information);

      //clinical chemistry information
      $chemistry_information = array(
        'glucose'=>$request->input('glucose'),
        'bun'=>$request->input('bun'),
        'creatine'=>$request->input('creatine'),
        'uric_acid'=>$request->input('uric_acid'),
        'cholesterol'=>$request->input('cholesterol'),
        'triglyceride'=>$request->input('triglyceride'),
        'hdl_c'=>$request->input('hdl_c'),
        'ldl'=>$request->input('ldl'),
        'ast_sgot'=>$request->input('ast_sgot'),
        'alt_sgpt'=>$request->input('alt_sgpt'),
        'alp'=>$request->input('alp'),

      );
      $result_chemistry =   $this->chemistry->createHealthInformation($hr_id,$chemistry_informations);



      if($result_physical && $result_blood && $result_urine && $result_chemistry ){
        return view('health_record.create');
      }
    }





  }

  public function postUpdateHealthRecord(Request $request,$health_record_id)
  {
    $physical_information = array(
      'weight'=>$request->input('weight'),
      'height'=>$request->input('height'),
      'wrist'=>$request->input('wrist'),
      'bmi'=>$request->input('bmi'),
      'systolic'=>$request->input('systolic'),
      'diastolic'=>$request->input('diastolic'),
      'pulse'=>$request->input('pulse'),
    );

    $result_physical = $this->physical->updateHealthInformation($health_record_id,$physical_information);
    if($result_physical){
      return view('health_record.create');
    }


  }

  public function postDeleteHealthRecord(Reqeust $request)
  {
    // code...
  }

}
