<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePhysicalExaminationTypesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('physical_examination_types', function (Blueprint $table) {
          $table->increments('physical_ex_id');
          $table->string('physical_ex_name',40);
          $table->string('physical_ex_standard',40)->nullable();
          $table->string('physical_ex_unit',40)->nullable();
            });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('physical_examination_types');
    }
}
