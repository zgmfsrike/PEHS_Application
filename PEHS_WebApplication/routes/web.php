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

Route::group(['prefix'=>'admin'],function(){
  // Route::post('/login','Auth\AdminLoginController@login')->name('admin.login');
  // Route::post('/logout','Auth\LoginController@logoutAdmin')->name('admin.logout');
  Route::get('/','AdminController@index')->name('admin.home');
  //---------------------------------------Manage Doctor---------------------------------------------------------------
  Route::get('/list_doctor','Manage\ManageDoctorController@showListDoctor')->name('admin.list_doctor');
  Route::get('/edit_doctor/{user_id}/edit','Manage\ManageDoctorController@editDoctor')->name('admin.edit_doctor');
  Route::put('/edit_doctor/{user_id}','Manage\ManageDoctorController@updateDoctor')->name('admin.update_doctor');
  Route::get('/create_doctor','Manage\ManageDoctorController@createDoctor')->name('admin.create_doctor');
  Route::post('/create_doctor','Manage\ManageDoctorController@storeDoctor')->name('admin.store_doctor');
  Route::delete('/delete_doctor/{user_id}','Manage\ManageDoctorController@deleteDoctor')->name('admin.delete_doctor');
  Route::get('/view_profile/doctor/{user_id}','Manage\ManageDoctorController@viewDoctorProfile')->name('admin.view_doctor_profile');
  Route::post('/search_doctor','Manage\ManageDoctorController@searchDoctorByName')->name('admin.search_doctor');
  //--------------------------------------------------------------------------------------------------------------------

  //---------------------------------------Manage Medical Staff---------------------------------------------------------
  Route::get('/list_medical_staff','Manage\ManageMedicalStaffController@showListMedicalStaff')->name('admin.list_medical_staff');
  Route::get('/edit_medical_staff/{user_id}/edit','Manage\ManageMedicalStaffController@editMedicalStaff')->name('admin.edit_medical_staff');
  Route::put('/edit_medical_staff/{user_id}','Manage\ManageMedicalStaffController@updateMedicalStaff')->name('admin.update_medica_staff');
  Route::get('/create_medical_staff','Manage\ManageMedicalStaffController@createMedicalStaff')->name('admin.create_medical_staff');
  Route::post('/create_medical_staff','Manage\ManageMedicalStaffController@storeMedicalStaff')->name('admin.store_medical_staff');
  Route::delete('/delete_medical_staff/{user_id}','Manage\ManageMedicalStaffController@deleteMedicalStaff')->name('admin.delete_medicalStaff');
  Route::get('/view_profile/medical_staff/{user_id}','Manage\ManageMedicalStaffController@viewMedicalStaffProfile')->name('admin.view_medical_staff_profile');
  Route::post('/search_medical_staff','Manage\ManageMedicalStaffController@searchMedicalStaffByName')->name('admin.search_medical_staff');
  //--------------------------------------------------------------------------------------------------------------------

  //---------------------------------------Manage Medical Staff---------------------------------------------------------
  Route::get('/list_patient','Manage\ManagePatientController@showListPatient')->name('admin.list_patient');
  Route::get('/edit_patient/{user_id}/edit','Manage\ManagePatientController@editPatient')->name('admin.edit_patient');
  Route::put('/edit_patient/{user_id}','Manage\ManagePatientController@updatePatient')->name('admin.update_patient');
  Route::get('/create_patient','Manage\ManagePatientController@createPatient')->name('admin.create_patient');
  Route::post('/create_patient','Manage\ManagePatientController@storePatient')->name('admin.store_patient');
  Route::delete('/delete_patient/{user_id}','Manage\ManagePatientController@deletePatient')->name('admin.delete_patient');
  Route::get('/view_profile/patient/{user_id}','Manage\ManagePatientController@viewPatientProfile')->name('admin.view_patient_profile');
  Route::post('/search_patient','Manage\ManagePatientController@searchPatientByName')->name('admin.search_patient');
  //--------------------------------------------------------------------------------------------------------------------
});
// Route::prefix('admin')->group(function(){
// });

Route::prefix('doctor')->group(function(){
  // Route::post('/login','Auth\DoctorLoginController@login')->name('doctor.login');
  // Route::post('/logout','Auth\LoginController@logoutDoctor')->name('doctor.logout');
  Route::get('/','DoctorController@index')->name('doctor.home');
  Route::get('/profile','DoctorController@profile')->name('doctor.profile');
  Route::get('/profile/{user_id}/edit','DoctorController@editProfile')->name('doctor.edit_profile');
  Route::put('/profile/{user_id}/update','DoctorController@updateProfile')->name('doctor.update_profile');
});

Route::prefix('medical_staff')->group(function(){
  // Route::post('/login','Auth\MedicalStaffLoginController@login')->name('medical_staff.login');
  // Route::post('/logout','Auth\LoginController@logoutMedicalStaff')->name('medical_staff.logout');
  Route::get('/','MedicalStaffController@index')->name('medical_staff.home');
  Route::get('/profile','MedicalStaffController@profile')->name('medical_staff.profile');
  Route::get('/profile/{user_id}/edit','MedicalStaffController@editProfile')->name('medical_staff.edit_profile');
  Route::put('/profile/{user_id}/update','MedicalStaffController@updateProfile')->name('medical_staff.update_profile');

});
