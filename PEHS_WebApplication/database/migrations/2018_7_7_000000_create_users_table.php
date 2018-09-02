<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUsersTable extends Migration
{
  /**
  * Run the migrations.
  *
  * @return void
  */
  public function up()
  {
    Schema::create('users', function (Blueprint $table) {
      $table->increments('id');
      $table->string('username',25)->unique();
      $table->string('password');
      $table->integer('user_id')->unsigned();
      $table->integer('role_id')->unsigned();


      //add fk
      //->unsigned()
      // $table->foreign('role_id','role')->references('role_id')->on('roles');
      $table->foreign('role_id','role')->references('role_id')->on('roles');
      $table->foreign('user_id')->references('user_id')->on('user_informations');
      // $table->foreign('user_id','doctor')->references('doctor_id')->on('doctors');
      // $table->foreign('user_id','mstaff')->references('medical_staff_id')->on('medical_staffs');
      // $table->foreign('user_id','patient')->references('patient_id')->on('patients');
    });

    // Schema::table('users', function(Blueprint $table) {
    //   $table->foreign('user_id')->references('admin_id')->on('admins');
    // });


  }

  /**
  * Reverse the migrations.
  *
  * @return void
  */
  public function down()
  {
    Schema::dropIfExists('users');
  }
}
