<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class MedicalStaff extends Model
{
  protected $table = 'medical_staffs';
  protected $primaryKey = 'user_id';
  public $timestamps = false;
  protected $fillable = [
    'user_id','name','surname','email',
  ];


}
