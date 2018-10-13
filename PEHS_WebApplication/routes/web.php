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
//
// Route::get('/', function () {
//   return view('auth.login');
// })->middleware('auth');

Route::get('/', function () {
  return view('about');
})->middleware('check_auth')->name('about');

Auth::routes();

Route::get('/register_user','Auth\RegisterController@getRegisterPage')->name('register_user');
Route::post('/register/{role}','Manage\ManageUserController@registerPatient')->name('patient.register');


Route::group(['prefix'=>'admin','middleware' => ['auth:admin']],function(){
  Route::get('/','HomeController@getAdminHomepage')->name('admin.home');
  //----------------------------------------Manage User-----------------------------------
  Route::get('/list_user/{role}','Manage\ManageUserController@getListUserPage')->name('admin.list_user');
  Route::post('/search_user/{role}','Manage\ManageUserController@searchUserByName')->name('admin.search_user');
  Route::get('/create_user/{role}','Manage\ManageUserController@getCreateUserPage')->name('admin.create_user');
  Route::post('/store_user/{role}','Manage\ManageUserController@storeUser')->name('admin.store_user');
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('admin.view_user_profile');
  Route::get('/edit_user/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('admin.edit_user');
  Route::post('/update_user/{role}/{user_id}','Manage\ManageUserController@updateUser')->name('admin.update_user');
  Route::post('/delete_user/{role}/{user_id}','Manage\ManageUserController@deleteUser')->name('admin.delete_user');
  //---------------------------------------------------------------------------------------
});

Route::group(['prefix'=>'doctor','middleware' => ['auth:doctor']],function(){
  //-----------------------------------------------Doctor Route----------------------------------------------------
  Route::get('/','HomeController@getDoctorHomepage')->name('doctor.home');
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('doctor.view_profile')->middleware('doctor.personal_info');
  Route::get('/edit_profile/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('doctor.edit_profile')->middleware('doctor.personal_info');
  Route::post('/update_profile/{role}/{user_id}','Manage\ManageUserController@updateProfile')->name('doctor.update_profile')->middleware('doctor.personal_info');

  Route::get('/list/{role}','Manage\ManageUserController@getListUserPage')->name('doctor.list_patient');
  Route::get('/view/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('doctor.view_user_profile');
  Route::get('/view/health_record_list','HealthRecord\HealthRecordController@getHealthRecordList')->name('doctor.view_hr_list');
  Route::post('detail/health_record/','HealthRecord\HealthRecordController@getHealthRecordDetail')->name('doctor.health_record_detail');
  Route::post('history/health_record/','HealthRecord\HealthRecordController@getPatientHealthRecordHistory')->name('doctor.health_record_history');
  Route::post('/search/health_record','HealthRecord\HealthRecordController@searchPatientHealthRecord')->name('doctor.health_record_search');
  Route::post('/search_user/{role}','Manage\ManageUserController@searchUserByName')->name('doctor.search_user');


  //---------------------------------------------------------------------------------------------------------------

});
Route::group(['prefix'=>'medical_staff','middleware' => 'auth:medical_staff'],function(){
  Route::get('/','HomeController@getMedicalStaffHomepage')->name('medical_staff.home');
  Route::get('/view_profile/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('medical_staff.view_profile')->middleware('m_staff.personal_info');
  Route::get('/edit_profile/{role}/{user_id}','Manage\ManageUserController@getEditUserPage')->name('medical_staff.edit_profile')->middleware('m_staff.personal_info');
  Route::post('/update_profile/{role}/{user_id}','Manage\ManageUserController@updateProfile')->name('medical_staff.update_profile')->middleware('m_staff.personal_info');

  Route::get('/list/{role}','Manage\ManageUserController@getListUserPage')->name('medical_staff.list_patient');

  Route::post('create/health_record','HealthRecord\HealthRecordController@getCreateHealthRecord')->name('health_record.create');

  Route::post('store/health_record','HealthRecord\HealthRecordController@postCreateHealthRecord')->name('health_record.store');

  Route::get('edit/health_record/{health_record_id}','HealthRecord\HealthRecordController@getEditHealthRecord')->name('health_record.edit');
  Route::post('update/health_record','HealthRecord\HealthRecordController@postUpdateHealthRecord')->name('health_record.update');
  Route::get('/view/{role}/{user_id}','Manage\ManageUserController@viewUserProfile')->name('m_staff.view_user_profile');
  Route::get('/view/health_record_list','HealthRecord\HealthRecordController@getHealthRecordList')->name('m_staff.view_hr_list');
  Route::post('delete/health_record/{health_record_id}','HealthRecord\HealthRecordController@postDeleteHealthRecord')->name('health_record.delete');
  Route::post('detail/health_record/','HealthRecord\HealthRecordController@getHealthRecordDetail')->name('health_record.detail');
  Route::post('history/health_record/','HealthRecord\HealthRecordController@getPatientHealthRecordHistory')->name('health_record.history');
  Route::post('/search/health_record','HealthRecord\HealthRecordController@searchPatientHealthRecord')->name('health_record.search');
  Route::post('/search_user/{role}','Manage\ManageUserController@searchUserByName')->name('medical_staff.search_user');
});
