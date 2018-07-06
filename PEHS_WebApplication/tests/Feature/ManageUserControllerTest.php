<?php

namespace Tests\Feature;
use App\Http\Controllers\Manage\ManageUserController;
use Illuminate\Support\Facades\Session;
use Tests\TestCase;
use Tests\DuskTestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use App\User;
class ManageUserControllerTest extends TestCase
{


  /**
  * A basic test example.
  *
  * @return void
  */
  public function testShowRegisterPage()
  {
    $response = $this->call('GET','/register');
    $this->assertEquals(200, $response->status());

  }


  //
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
      'gender'=>'male',
      'blood_type'=>'A+',
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/register/patients',$user);
    $response->assertSessionHas('register_success','Register successfully');
    $response->visit('/login');
  }

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
      'gender'=>'male',
      'blood_type'=>'A+',
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/register/patients',$user);
    $response->visit('/register');
  }

  public function testRegisterWithExistUsername()
  {
    $username = 'nipon';
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
      'gender'=>'male',
      'blood_type'=>'A+',
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/register/patients',$user);
    $response->visit('/register');
  }

  public function testRegisterWithExistEmail()
  {
    $username = 'nipon';
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
      'gender'=>'male',
      'blood_type'=>'A+',
      'personal_id'=>$personal_id,
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ];
    $response = $this->json('POST','/register/patients',$user);
    $response->visit('/register');
  }

  public function testCreateDoctor()
  {
    $this->withoutMiddleware();
    $response->visit('/register');
    // $username = str_random(6);
    // $email = $username."@gmail.com";
    // $personal_id = str_random(13);
    // $this->startSession();
    // $user = [
    //   'username' => $username,
    //   'email' => $email,
    //   'password' => '7744536',
    //   'password_confirmation'=>'7744536',
    //   'name' => 'test',
    //   'surname' => 'test',
    //   'date_of_birth' => '2018-06-06',
    //   'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
    //   'telephone_number'=> '0846256256',
    //   'gender'=>'male',
    // ];
    // $response = $this->json('POST','admin/create_user/doctors',$user);
    // $response->assertSessionHas('success','User created successfully');
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
