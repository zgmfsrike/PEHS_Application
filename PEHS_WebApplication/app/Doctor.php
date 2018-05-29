<?php

namespace App;

use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;

class Doctor extends Authenticatable

{
  use Notifiable;

  protected $primaryKey = 'doctor_id';

  protected $fillable = [
    'username', 'password', 'name','surname','date_of_birth','address','email','telephone_number','gender',
  ];

  protected $hidden = [
    'password', 'remember_token',
  ];
}
