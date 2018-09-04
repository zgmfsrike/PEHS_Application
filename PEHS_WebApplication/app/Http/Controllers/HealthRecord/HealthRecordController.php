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
    $health_record_list = DB::table('health_records as hr')->join('user_informations as ui','hr.user_id','ui.user_id')->
    join('blood_types as bt','ui.blood_type','bt.blood_type_id')->
    select('hr.health_record_date','hr.health_record_id','ui.name','ui.surname','ui.drug_allergy','ui.underlying_disease','bt.blood_type')->
    paginate(10);

    return view('health_record.list',['health_record'=>$health_record_list]);
  }

  public function getHealthRecordDetail($health_record_id,$category)
  {
    switch ($category) {
      case 'blood':
      $health_info_table = 'blood_examination';
      $health_info_type = 'blood_examination_types';
      $health_info_id = 'blood_ex_id';
      break;
      case 'urine':
      $health_info_table = 'urine_examination';
      $health_info_type = 'urine_examination_types';
      $health_info_id = 'urine_ex_id';
      break;
      case 'physical':
      $health_info_table = 'physical_examination';
      $health_info_type = 'physical_examination_types';
      $health_info_id = 'physical_ex_id';
      break;
      case 'chemistry':
      $health_info_table = 'clinical_chemistry';
      $health_info_type = 'clinical_chemistry_types';
      $health_info_id = 'clinical_chemistry_id';
      break;
    }
    $health_record_detail = DB::table('health_records as hr')->join($health_info_table.' as hi','hr.health_record_id','hi.health_record_id')->
    join($health_info_type.' as ht','hi.'.$health_info_id,'ht.'.$health_info_id)->
    where('hr.health_record_id',$health_record_id)->get();

    return view('health_record.detail',['healrh_record_detail'=>$health_record_detail]);
  }

  public function getPatientHealthRecordHistory($user_id)
  {
    $health_record_history = DB::table('health_records as hr')->
    join('user_informations as ui','hr.user_id','ui.user_id')->
    where('hr.user_id',$user_id)->paginate(10);

    return view('health_record.history',['healrh_record_history'=>$health_record_history]);
  }

  public function getEditHealthRecord($health_record_id)
  {
    $physical_information = DB::table('health_records as hr')->join('physical_examination as p','hr.health_record_id','p.health_record_id')->
    join('physical_examination_types as p_type','p.physical_ex_id','p_type.physical_ex_id')->where('hr.health_record_id',$health_record_id)->
    select('p.physical_ex_value')->get();

    $urine_information = DB::table('health_records as hr')->join('urine_examination as u','hr.health_record_id','u.health_record_id')->
    join('urine_examination_types as u_type','u.urine_ex_id','u_type.urine_ex_id')->where('hr.health_record_id',$health_record_id)->
    select('u.urine_ex_value')->get();

    $blood_information = DB::table('health_records as hr')->join('blood_examination as b','hr.health_record_id','b.health_record_id')->
    join('blood_examination_types as b_type','b.blood_ex_id','b_type.blood_ex_id')->where('hr.health_record_id',$health_record_id)->
    select('b.blood_ex_value')->get();

    $chemistry_information = DB::table('health_records as hr')->join('clinical_chemistry as c','hr.health_record_id','c.health_record_id')->
    join('clinical_chemistry_types as c_type','c.clinical_chemistry_id','c_type.clinical_chemistry_id')->where('hr.health_record_id',$health_record_id)->
    select('c.clinical_chemistry_value')->get();



    return view('health_record.edit',['physical'=>$physical_information,'urine'=>$urine_information,'blood'=>$blood_information,'chemistry'=>$chemistry_information]);


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
        return view('health_record.list');
      }

    }





  }

  public function postUpdateHealthRecord(Request $request,$health_record_id)
  {
    //physical
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
    $result_blood = $this->blood->updateHealthInformation($health_record_id,$blood_information);

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
    $result_urine =   $this->urine->updateHealthInformation($health_record_id,$urine_information);

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
    $result_chemistry =   $this->chemistry->updateHealthInformation($health_record_id,$chemistry_informations);

    if($result_physical && $result_blood && $result_urine && $result_chemistry ){
      return view('health_record.list');
    }


  }

  public function postDeleteHealthRecord($health_record_id)
  {
    $result_physical = $this->physical->deleteHealthInformation($health_record_id);
    $result_blood = $this->blood->deleteHealthInformation($health_record_id);
    $result_urine =   $this->urine->deleteHealthInformation($health_record_id);
    $result_chemistry =   $this->chemistry->deleteHealthInformation($health_record_id);

    if($result_physical && $result_blood && $result_urine && $result_chemistry ){
      return view('health_record.list');
    }
  }

  public function searchPatientHealthRecord(Request $request){}
    {
      $patient_name = $request->input('patient_name');
      $patient_health_record = DB::table('health_records as hr')->join('user_informations as ui','hr.user_id','ui.user_id')->
      join('blood_types as bt','ui.blood_type','bt.blood_type_id')->
      select('hr.health_record_date','hr.health_record_id','ui.name','ui.surname','ui.drug_allergy','ui.underlying_disease','bt.blood_type')->
      where('ui.name','like',$patient_name.'%')->paginate(10);

      if(count($patient_health_record) != 0){
        return view('health_record.list',['health_record'=>$patient_health_record]);

      }



    }

  }
