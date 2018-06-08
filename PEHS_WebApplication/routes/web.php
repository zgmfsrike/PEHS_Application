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
})->name('welcome');


Auth::routes();

Route::get('/home', 'HomeController@index');

Route::prefix('admin')->group(function(){
  Route::get('/', 'AdminController@index')->name('admin.dashboard');
  Route::get('/login','Auth\AdminLoginController@showLoginForm')->name('admin.login');
  Route::post('/login','Auth\AdminLoginController@login')->name('admin.login.submit');
  Route::post('/logout','Auth\AdminLoginController@logout')->name('admin.logout');

  // Route::resource('manage-doctor','ManageDoctorController');

});
Route::prefix('doctor')->group(function(){
  Route::get('/', 'DoctorController@index')->name('doctor.dashboard');
  Route::get('/login','Auth\DoctorLoginController@showLoginForm')->name('doctor.login');
  Route::post('/login','Auth\DoctorLoginController@login')->name('doctor.login.submit');
  Route::post('/logout','Auth\DoctorLoginController@logout')->name('doctor.logout');
  Route::get('/list_doctor','DoctorController@listDoctor');

});
