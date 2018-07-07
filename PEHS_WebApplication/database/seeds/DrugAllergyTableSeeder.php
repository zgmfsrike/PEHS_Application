<?php

use Illuminate\Database\Seeder;

class DrugAllergyTableSeeder extends Seeder
{
  /**
  * Run the database seeds.
  *
  * @return void
  */
  public function run()
  {
    DB::table('drug_allergy_types')->insert([
      [
        'drug_allergy_name'=>'Paracetamol',
      ],
      [
        'drug_allergy_name'=>'Amoxicillin',
      ],
      [
        'drug_allergy_name'=>'Aspirin',
      ],
      [
        'drug_allergy_name'=>'Ibuprofen',
      ],
      [
        'drug_allergy_name'=>'Naproxen',
      ],
      [
        'drug_allergy_name'=>'Indomethacin',
      ],
      [
        'drug_allergy_name'=>'Etoricoxib
        ',
      ]

    ]


  );
}
}
