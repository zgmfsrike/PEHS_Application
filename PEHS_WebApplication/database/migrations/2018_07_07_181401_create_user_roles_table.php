<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateUserRolesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        // Schema::create('user_roles', function (Blueprint $table) {
        //     $table->integer('user_id')->unsigned();
        //     $table->integer('role_id')->unsigned();
        //
        //     $table->foreign('role_id','role')->references('role_id')->on('roles');
        //     $table->foreign('user_id')->references('user_id')->on('user_informations');
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
        Schema::dropIfExists('user_roles');
    }
}
