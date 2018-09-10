<?php
namespace App\Http\Controllers\HealthRecord;
use DB;
use App\Http\Controllers\HealthRecord\IManageHealthInformation;

class Urine implements IManageHealthInformation {
  public function createHealthInformation($health_record_id, $health_information){
    $counter = 1;
    foreach ($health_information as $health_info) {
      $result = DB::table('urine_examination')->insert([
        'health_record_id'=>$health_record_id,
        'urine_ex_id'=>$counter,
        'urine_ex_value'=>$health_info
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
      $result = DB::table('urine_examination')->where('health_record_id',$health_record_id)->where('urine_ex_id',$counter)
      ->update(['urine_ex_value'=>$health_info]);
      $counter++;

    }
    return $result;


  }
  public function deleteHealthInformation($health_record_id){
    $result = DB::table('urine_examination')->where('health_record_id',$health_record_id)->delete();
    if($result){
      return true;
    }else{
      return false;
    }


  }

}
?>
