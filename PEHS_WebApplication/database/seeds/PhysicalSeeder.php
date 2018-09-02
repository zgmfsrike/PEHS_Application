<?php

use Illuminate\Database\Seeder;

class PhysicalSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
      DB::table('physical_examination_types')->insert([
        [
          'physical_ex_id'=>1,
          'physical_ex_name'=>'Weight',
          'physical_ex_standard'=>'-',
          'physical_ex_unit'=>'Kg'
        ],
        [
          'physical_ex_id'=>2,
          'physical_ex_name'=>'Height',
          'physical_ex_standard'=>'-',
          'physical_ex_unit'=>'cm'
        ],
        [
          'physical_ex_id'=>3,
          'physical_ex_name'=>'Wrist',
          'physical_ex_standard'=>'<90',
          'physical_ex_unit'=>'cm'
        ],
        [
          'physical_ex_id'=>4,
          'physical_ex_name'=>'BMI',
          'physical_ex_standard'=>'18.5-23.0',
          'physical_ex_unit'=>'Kg/m^2'
        ],
        [
          'physical_ex_id'=>5,
          'physical_ex_name'=>'Systolic',
          'physical_ex_standard'=>'90-139',
          'physical_ex_unit'=>'mmHg'
        ],
        [
          'physical_ex_id'=>6,
          'physical_ex_name'=>'Diastolic',
          'physical_ex_standard'=>'60-90',
          'physical_ex_unit'=>'mmHg'
        ],
        [
          'physical_ex_id'=>7,
          'physical_ex_name'=>'Pulse',
          'physical_ex_standard'=>'60-100',
          'physical_ex_unit'=>'per minutes'
        ]
      ]);
    }
}
