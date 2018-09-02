<?php

use Illuminate\Database\Seeder;

class BloodSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
      DB::table('blood_examination_types')->insert([
        [
          'blood_ex_id'=>1,
          'blood_ex_name'=>'Blood WBC',
          'blood_ex_standard'=>'5.5-10.0',
          'blood_ex_unit'=>'x10^3/ul'
        ],
        [
          'blood_ex_id'=>2,
          'blood_ex_name'=>'Blood RBC',
          'blood_ex_standard'=>'4.45-6.01',
          'blood_ex_unit'=>'x10^3/ul'
        ],
        [
          'blood_ex_id'=>3,
          'blood_ex_name'=>'HGB',
          'blood_ex_standard'=>'13.2-16.8',
          'blood_ex_unit'=>'g/dl'
        ],
        [
          'blood_ex_id'=>4,
          'blood_ex_name'=>'HCT',
          'blood_ex_standard'=>'39.7-52.9',
          'blood_ex_unit'=>'%'
        ],
        [
          'blood_ex_id'=>5,
          'blood_ex_name'=>'MCV',
          'blood_ex_standard'=>'82-97',
          'blood_ex_unit'=>'fl'
        ],
        [
          'blood_ex_id'=>6,
          'blood_ex_name'=>'MCH',
          'blood_ex_standard'=>'27-31',
          'blood_ex_unit'=>'pg'
        ],
        [
          'blood_ex_id'=>7,
          'blood_ex_name'=>'MCHC',
          'blood_ex_standard'=>'32-36',
          'blood_ex_unit'=>'g/dl'
        ],
        [
          'blood_ex_id'=>8,
          'blood_ex_name'=>'PLT count',
          'blood_ex_standard'=>'167-421',
          'blood_ex_unit'=>'x10^3/ul'
        ],
        [
          'blood_ex_id'=>9,
          'blood_ex_name'=>'Neutrophil',
          'blood_ex_standard'=>'45-62',
          'blood_ex_unit'=>'%'
        ],
        [
          'blood_ex_id'=>10,
          'blood_ex_name'=>'Lymphocyte',
          'blood_ex_standard'=>'34-42',
          'blood_ex_unit'=>'%'
        ],
        [
          'blood_ex_id'=>11,
          'blood_ex_name'=>'Monocyte',
          'blood_ex_standard'=>'6-8',
          'blood_ex_unit'=>'%'
        ],
        [
          'blood_ex_id'=>12,
          'blood_ex_name'=>'Eosinophil',
          'blood_ex_standard'=>'0-5',
          'blood_ex_unit'=>'%'
        ],
        [
          'blood_ex_id'=>13,
          'blood_ex_name'=>'Basophil',
          'blood_ex_standard'=>'0-1',
          'blood_ex_unit'=>'%'
        ],





      ]);
    }
}
