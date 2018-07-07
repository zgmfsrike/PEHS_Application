<?php

use Illuminate\Database\Seeder;

class BloodTypeTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
      DB::table('blood_types')->insert([
        [
          'blood_type'=>'A+',
        ],
        [
          'blood_type'=>'A-',
        ],
        [
          'blood_type'=>'B+',
        ],
        [
          'blood_type'=>'B-',
        ],
        [
          'blood_type'=>'O+',
        ],
        [
          'blood_type'=>'O-',
        ],
        [
          'blood_type'=>'AB+',
        ]
        ,
        [
          'blood_type'=>'AB-',
        ]

      ]


    );
    }
}
