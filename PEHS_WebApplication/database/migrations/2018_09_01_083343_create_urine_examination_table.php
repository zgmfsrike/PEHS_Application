<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUrineExaminationTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('urine_examination', function (Blueprint $table) {
          $table->integer('health_record_id')->unsigned();
          $table->integer('urine_ex_id')->unsigned();
          $table->string('urine_ex_value',50);

          $table->foreign('health_record_id')->references('health_record_id')->on('health_records');
          // $table->foreign('urine_ex_id')->references('urine_ex_id')->on('urine_examination_types');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('urine_examination');
    }
}
