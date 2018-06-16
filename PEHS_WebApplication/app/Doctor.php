<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Doctor extends Model
{

  protected $guard = 'doctor';
  public $timestamps = false;
  protected $fillable = [
    'user_id','name','surname','email',
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
