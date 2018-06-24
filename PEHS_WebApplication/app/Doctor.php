<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Doctor extends Model
{
  protected $primaryKey = 'user_id';
  protected $fillable = [
    'user_id','name','surname','email',
  ];
}
