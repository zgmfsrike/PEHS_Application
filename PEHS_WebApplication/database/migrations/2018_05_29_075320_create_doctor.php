<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateDoctor extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
          Schema::create('doctors', function (Blueprint $table) {
              $table->increments('doctor_id');
              $table->string('username',50)->unique();
              $table->string('password',200);
              $table->string('name',50);
              $table->string('surname',50);
              $table->date('date_of_birth');
              $table->string('address',255);
              $table->string('email',50)->unique();
              $table->string('telephone_number',20);
              $table->string('gender',50);
          });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
          Schema::dropIfExists('doctors');
    }
}
