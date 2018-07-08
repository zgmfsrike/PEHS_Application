<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateDrugAllergysTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        // Schema::create('drug_allergys', function (Blueprint $table) {
        //     $table->integer('user_id')->unsigned();
        //     $table->integer('drug_allergy_id')->unsigned();
        //
        //     $table->foreign('user_id')->references('user_id')->on('user_informations');
        //     $table->foreign('drug_allergy_id','drug_allergy')->references('drug_allergy_id')->on('drug_allergy_types');
        //
        // });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        // Schema::dropIfExists('drug_allergys');
    }
}
