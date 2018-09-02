<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePhysicalExaminationTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('physical_examination', function (Blueprint $table) {
          $table->integer('health_record_id')->unsigned();
          $table->integer('physical_ex_id')->unsigned();
          $table->string('physical_ex_value',50);

          $table->foreign('health_record_id')->references('health_record_id')->on('health_records');
          // $table->foreign('physical_ex_id')->references('physical_ex_id')->on('physical_examination_types');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('physical_examination');
    }
}
