<?php

use Illuminate\Database\Seeder;

class ChemistrySeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('clinical_chemistry_types')->insert([
          [
            'clinical_chemistry_id'=>1,
            'clinical_chemistry_name'=>'Glucose',
            'clinical_chemistry_standard'=>'70-99',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>2,
            'clinical_chemistry_name'=>'BUN',
            'clinical_chemistry_standard'=>'8.09-20.06',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>3,
            'clinical_chemistry_name'=>'Creatine',
            'clinical_chemistry_standard'=>'0.72-1.25',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>4,
            'clinical_chemistry_name'=>'Uric acid',
            'clinical_chemistry_standard'=>'3.5-7.2',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>5,
            'clinical_chemistry_name'=>'Cholesterol',
            'clinical_chemistry_standard'=>'<200',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>6,
            'clinical_chemistry_name'=>'Triglyceride',
            'clinical_chemistry_standard'=>'<150',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>7,
            'clinical_chemistry_name'=>'HDL-C',
            'clinical_chemistry_standard'=>'<40',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>8,
            'clinical_chemistry_name'=>'Calculated LDL',
            'clinical_chemistry_standard'=>'<150',
            'clinical_chemistry_unit'=>'mg/dl'
          ],
          [
            'clinical_chemistry_id'=>9,
            'clinical_chemistry_name'=>'AST/SGOT',
            'clinical_chemistry_standard'=>'5-34',
            'clinical_chemistry_unit'=>'U/L'
          ],
          [
            'clinical_chemistry_id'=>10,
            'clinical_chemistry_name'=>'ALT/SGPT',
            'clinical_chemistry_standard'=>'0-55',
            'clinical_chemistry_unit'=>'U/L'
          ],
          [
            'clinical_chemistry_id'=>11,
            'clinical_chemistry_name'=>'ALP',
            'clinical_chemistry_standard'=>'40-150',
            'clinical_chemistry_unit'=>'U/L'
          ],



        ]);
    }
}
