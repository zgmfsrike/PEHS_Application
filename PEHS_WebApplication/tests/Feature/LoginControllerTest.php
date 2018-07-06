<?php

namespace Tests\Feature;
use Session;
use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;

class LoginControllerTest extends TestCase
{
  //"./vendor/bin/phpunit"
  /**
  * A basic test example.
  *
  * @return void
  */
  public function testShowLoginPage()
  {
    $response = $this->call('GET','/login');
    $this->assertEquals(200, $response->status());
  }
  //admin login
  public function testAdminLoginSuccess()
  {
    Session::start();
    $user = [
      'username' => 'adminz',
      'password'=>'7744536',
    ];
    $response = $this->json('POST', '/login',$user);
    $response->assertSessionHas('login_success','Login Success!');
    $response->visit('/admin');

  }
  //doctor login
  public function testDoctorLoginSuccess()
  {
    Session::start();
    $user = [
      'username' => 'sommai1',
      'password'=>'123456',
    ];
    $response = $this->json('POST', '/login',$user);
    $response->assertSessionHas('login_success','Login Success!');
    $response->visit('/doctor');

  }
  //medical staff login
  public function testMedicalStaffLoginSuccess()
  {
    Session::start();
    $user = [
      'username' => 'medicalz',
      'password'=>'7744536',
    ];
    $response = $this->json('POST', '/login',$user);
    $response->assertSessionHas('login_success','Login Success!');
    $response->visit('/medical_staff');

  }

  public function testUserLoginAccountNotExist()
  {
    Session::start();
    $user = [
      'username' => 'user',
      'password'=>'123456',
    ];
    $response = $this->json('POST', '/login', $user);
    $response->assertSessionHas('login_fail','Username or Password is invalid');
    $response->visit('/login');

  }
  public function testAdminLoginIncorrectPassword()
  {
    Session::start();
    $user = [
      'username' => 'adminz',
      'password'=>'123456',
    ];
    $response = $this->json('POST', '/login', $user);
    $response->assertSessionHas('login_fail','Username or Password is invalid');
    $response->visit('/login');

  }
  public function testDoctorLoginIncorrectPassword()
  {
    Session::start();
    $user = [
      'username' => 'sommai1',
      'password'=>'222656',
    ];
    $response = $this->json('POST', '/login', $user);
    $response->assertSessionHas('login_fail','Username or Password is invalid');
    $response->visit('/login');

  }
  public function testMedicalStaffLoginIncorrectPassword()
  {
    Session::start();
    $user = [
      'username' => 'medicalz',
      'password'=>'213213',
    ];
    $response = $this->json('POST', '/login', $user);
    $response->assertSessionHas('login_fail','Username or Password is invalid');
    $response->visit('/login');

  }



}
