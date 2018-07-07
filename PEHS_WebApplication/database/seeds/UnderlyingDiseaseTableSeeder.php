<?php

use Illuminate\Database\Seeder;

class UnderlyingDiseaseTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
      DB::table('underlying_disease_types')->insert([
        [
          'underlying_diseases_name'=>'Diabates',
        ],
        [
          'underlying_diseases_name'=>'Hypertension',
        ],
        [
          'underlying_diseases_name'=>'Dyslipidemia',
        ],
        [
          'underlying_diseases_name'=>'Gout',
        ],
        [
          'underlying_diseases_name'=>'Osteoarthritis',
        ],
        [
          'underlying_diseases_name'=>'Obesity',
        ],
        [
          'underlying_diseases_name'=>'Asthma'
          
        ]

      ]


    );
    }
}
