<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Patient extends Model
{
  protected $fillable = [
    'user_id','name','surname','email',
  ];

}
