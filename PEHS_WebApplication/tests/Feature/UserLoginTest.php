<?php

namespace Tests\Feature;
use Session;
use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;

class UserLoginTest extends TestCase
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

  public function testUserLoginSuccess()
  {
    Session::start();
    $user = [
      'username' => 'adminz',
      'password'=>'7744536',
    ];
      $response = $this->json('POST', '/login',$user);
      $response->assertSessionHas('login_success','Login Success!');

    }

    public function testUserLoginFail()
    {
      Session::start();
      $user = [
        'username' => 'user',
        'password'=>'123456',
      ];
      $response = $this->json('POST', '/login', $user);
      $response->assertSessionHas('login_fail','Username or Password is invalid');

    }



  }
