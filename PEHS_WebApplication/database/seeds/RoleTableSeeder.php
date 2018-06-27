<?php

use Illuminate\Database\Seeder;

class RoleTableSeeder extends Seeder
{
  /**
  * Run the database seeds.
  *
  * @return void
  */
  public function run()
  {
    DB::table('roles')->insert([
      [

      'role_id'=>'1',
      'role_name'=>'admin',
      ],
      [
      'role_id'=>'2',
      'role_name'=>'doctor',
      ],
      [
      'role_id'=>'3',
      'role_name'=>'medical_staff',
      ],
      [
      'role_id'=>'4',
      'role_name'=>'patient',
      ]

    ]


  );
}
}
