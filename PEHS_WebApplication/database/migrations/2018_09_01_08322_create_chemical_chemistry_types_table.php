<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateChemicalChemistryTypesTable extends Migration
{
  /**
  * Run the migrations.
  *
  * @return void
  */
  public function up()
  {
    Schema::create('chemical_chemistry_types', function (Blueprint $table) {
      $table->increments('chemical_chemistry_id');
      $table->string('chemical_chemistry_name',40);
      $table->string('chemical_chemistry_standard',40)->nullable();
      $table->string('chemical_chemistry_unit',40)->nullable();
    });
  }

  /**
  * Reverse the migrations.
  *
  * @return void
  */
  public function down()
  {
    Schema::dropIfExists('chemical_chemistry_types');
  }
}
