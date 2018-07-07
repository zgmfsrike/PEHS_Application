<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUnderlyingDiseasesTable extends Migration
{
  /**
  * Run the migrations.
  *
  * @return void
  */
  public function up()
  {
    Schema::create('underlying_diseases', function (Blueprint $table) {
      $table->integer('user_id')->unsigned();
      $table->integer('underlying_diseases_id')->unsigned();

      $table->foreign('user_id')->references('user_id')->on('user_informations');
      $table->foreign('underlying_diseases_id','underlying_diseases')->references('underlying_diseases_id')->on('underlying_disease_types');

    });
  }

  /**
  * Reverse the migrations.
  *
  * @return void
  */
  public function down()
  {
    Schema::dropIfExists('underlying_diseases');
  }
}
