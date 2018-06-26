<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Doctor extends Model
{
  protected $table = 'doctors';
  protected $primaryKey = 'user_id';
  public $timestamps = false;
  protected $fillable = [
    'user_id','name','surname','email',
  ];


}
