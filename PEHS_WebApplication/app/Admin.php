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
    public function setAttribute($key, $value)
   {
     $isRememberTokenAttribute = $key == $this->getRememberTokenName();
     if (!$isRememberTokenAttribute)
     {
       parent::setAttribute($key, $value);
     }
   }

}
