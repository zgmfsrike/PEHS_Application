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
          'underlying_disease_name'=>'Diabates',
        ],
        [
          'underlying_disease_name'=>'Hypertension',
        ],
        [
          'underlying_disease_name'=>'Dyslipidemia',
        ],
        [
          'underlying_disease_name'=>'Gout',
        ],
        [
          'underlying_disease_name'=>'Osteoarthritis',
        ],
        [
          'underlying_disease_name'=>'Obesity',
        ],
        [
          'underlying_disease_name'=>'Asthma'

        ]

      ]


    );
    }
}
