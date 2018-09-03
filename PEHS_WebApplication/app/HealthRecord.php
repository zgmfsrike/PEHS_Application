<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class HealthRecord extends Model
{
  protected $table = 'health_records';
  protected $primaryKey = 'health_record_id';
  public $timestamps = false;

  protected $fillable = [
      'user_id', 'health_record_date', 
  ];


}
