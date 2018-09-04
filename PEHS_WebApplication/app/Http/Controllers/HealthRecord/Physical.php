<?php
namespace App\Http\Controllers\HealthRecord;
use DB;
use App\Http\Controllers\HealthRecord\IManageHealthInformation;

class Physical implements IManageHealthInformation {

  public function createHealthInformation($health_record_id, $health_information){

    $counter = 1;
    foreach ($health_information as $health_info) {
      $result = DB::table('physical_examination')->insert([
        'health_record_id'=>$health_record_id,
        'physical_ex_id'=>$counter,
        'physical_ex_value'=>$health_info
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
      $result = DB::table('physical_examination')->where('health_record_id',$health_record_id)->where('physical_ex_id',$counter)
      ->update(['physical_ex_value'=>$health_info]);
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
