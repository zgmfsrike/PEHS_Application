<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUserInformationsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('user_informations', function (Blueprint $table) {
          $table->increments('user_id');
          $table->string('name',30);
          $table->string('surname',30);
          $table->string('email')->unique();
          $table->date('date_of_birth');
          $table->string('address',200);
          $table->string('telephone_number',15);
          $table->integer('gender')->unsigned();
          $table->integer('blood_type')->unsigned();
          $table->string('personal_id',20);
          //
          $table->foreign('blood_type')->references('blood_type_id')->on('blood_types');
          $table->foreign('gender')->references('gender_id')->on('genders');
        
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('user_informations');
    }
}
