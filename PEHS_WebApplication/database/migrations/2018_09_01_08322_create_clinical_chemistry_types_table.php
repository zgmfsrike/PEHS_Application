<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateclinicalChemistryTypesTable extends Migration
{
  /**
  * Run the migrations.
  *
  * @return void
  */
  public function up()
  {
    Schema::create('clinical_chemistry_types', function (Blueprint $table) {
      $table->increments('clinical_chemistry_id');
      $table->string('clinical_chemistry_name',40);
      $table->string('clinical_chemistry_standard',40)->nullable();
      $table->string('clinical_chemistry_unit',40)->nullable();
    });
  }

  /**
  * Reverse the migrations.
  *
  * @return void
  */
  public function down()
  {
    Schema::dropIfExists('clinical_chemistry_types');
  }
}
