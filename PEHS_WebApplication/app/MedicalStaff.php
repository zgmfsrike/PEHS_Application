<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class MedicalStaff extends Model
{
  protected $primaryKey = 'user_id';
  protected $guard = 'medical_staff';
  public $timestamps = false;

  protected $fillable = [
    'user_id','name','surname','email',
  ];


}
