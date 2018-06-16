<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class MedicalStaff extends Model
{
  protected $guard = 'medical_staff';
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
