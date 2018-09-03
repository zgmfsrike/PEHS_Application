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

  public function __construct(Physical $physical)
  {
    $this->physical = $physical;
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

      $physical_information = array(
        'weight'=>$request->input('weight'),
        'height'=>$request->input('height'),
        'wrist'=>$request->input('wrist'),
        'bmi'=>$request->input('bmi'),
        'systolic'=>$request->input('systolic'),
        'diastolic'=>$request->input('diastolic'),
        'pulse'=>$request->input('pulse'),
      );
      // $physical = new Physical;
      $result_physical = $this->physical->createHealthInformation($hr_id,$physical_information);

      if($result_physical){
        return view('health_record.create');
      }
    }





  }

  public function postUpdateHealthRecord(Request $request,$health_record_id)
  {
    // code...
  }

  public function postDeleteHealthRecord(Reqeust $request)
  {
    // code...
  }

}
