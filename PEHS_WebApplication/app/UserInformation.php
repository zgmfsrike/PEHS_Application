<?php

namespace App;
use Illuminate\Database\Eloquent\Model;

class UserInformation extends Model
{
    protected $table = 'user_informations';
    protected $primaryKey = 'user_id';
    public $timestamps = false;

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'name', 'surname', 'email','address','gender','telephone_number','drug_allergy','underlying_disease','date_of_birth'
    ];
    protected $hidden = [
       'password', 'remember_token',
   ];




}
