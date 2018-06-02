<?php

namespace App\Http\Controllers\Auth;

use App\Doctor;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;
use Illuminate\Foundation\Auth\RegistersUsers;

class RegisterController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Register Controller
    |--------------------------------------------------------------------------
    |
    | This controller handles the registration of new users as well as their
    | validation and creation. By default this controller uses a trait to
    | provide this functionality without requiring any additional code.
    |
    */

    use RegistersUsers;

    /**
     * Where to redirect users after registration.
     *
     * @var string
     */
    protected $redirectTo = '/home';

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest');
    }

    /**
     * Get a validator for an incoming registration request.
     *
     * @param  array  $data
     * @return \Illuminate\Contracts\Validation\Validator
     */
    protected function validator(array $data)
    {
        return Validator::make($data, [
            'username' =>'required|string|max:50|unique:doctors',
            'password' => 'required|string|min:6|confirmed|max:200',
            'name' => 'required|string|max:50',
            'surname' => 'required|string|max:50',
            'date_of_birth' =>'required|date_format:Y-m-d|before:tomorrow',
            'address' =>'required|string|max:255',
            'email' => 'required|string|email|max:50|unique:doctors',
            'telephone_number' =>'required|regex:/[0-9]/',
            'gender' =>'required|string|max:50',

        ]);
    }

    /**
     * Create a new user instance after a valid registration.
     *
     * @param  array  $data
     * @return \App\Doctor
     */
    protected function create(array $data)
    {
        return Doctor::create([
            'username' => $data['username'],
            'password' => Hash::make($data['password']),
            'name' => $data['name'],
            'surname' => $data['surname'],
            'date_of_birth' => $data['date_of_birth'],
            'address' => $data['address'],
            'email' => $data['email'],
            'telephone_number' => $data['telephone_number'],
            'gender' => $data['gender'],


        ]);
    }
}
