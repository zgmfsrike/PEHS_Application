<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
class UserTableSeeder extends Seeder
{
  /**
  * Run the database seeds.
  *
  * @return void
  */
  public function run()
  {




    DB::table('user_informations')->insert([
      'name'=>'adminz',
      'surname'=>'adminz',
      'email'=>'adminz@gmail.com',
      'address'=>'adminz',
      'telephone_number'=>'0846256256',
      'date_of_birth'=>'2018-07-07',
      'personal_id'=>'1929900553039',
      'gender'=>1,
      'blood_type'=>1,

    ],
    [

    ]
  );

  DB::table('users')->insert([
    'username'=>'adminz',
    'password'=>Hash::make('7744536'),
    'user_id'=>1,
  ]);

  DB::table('user_roles')->insert([
    'user_id'=>1,
    'role_id'=>1,
  ]);








}
}
