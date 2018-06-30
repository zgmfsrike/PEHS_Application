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
    $response = $this->call('GET','/register');
    $this->assertEquals(200, $response->status());

  }


  //
  public function testRegisterSuccess()
  {
    $this->startSession();
    // $user = [
    //   'username' => 'pat11',
    //   'email' => 'pat_1@gmail.com',
    //   'password' => '7744536',
    //   'password_confirmation'=>'7744536',
    //   'name' => 'patpat',
    //   'surname' => 'patsur',
    //   'date_of_birth' => '06-20-2018',
    //   'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
    //   'telephone_number'=> '0846256256',
    //   'gender'=>'male',
    //   'blood_type'=>'A+',
    //   'personal_id'=>'1929900553039',
    //   'drug_allergy'=>'none',
    //   'underlying_disease'=>'none',
    //   '_token' => Session::token(),
    // ];
    $response = $this->call('POST','/register/patients',array(
      '_token' => csrf_token(),
      'username' => 'pat11',
      'email' => 'pat_1@gmail.com',
      'password' => '7744536',
      'password_confirmation'=>'7744536',
      'name' => 'patpat',
      'surname' => 'patsur',
      'date_of_birth' => '06-20-2018',
      'address' => '49 Soi Saraphee 2 Ladya Road Somdejchaopraya 10600',
      'telephone_number'=> '0846256256',
      'gender'=>'male',
      'blood_type'=>'A+',
      'personal_id'=>'1929900553039',
      'drug_allergy'=>'none',
      'underlying_disease'=>'none',
    ));
    $this->assertEquals(200, $response->status());
    // $this->assertSessionHasErrors();
    // $response->assertSessionHas('register_success','Register successfully');
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
