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
  return view('welcome');
});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');

Route::prefix('admin')->group(function(){
  Route::post('/login','Auth\AdminLoginController@login')->name('admin.login');
  Route::post('/logout','Auth\AdminLoginController@logout')->name('admin.logout');
  Route::get('/','AdminController@index')->name('admin.home');
});

Route::prefix('doctor')->group(function(){
  Route::post('/login','Auth\DoctorLoginController@login')->name('doctor.login');
  Route::post('/logout','Auth\DoctorLoginController@logout')->name('doctor.logout');
  Route::get('/','DoctorController@index')->name('doctor.home');
});

Route::prefix('medical_staff')->group(function(){
  Route::post('/login','Auth\MedicalStaffLoginController@login')->name('medical_staff.login');
  Route::post('/logout','Auth\MedicalStaffLoginController@logout')->name('medical_staff.logout');
  Route::get('/','MedicalStaffController@index')->name('medical_staff.home');
});
