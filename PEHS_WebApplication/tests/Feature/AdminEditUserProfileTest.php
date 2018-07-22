<?php

namespace Tests\Feature;

use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithoutMiddleware;

class AdminEditUserProfileTest extends TestCase
{
  use WithoutMiddleware;
  /**
  * A basic test example.
  *
  * @return void
  */
  public function testEditPatientInformation()
  {
    $this->startSession();
    $user_id = 6;
    $user = [
      'name' => 'nipawat',
      'surname' => 'nitiya',
      'date_of_birth' => '2007-06-05',
      'address' => 'Thapthiang Mueang Trang Tran',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/patients/'.$user_id.'',$user);
    $response->assertSessionHas('success','Update information successfully.');
  }

  public function testEditDoctorInformation()
  {
    $this->startSession();
    $user_id = 2;
    $user = [
      'name' => 'malakon',
      'surname' => 'jittang',
      'date_of_birth' => '2007-06-05',
      'address' => '1519 Km 30 Gp 11 Soi Rongfongnang Sukhumvit Thai Ban Mueang Samut Prakarn Samut Prakan 10280',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/doctors/'.$user_id.'',$user);
    $response->assertSessionHas('success','Update information successfully.');
  }
  public function testEditMedicalStaffInformation()
  {
    $this->startSession();
    $user_id = 4;
    $user = [
      'name' => 'sommana',
      'surname' => 'tangwongsan',
      'date_of_birth' => '1987-12-12',
      'address' => '180 Dimon Sea Plaza Thaweewong Road',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/medical_staffs/'.$user_id.'',$user);
    $response->assertSessionHas('success','Update information successfully.');
  }

  public function testEditPatientInformationWithIncorrectNameFormat()
  {
    $this->startSession();
    $user_id = 6;
    $user = [
      'name' => 'nipawat##@@#',
      'surname' => 'nitiya',
      'date_of_birth' => '2007-06-05',
      'address' => 'Thapthiang Mueang Trang Tran',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/patients/'.$user_id.'',$user);
    $this->see('The name format is invalid');
  }

  public function testEditDoctorInformationWithIncorrectNameFormat()
  {
    $this->startSession();
    $user_id = 2;
    $user = [
      'name' => 'malakon##@!',
      'surname' => 'jittang',
      'date_of_birth' => '2007-06-05',
      'address' => '1519 Km 30 Gp 11 Soi Rongfongnang Sukhumvit Thai Ban Mueang Samut Prakarn Samut Prakan 10280',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/doctors/'.$user_id.'',$user);
    $this->see('The name format is invalid');
  }

  public function testEditMedicalStaffInformationWithIncorrectNameFormat()
  {
    $this->startSession();
    $user_id = 4;
    $user = [
      'name' => 'sommana@#!@!@!#',
      'surname' => 'tangwongsan',
      'date_of_birth' => '1987-12-12',
      'address' => '180 Dimon Sea Plaza Thaweewong Road',
      'telephone_number'=> '0853223926',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/medical_staffs/'.$user_id.'',$user);
    $this->see('The name format is invalid');
  }

  public function testEditPatientInformationWithIncorrectTelFormat()
  {
    $this->startSession();
    $user_id = 6;
    $user = [
      'name' => 'nipawat',
      'surname' => 'nitiya',
      'date_of_birth' => '2007-06-05',
      'address' => 'Thapthiang Mueang Trang Tran',
      'telephone_number'=> '08532239asdasd26',
      'gender'=>1,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/update_user/patients/'.$user_id.'',$user);
    $this->see('The telephone number format is invalid.');
  }

}
