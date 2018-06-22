<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePatientsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('patients', function (Blueprint $table) {
          $table->string('user_id',10);
          $table->string('name',30);
          $table->string('surname',30);
          $table->string('email')->unique();
          $table->date('date_of_birth');
          $table->string('address',200);
          $table->string('telephone_number',15);
          $table->string('gender',10);
          $table->string('blood_type',5);
          $table->string('personal_id',20);
          $table->string('drug_allergy',100)->nullable();;
          $table->string('underlying_disease',100)->nullable();;
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('patients');
    }
}
