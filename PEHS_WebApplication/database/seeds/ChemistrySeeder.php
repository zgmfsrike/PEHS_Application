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
        DB::table('chemical_chemistry_types')->insert([
          [
            'chemical_chemistry_id'=>1,
            'chemical_chemistry_name'=>'Glucose',
            'chemical_chemistry_standard'=>'70-99',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>2,
            'chemical_chemistry_name'=>'BUN',
            'chemical_chemistry_standard'=>'8.09-20.06',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>3,
            'chemical_chemistry_name'=>'Creatine',
            'chemical_chemistry_standard'=>'0.72-1.25',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>4,
            'chemical_chemistry_name'=>'Uric acid',
            'chemical_chemistry_standard'=>'3.5-7.2',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>5,
            'chemical_chemistry_name'=>'Cholesterol',
            'chemical_chemistry_standard'=>'<200',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>6,
            'chemical_chemistry_name'=>'Triglyceride',
            'chemical_chemistry_standard'=>'<150',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>7,
            'chemical_chemistry_name'=>'HDL-C',
            'chemical_chemistry_standard'=>'<40',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>8,
            'chemical_chemistry_name'=>'Calculated LDL',
            'chemical_chemistry_standard'=>'<150',
            'chemical_chemistry_unit'=>'mg/dl'
          ],
          [
            'chemical_chemistry_id'=>9,
            'chemical_chemistry_name'=>'AST/SGOT',
            'chemical_chemistry_standard'=>'5-34',
            'chemical_chemistry_unit'=>'U/L'
          ],
          [
            'chemical_chemistry_id'=>10,
            'chemical_chemistry_name'=>'ALT/SGPT',
            'chemical_chemistry_standard'=>'0-55',
            'chemical_chemistry_unit'=>'U/L'
          ],
          [
            'chemical_chemistry_id'=>11,
            'chemical_chemistry_name'=>'ALP',
            'chemical_chemistry_standard'=>'40-150',
            'chemical_chemistry_unit'=>'U/L'
          ],



        ]);
    }
}
