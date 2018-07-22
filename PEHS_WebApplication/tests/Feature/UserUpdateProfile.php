<?php

namespace Tests\Feature;

use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithoutMiddleware;
class UserUpdateProfile extends TestCase
{
  use WithoutMiddleware;
  /**
  * A basic test example.
  *
  * @return void
  */
  public function testDoctorUpdateProfile()
  {
    $this->startSession();
    $user_id = 6;
    $user = [
      'name' => 'singtong',
      'surname' => 'nitiya',
      'date_of_birth' => '2007-06-05',
      'address' => 'Thapthiang Mueang Trang Tran',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/doctor/update_profile/doctors/'.$user_id.'',$user);
    $response->assertSessionHas('success','Update information successfully.');
  }

  public function testMedicalStaffUpdateProfile()
  {
    $this->startSession();
    $user_id = 4;
    $user = [
      'name' => 'sompong',
      'surname' => 'tangwongsan',
      'date_of_birth' => '1987-12-12',
      'address' => '180 Dimon Sea Plaza Thaweewong Road',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/medical_staff/update_profile/medical_staffs/'.$user_id.'',$user);
    $response->assertSessionHas('success','Update information successfully.');
  }
}
