<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateChemicalChemistryTable extends Migration
{
  /**
  * Run the migrations.
  *
  * @return void
  */
  public function up()
  {
    Schema::create('chemical_chemistry', function (Blueprint $table) {
      $table->integer('health_record_id')->unsigned();
      $table->integer('chemical_chemistry_id')->unsigned();
      $table->string('chemical_chemistry_value',50);

      $table->foreign('health_record_id')->references('health_record_id')->on('health_records');
      // $table->foreign('chemical_chemistry_id')->references('chemical_chemistry_id')->on('chemical_chemistry_types');
    });
  }

  /**
  * Reverse the migrations.
  *
  * @return void
  */
  public function down()
  {
    Schema::dropIfExists('chemical_chemistry');
  }
}
