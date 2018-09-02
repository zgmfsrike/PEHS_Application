<?php
date_default_timezone_set("Asia/Bangkok");
use Illuminate\Database\Seeder;

class HealthInfoSeeder extends Seeder
{
  /**
  * Run the database seeds.
  *
  * @return void
  */
  public function run()
  {
    $date = date('Y-m-d H:i:s');
    DB::table('health_records')->insert([
      'health_record_id'=>1,
      'user_id'=>5,
      'health_record_date'=>$date
    ]);

    DB::table('blood_examination')->insert([
      [
        'health_record_id'=>1,
        'blood_ex_id'=>1,
        'blood_ex_value'=>'7.0'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>2,
        'blood_ex_value'=>'5.23'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>3,
        'blood_ex_value'=>'14.7'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>4,
        'blood_ex_value'=>'42.8'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>5,
        'blood_ex_value'=>'90'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>6,
        'blood_ex_value'=>'28'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>7,
        'blood_ex_value'=>'33'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>8,
        'blood_ex_value'=>'324'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>9,
        'blood_ex_value'=>'55'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>10,
        'blood_ex_value'=>'39'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>11,
        'blood_ex_value'=>'8'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>12,
        'blood_ex_value'=>'2'
      ],
      [
        'health_record_id'=>1,
        'blood_ex_id'=>13,
        'blood_ex_value'=>'1'
      ],
    ]);
    DB::table('physical_examination')->insert([
      [
        'health_record_id'=>1,
        'physical_ex_id'=>1,
        'physical_ex_value'=>'88'
      ],
      [
        'health_record_id'=>1,
        'physical_ex_id'=>2,
        'physical_ex_value'=>'180'
      ],
      [
        'health_record_id'=>1,
        'physical_ex_id'=>3,
        'physical_ex_value'=>'75'
      ],
      [
        'health_record_id'=>1,
        'physical_ex_id'=>4,
        'physical_ex_value'=>'20.0'
      ],
      [
        'health_record_id'=>1,
        'physical_ex_id'=>5,
        'physical_ex_value'=>'119'
      ],
      [
        'health_record_id'=>1,
        'physical_ex_id'=>6,
        'physical_ex_value'=>'78'
      ],
      [
        'health_record_id'=>1,
        'physical_ex_id'=>7,
        'physical_ex_value'=>'80'
      ],

    ]);


    DB::table('urine_examination')->insert([
      [
        'health_record_id'=>1,
        'urine_ex_id'=>1,
        'urine_ex_value'=>'Yellow'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>2,
        'urine_ex_value'=>'Clear'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>3,
        'urine_ex_value'=>'1.023'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>4,
        'urine_ex_value'=>'5'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>5,
        'urine_ex_value'=>'Negative'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>6,
        'urine_ex_value'=>'Negative'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>7,
        'urine_ex_value'=>'2'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>8,
        'urine_ex_value'=>'3'
      ],
      [
        'health_record_id'=>1,
        'urine_ex_id'=>9,
        'urine_ex_value'=>'3'
      ],
    ]);
    DB::table('clinical_chemistry')->insert([
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>1,
        'clinical_chemistry_value'=>'72'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>2,
        'clinical_chemistry_value'=>'10.0'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>3,
        'clinical_chemistry_value'=>'1.10'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>4,
        'clinical_chemistry_value'=>'3.9'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>5,
        'clinical_chemistry_value'=>'189'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>6,
        'clinical_chemistry_value'=>'132'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>7,
        'clinical_chemistry_value'=>'20'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>8,
        'clinical_chemistry_value'=>'80'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>9,
        'clinical_chemistry_value'=>'22'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>10,
        'clinical_chemistry_value'=>'47'
      ],
      [
        'health_record_id'=>1,
        'clinical_chemistry_id'=>11,
        'clinical_chemistry_value'=>'115'
      ],


    ]);
  }
}
