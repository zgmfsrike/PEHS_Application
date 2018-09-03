<?php
namespace App\Http\Controllers\HealthRecord;
interface IManageHealthInformation
{
  public function createHealthInformation($health_record_id, $health_information);
  public function updateHealthInformation($health_record_id, $health_information);
  public function deleteHealthInformation($health_record_id);

}

 ?>
