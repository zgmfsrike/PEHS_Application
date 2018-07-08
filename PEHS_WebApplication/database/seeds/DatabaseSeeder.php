<?php

use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
  /**
  * Seed the application's database.
  *
  * @return void
  */
  public function run()
  {
    $this->call(BloodTypeTableSeeder::class);
    $this->call(GenderTableSeeder::class);
    // $this->call(DrugAllergyTableSeeder::class);
    // $this->call(UnderlyingDiseaseTableSeeder::class);
    $this->call(RoleTableSeeder::class);
    $this->call(UserTableSeeder::class);

  }
}
