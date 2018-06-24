<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Patient extends Model
{
  protected $table = 'patients';
  protected $primaryKey = 'user_id';
  protected $fillable = [
    'user_id','name','surname','email',
  ];

}
