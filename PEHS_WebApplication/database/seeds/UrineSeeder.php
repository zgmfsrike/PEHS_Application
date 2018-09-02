<?php

use Illuminate\Database\Seeder;

class UrineSeeder extends Seeder
{
  /**
  * Run the database seeds.
  *
  * @return void
  */
  public function run()
  {
    DB::table('urine_examination_types')->insert([
      [
        'urine_ex_id'=>1,
        'urine_ex_name'=>'Color',
        'urine_ex_standard'=>'-',
        'urine_ex_unit'=>'-'
      ],
      [
        'urine_ex_id'=>2,
        'urine_ex_name'=>'Appearance',
        'urine_ex_standard'=>'Clear',
        'urine_ex_unit'=>'-'
      ],
      [
        'urine_ex_id'=>3,
        'urine_ex_name'=>'Specific Gravity',
        'urine_ex_standard'=>'1.005-1.030',
        'urine_ex_unit'=>'-'
      ],
      [
        'urine_ex_id'=>4,
        'urine_ex_name'=>'pH',
        'urine_ex_standard'=>'4-8',
        'urine_ex_unit'=>'-'
      ],
      [
        'urine_ex_id'=>5,
        'urine_ex_name'=>'Albumin',
        'urine_ex_standard'=>'Negative',
        'urine_ex_unit'=>'-'
      ],
      [
        'urine_ex_id'=>6,
        'urine_ex_name'=>'Sugar',
        'urine_ex_standard'=>'Negative',
        'urine_ex_unit'=>'-'
      ],
      [
        'urine_ex_id'=>7,
        'urine_ex_name'=>'Urine RBC',
        'urine_ex_standard'=>'0-5',
        'urine_ex_unit'=>'Cell/HPF'
      ],
      [
        'urine_ex_id'=>8,
        'urine_ex_name'=>'Urine WBC',
        'urine_ex_standard'=>'0-5',
        'urine_ex_unit'=>'Cell/HPF'
      ],
      [
        'urine_ex_id'=>9,
        'urine_ex_name'=>'Epithelial Cell',
        'urine_ex_standard'=>'0-5',
        'urine_ex_unit'=>'Cell/HPF'
      ]

    ]);
  }
}
