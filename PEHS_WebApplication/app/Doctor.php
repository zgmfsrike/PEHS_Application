<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Doctor extends Model
{
  protected $primaryKey = 'user_id';
  protected $guard = 'doctor';
  public $timestamps = false;
  protected $fillable = [
    'user_id','name','surname','email',
  ];
}
