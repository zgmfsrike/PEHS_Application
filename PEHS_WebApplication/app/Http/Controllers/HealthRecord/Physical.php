<?php
namespace App\Http\Controllers\HealthRecord;
use DB;
use App\Http\Controllers\HealthRecord\IManageHealthInformation;

class Physical implements IManageHealthInformation {

  public function createHealthInformation($health_record_id, $health_information){
    $weight = $health_information['weight'];
    $height = $health_information['height'];
    $wrist = $health_information['wrist'];
    $bmi = $health_information['bmi'];
    $systolic = $health_information['systolic'];
    $diastolic = $health_information['diastolic'];
    $pulse = $health_information['pulse'];

    $result = DB::table('physical_examination')->insert([
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>1,
        'physical_ex_value'=>$weight
      ],
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>2,
        'physical_ex_value'=>$height
      ],
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>3,
        'physical_ex_value'=>$wrist
      ],
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>4,
        'physical_ex_value'=>$bmi
      ],
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>5,
        'physical_ex_value'=>$systolic
      ],
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>6,
        'physical_ex_value'=>$diastolic
      ],
      [
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>7,
        'physical_ex_value'=>$pulse
      ],
    ]);

    if($result){
      return true;
    }else{
      return false;
    }



  }
  public function updateHealthInformation($health_record_id, $health_information){

  }
  public function deleteHealthInformation($health_record_id){

  }

}
?>
