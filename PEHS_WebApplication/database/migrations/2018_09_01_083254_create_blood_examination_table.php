<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateBloodExaminationTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('blood_examination', function (Blueprint $table) {
          $table->integer('health_record_id')->unsigned();
          $table->integer('blood_ex_id')->unsigned();
          $table->string('blood_ex_value',50);

          $table->foreign('health_record_id')->references('health_record_id')->on('health_records');
          // $table->foreign('blood_ex_id')->references('blood_ex_id')->on('blood_examination_types');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('blood_examination');
    }
}
