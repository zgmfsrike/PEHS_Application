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
})->middleware('auth');

Auth::routes();


Route::post('/register/{role}','Manage\ManageUserController@storeUser')->name('patient.register');

Route::group(['prefix'=>'admin','middleware' => 'auth:admin'],function(){
  Route::get('/','HomeController@getAdminHomepage')->name('admin.home');
  //----------------------------------------Manage User-----------------------------------
  Route::get('/list_user/{role}','Manage\ManageUserController@getListUserPage')->name('admin.list_user');
  Route::post('/search_user/{role}','Manage\ManageUserController@searchUserByName')->name('admin.search_user');
  Route::get('/create_user/{role}','Manage\ManageUserController@getCreateUserPage')->name('admin.create_user');
  Route::post('/store_user/{role}','Manage\ManageUserController@storeUser')->name('admin.store_user');
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('admin.view_user_profile');
  Route::get('/edit_user/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('admin.edit_user');
  Route::put('/update_user/{role}/{user_id}','Manage\ManageUserController@updateUser')->name('admin.update_user');
  Route::delete('/delete_user/{role}/{user_id}','Manage\ManageUserController@deleteUser')->name('admin.delete_user');
  //---------------------------------------------------------------------------------------
});

Route::group(['prefix'=>'doctor','middleware' => 'auth:doctor'],function(){
  //-----------------------------------------------Doctor Route----------------------------------------------------
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('doctor.view_profile');
  Route::get('/edit_profile/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('doctor.edit_profile');
  Route::put('/update_profile/{role}/{user_id}','Manage\ManageUserController@updateUser')->name('doctor.update_profile');
  Route::get('/','HomeController@getDoctorHomepage')->name('doctor.home');
  //---------------------------------------------------------------------------------------------------------------

});
Route::group(['prefix'=>'medical_staff','middleware' => 'auth:medical_staff'],function(){
  Route::get('/','HomeController@getMedicalStaffHomepage')->name('medical_staff.home');
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('medical_staff.view_profile');
  Route::get('/edit_profile/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('medical_staff.edit_profile');
  Route::put('/update_profile/{role}/{user_id}','Manage\ManageUserController@updateUser')->name('medical_staff.update_profile');


});
