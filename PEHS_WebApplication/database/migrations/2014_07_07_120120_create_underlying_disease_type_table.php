<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUnderlyingDiseaseTypeTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        // Schema::create('underlying_disease_types', function (Blueprint $table) {
        //     $table->increments('underlying_disease_id');
        //     $table->string('underlying_disease_name',50);
        // });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        // Schema::dropIfExists('underlying_disease_types');
    }
}
