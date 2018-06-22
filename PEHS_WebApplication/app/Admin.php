<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Admin extends Model
{
  protected $guard = 'admin';
  public $timestamps = false;

  protected $fillable = [
       'name','surname',
   ];
   protected $hidden = [
        'password',
    ];
  

}
