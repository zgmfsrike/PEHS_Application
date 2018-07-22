<?php

namespace Tests\Feature;
use DB;
use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithoutMiddleware;
class AdminDeleteUser extends TestCase
{
  use WithoutMiddleware;
  /**
  * A basic test example.
  *
  * @return void
  */
  public function testAdminDeleteDoctor()
  {
    $user = DB::table('user_roles')->select('user_id')->where('role_id',2)->orderBy('user_id','desc')->first();
    $user_id = $user->user_id;
    $response = $this->json('POST','/admin/delete_user/doctors/'.$user_id);
    $response->assertSessionHas('success','Delete user successfully.');
  }

  public function testAdminDeleteMedicalStaff()
  {
    $user = DB::table('user_roles')->select('user_id')->where('role_id',3)->orderBy('user_id','desc')->first();
    $user_id = $user->user_id;
    $response = $this->json('POST','/admin/delete_user/medical_staffs/'.$user_id);
    $response->assertSessionHas('success','Delete user successfully.');
  }

  public function testAdminDeletePatient()
  {
    $user = DB::table('user_roles')->select('user_id')->where('role_id',4)->orderBy('user_id','desc')->first();
    $user_id = $user->user_id;
    $response = $this->json('POST','/admin/delete_user/patients/'.$user_id);
    $response->assertSessionHas('success','Delete user successfully.');
  }
}
