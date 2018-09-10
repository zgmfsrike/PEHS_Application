<?php
namespace App\Http\Controllers\HealthRecord;
use DB;
use App\Http\Controllers\HealthRecord\IManageHealthInformation;

class Blood implements IManageHealthInformation {
  public function createHealthInformation($health_record_id, $health_information){
    $counter = 1;
    foreach ($health_information as $health_info) {
      $result = DB::table('blood_examination')->insert([
        'health_record_id'=>$health_record_id,
        'blood_ex_id'=>$counter,
        'blood_ex_value'=>$health_info
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
      $result = DB::table('blood_examination')->where('health_record_id',$health_record_id)->where('blood_ex_id',$counter)
      ->update(['blood_ex_value'=>$health_info]);
      $counter++;

    }
    return $result;


  }
  public function deleteHealthInformation($health_record_id){
    $result = DB::table('blood_examination')->where('health_record_id',$health_record_id)->delete();

    if($result){
      return true;
    }else{
      return false;
    }

  }

}
?>
