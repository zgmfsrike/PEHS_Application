<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateBloodExaminationTypesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('blood_examination_types', function (Blueprint $table) {
          $table->increments('blood_ex_id');
          $table->string('blood_ex_name',40);
          $table->string('blood_ex_standard',40)->nullable();
          $table->string('blood_ex_unit',40)->nullable();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('blood_examination_types');
    }
}
