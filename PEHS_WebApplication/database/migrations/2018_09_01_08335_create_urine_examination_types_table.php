<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUrineExaminationTypesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('urine_examination_types', function (Blueprint $table) {
          $table->increments('urine_ex_id');
          $table->string('urine_ex_name',40);
          $table->string('urine_ex_standard',40)->nullable();
          $table->string('urine_ex_unit',40)->nullable();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('urine_examination_types');
    }
}
