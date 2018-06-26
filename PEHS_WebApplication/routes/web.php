<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
  return view('auth.login');
});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');

Route::group(['prefix'=>'admin','middleware' => 'auth:admin'],function(){
  // Route::post('/login','Auth\AdminLoginController@login')->name('admin.login');
  // Route::post('/logout','Auth\LoginController@logoutAdmin')->name('admin.logout');
  Route::get('/','AdminController@index')->name('admin.home');

  //----------------------------------------Manage User-----------------------------------
  Route::get('/list_user/{role}','Manage\ManageUserController@getListUser')->name('admin.list_user');
  Route::post('/search_user/{role}','Manage\ManageUserController@searchUserByName')->name('admin.search_user');
  Route::get('/create_user/{role}','Manage\ManageUserController@getCreateUserPage')->name('admin.create_user');
  Route::post('/store_user/{role}','Manage\ManageUserController@storeUser')->name('admin.store_user');
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('admin.view_user_profile');
  Route::get('/edit_user/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('admin.edit_user');
  Route::put('/update_user/{role}/{user_id}','Manage\ManageUserController@updateUser')->name('admin.update_user');
  Route::delete('/delete_user/{role}/{user_id}','Manage\ManageUserController@deleteUser')->name('admin.delete_user');
  //---------------------------------------------------------------------------------------
  
});
// Route::prefix('admin')->group(function(){
// });

Route::group(['prefix'=>'doctor','middleware' => 'auth:doctor'],function(){
  // Route::post('/login','Auth\DoctorLoginController@login')->name('doctor.login');
  // Route::post('/logout','Auth\LoginController@logoutDoctor')->name('doctor.logout');
  Route::get('/','DoctorController@index')->name('doctor.home');
  Route::get('/profile','DoctorController@profile')->name('doctor.profile');
  Route::get('/profile/{user_id}/edit','DoctorController@editProfile')->name('doctor.edit_profile');
  Route::put('/profile/{user_id}/update','DoctorController@updateProfile')->name('doctor.update_profile');
});
Route::group(['prefix'=>'medical_staff','middleware' => 'auth:medical_staff'],function(){
  // Route::post('/login','Auth\MedicalStaffLoginController@login')->name('medical_staff.login');
  // Route::post('/logout','Auth\LoginController@logoutMedicalStaff')->name('medical_staff.logout');
  Route::get('/','MedicalStaffController@index')->name('medical_staff.home');
  Route::get('/profile','MedicalStaffController@profile')->name('medical_staff.profile');
  Route::get('/profile/{user_id}/edit','MedicalStaffController@editProfile')->name('medical_staff.edit_profile');
  Route::put('/profile/{user_id}/update','MedicalStaffController@updateProfile')->name('medical_staff.update_profile');

});
