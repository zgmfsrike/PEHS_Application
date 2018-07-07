<?php

use Illuminate\Database\Seeder;

class GenderTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('genders')->insert([
          [

          'gender_id'=>'1',
          'gender'=>'male',
          ],
          [
          'gender_id'=>'2',
          'gender'=>'female',
          ],
          [
          'gender_id'=>'3',
          'gender'=>'other',
          ]

        ]


      );
    }
}
