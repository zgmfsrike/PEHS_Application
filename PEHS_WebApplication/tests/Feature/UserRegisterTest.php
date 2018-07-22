<?php

namespace Tests\Feature;
use App\Http\Controllers\Manage\ManageUserController;
use Illuminate\Support\Facades\Session;
use Tests\TestCase;
use Tests\DuskTestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use App\User;
class UserRegisterTest extends TestCase
{


  /**
  * A basic test example.
  *
  * @return void
  */
  public function testShowRegisterPage()
  {
    $response = $this->call('GET','/register_user');
    $this->assertEquals(200, $response->status());

  }


  // //
  public function testRegisterSuccess()
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
    $response = $this->json('POST','/register/patients',$user);
    $response->assertSessionHas('register_success','Register successfully');
  }
  //
  public function testRegisterPasswordNotMatch()
  {
    $username = str_random(6);
    $email = $username."@gmail.com";
    $personal_id = str_random(13);
    $this->startSession();
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
    $response = $this->json('POST','/register/patients',$user);
    $this->see('The password confirmation does not match.');
  }
  //
  public function testRegisterWithExistUsername()
  {
    $username = 'adminz';
    $email = $username."@gmail.com";
    $personal_id = str_random(13);
    $this->startSession();
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
    $response = $this->json('POST','/register/patients',$user);
    $this->see('The username has already been taken.');
  }
  //
  public function testRegisterWithExistEmail()
  {
    $username = str_random(6);
    $email = "adminz@gmail.com";
    $personal_id = str_random(13);
    $this->startSession();
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '123456',
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
    $response = $this->json('POST','/register/patients',$user);
    $this->see('The email has already been taken.');
  }

  public function testRegisterWithExistPersonalId()
  {
    $username = str_random(6);
    $email = $username."@gmail.com";
    $personal_id = '1929900553039';
    $this->startSession();
    $user = [
      'username' => $username,
      'email' => $email,
      'password' => '123456',
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
    $response = $this->json('POST','/register/patients',$user);
    $this->see('The personal id has already been taken.');
  }





  //
  // public function test_admin_can_access()
  // {
  //   $this->defineRoute();
  //
  //   $user = User::first();
  //   $this->be($user);
  //
  //   $this->get('admin.home');
  //
  //   $this->assertResponseStatus(200);
  // }

  // protected function defineRoute()
  // {
  //   $this->app['router']->get(
  //     'admin.home',
  //     [
  //       'middleware' => 'auth',
  //       function() {
  //         return 'this is admin page';
  //       }
  //     ]
  //   );
  // }


}
