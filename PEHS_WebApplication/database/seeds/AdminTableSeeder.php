<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
class AdminTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
      DB::table('users')->insert([
        'username'=>'adminz',
        'password'=>Hash::make('7744536'),
        'user_id'=>'a1',
        'role_id'=>1,
      ]);
      DB::table('admins')->insert([
        'user_id'=>'a1',
        'name'=>'adminz',
        'surname'=>'admin',
      ]);

    }
}
