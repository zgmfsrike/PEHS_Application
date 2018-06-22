<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateMedicalStaffsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
      Schema::create('medical_staffs', function (Blueprint $table) {
        $table->string('user_id');
        $table->string('name',30);
        $table->string('surname',30);
        $table->date('date_of_birth');
        $table->string('address',200);
        $table->string('telephone_number',15);
        $table->string('gender',10);
        $table->string('email')->unique();
      });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('medical_staffs');
    }
}