<?php
namespace App\Http\Controllers\HealthRecord;

use App\Http\Controllers\HealthRecord\IManageHealthInformation;

class Chemistry implements IManageHealthInformation {
  public function createHealthInformation($health_record_id, $health_information){

    $counter = 1;
    foreach ($health_information as $health_info) {
      $result = DB::table('clinical_chemistry')->insert([
        'health_record_id'=>$health_record_id,
        'clinical_chemistry_id'=>$counter,
        'clinical_chemistry_value'=>$health_info
      ]);
      if(!$result){
        return false;
      }
      $counter++;
    }
    return true;
  }
  public function updateHealthInformation($health_record_id, $health_information){
    $counter = 1;
    foreach ($health_information as  $health_info) {
      $result = DB::table('clinical_chemistry')->where('health_record_id',$health_record_id)->where('clinical_chemistry_id',$counter)
      ->update(['clinical_chemistry_value'=>$health_info]);
      $counter++;
      if(!$result){
        return false;
      }
    }
    return true;


  }
  public function deleteHealthInformation($health_record_id){

  }

}
?>
