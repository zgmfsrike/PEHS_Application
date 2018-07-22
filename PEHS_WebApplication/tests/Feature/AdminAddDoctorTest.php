<?php

namespace Tests\Feature;

use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithoutMiddleware;
class AdminAddDoctorTest extends TestCase
{
  use WithoutMiddleware;
  /**
  * A basic test example.
  *
  * @return void
  */
  public function testCreateDoctorSuccess()
  {
    $username = str_random(6);
    $email = $username."@gmail.com";
    $this->startSession();
    $personal_id = str_random(13);
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '7744536',
      'password_confirmation'=>'7744536',
      'name' => 'test',
      'surname' => 'test',
      'date_of_birth' => '2018-06-06',
      'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
      'telephone_number'=> '0846256256',
      'gender'=>1,
      'blood_type'=>1,
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/store_user/doctors',$user);
    $response->assertSessionHas('success','User created successfully.');
  }

  public function testCreateDoctorWithPasswordNotMatch()
  {
    $username = str_random(6);
    $email = $username."@gmail.com";
    $this->startSession();
    $personal_id = str_random(13);
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '7744536',
      'password_confirmation'=>'123456',
      'name' => 'test',
      'surname' => 'test',
      'date_of_birth' => '2018-06-06',
      'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
      'telephone_number'=> '0846256256',
      'gender'=>1,
      'blood_type'=>1,
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/store_user/doctors',$user);
    $this->see('The password confirmation does not match.');
  }
  public function testCreateDoctorWithExistUsername()
  {
    $random = str_random(6);
    $username = 'sommai1';
    $email = $random."as@gmail.com";
    $this->startSession();
    $personal_id = str_random(13);
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '7744536',
      'password_confirmation'=>'7744536',
      'name' => 'test',
      'surname' => 'test',
      'date_of_birth' => '2018-06-06',
      'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
      'telephone_number'=> '0846256256',
      'gender'=>1,
      'blood_type'=>1,
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/store_user/doctors',$user);
    $this->see('The username has already been taken.');
  }

  public function testCreateDoctorWithExistEmail()
  {
    $username = str_random(6);
    $email = "adminz@gmail.com";
    $this->startSession();
    $personal_id = str_random(13);
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '7744536',
      'password_confirmation'=>'7744536',
      'name' => 'test',
      'surname' => 'test',
      'date_of_birth' => '2018-06-06',
      'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
      'telephone_number'=> '0846256256',
      'gender'=>1,
      'blood_type'=>1,
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/store_user/doctors',$user);
    $this->see('The email has already been taken.');
  }

  public function testCreateDoctorWithExistPersonalId()
  {
    $username = str_random(6);
    $email = $username."@gmail.com";
    $this->startSession();
    $personal_id = '1929900553039';
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '7744536',
      'password_confirmation'=>'7744536',
      'name' => 'test',
      'surname' => 'test',
      'date_of_birth' => '2018-06-06',
      'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
      'telephone_number'=> '0846256256',
      'gender'=>1,
      'blood_type'=>1,
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/admin/store_user/doctors',$user);
    $this->see('The personal id has already been taken.');
  }


}
