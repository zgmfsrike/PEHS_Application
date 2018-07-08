@extends('layouts.app')

@section('content')

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">{{ __('Register') }}</div>

          <div class="card-body">
            <form method="POST" action="{{route('patient.register',['role'=>'patients'])}}">
              @csrf

              <div class="form-group row">
                <label for="username" class="col-md-4 col-form-label text-md-right">{{ __('Username') }}</label>

                <div class="col-md-6">
                  <input id="username" type="text" class="form-control{{ $errors->has('username') ? ' is-invalid' : '' }}" name="username" value="{{ old('username') }}" required autofocus>

                  @if ($errors->has('username'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('username') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="password" class="col-md-4 col-form-label text-md-right">{{ __('Password') }}</label>

                <div class="col-md-6">
                  <input id="password" type="password" class="form-control{{ $errors->has('password') ? ' is-invalid' : '' }}" name="password" required>

                  @if ($errors->has('password'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('password') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="password-confirm" class="col-md-4 col-form-label text-md-right">{{ __('Confirm Password') }}</label>

                <div class="col-md-6">
                  <input id="password-confirm" type="password" class="form-control" name="password_confirmation" required>
                </div>
              </div>

              <div class="form-group row">
                <label for="email" class="col-md-4 col-form-label text-md-right">{{ __('E-Mail Address') }}</label>

                <div class="col-md-6">
                  <input id="email" type="email" class="form-control{{ $errors->has('email') ? ' is-invalid' : '' }}" name="email" value="{{ old('email') }}" required>

                  @if ($errors->has('email'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('email') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="name" class="col-md-4 col-form-label text-md-right">{{ __('Name') }}</label>

                <div class="col-md-6">
                  <input id="name" type="text" class="form-control{{ $errors->has('name') ? ' is-invalid' : '' }}" name="name" value="{{ old('name') }}" required autofocus>

                  @if ($errors->has('name'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('name') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="surname" class="col-md-4 col-form-label text-md-right">{{ __('Surname') }}</label>

                <div class="col-md-6">
                  <input id="surname" type="text" class="form-control{{ $errors->has('surname') ? ' is-invalid' : '' }}" name="surname" value="{{ old('surname') }}" required autofocus>

                  @if ($errors->has('surname'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('surname') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="date_of_birth" class="col-md-4 col-form-label text-md-right">{{ __('Date of Birth') }}</label>
                @php
                $today = date("Y-m-d");
                $min = date('Y-m-d',strtotime($today.' -100 years'));;
                $max = $today;
                @endphp
                <div class="col-md-6">
                  <input id="date_of_birth" type="date" class="form-control{{ $errors->has('date_of_birth') ? ' is-invalid' : '' }}" value="{{ old('date_of_birth') }}" name="date_of_birth" min="{{$min}}" max="{{$max}}" required >

                  @if ($errors->has('date_of_birth'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('date_of_birth') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="address" class="col-md-4 col-form-label text-md-right">{{ __('Address') }}</label>

                <div class="col-md-6">
                  <textarea id="address" maxlength="200" class="form-control{{ $errors->has('address') ? ' is-invalid' : '' }}" name="address"  required >{{ old('address') }}</textarea>

                  @if ($errors->has('address'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('address') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="telephone_number" class="col-md-4 col-form-label text-md-right">{{ __('Telephone Number') }}</label>

                <div class="col-md-6">
                  <input id="telephone_number" type="text" maxlength="15" class="form-control{{ $errors->has('telephone_number') ? ' is-invalid' : '' }}" name="telephone_number" value="{{ old('telephone_number') }}"  required >

                  @if ($errors->has('telephone_number'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('telephone_number') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="gender" class="col-md-4 col-form-label text-md-right">{{ __('Gender') }}</label>
                <div class="col-md-6">
                  @foreach ($gender as $user_gender)
                    <input type="radio" name="gender" id="{{$user_gender->gender}}" value="{{$user_gender->gender_id}}" required @if(old('gender')=="{{$user_gender->gender}}"){{'checked'}}@endif >
                      <label for="{{$user_gender->gender}}">{{$user_gender->gender}}</label>&nbsp
                    @endforeach
                    {{-- <input type="radio" name="gender" id="male" value="male" required @if(old('gender')=="male"){{'checked'}}@endif >
                    <label for="male">Male</label>&nbsp
                    <input type="radio" name="gender" id="female" value="female" required @if(old('gender')=="female"){{'checked'}}@endif>
                    <label for="female">Female</label>&nbsp
                    <input type="radio" name="gender" id="other" value="other" required @if(old('gender')=="other"){{'checked'}}@endif>
                    <label for="other">Other</label> --}}
                    @if ($errors->has('gender'))
                      <span class="invalid-feedback">
                        <strong>{{ $errors->first('gender') }}</strong>
                      </span>
                    @endif
                  </div>
                </div>



                <div class="form-group row">
                  <label for="blood_type" class="col-md-4 col-form-label text-md-right">{{ __('Blood Type') }}</label>

                  <div class="col-md-3">
                    <select required name="blood_type" id="blood_type" class="form-control{{ $errors->has('blood_type') ? ' is-invalid' : '' }}" >
                      <option  value="" disabled selected>Please Select</option>
                      @foreach ($blood_type as $user_blood_type)
                        <option value="{{$user_blood_type->blood_type_id}}" >{{$user_blood_type->blood_type}}</option>
                      @endforeach
                    </select>
                    @if ($errors->has('blood_type'))
                      <span class="invalid-feedback">
                        <strong>{{ $errors->first('blood_type') }}</strong>
                      </span>
                    @endif
                  </div>
                </div>

                <div class="form-group row">
                  <label for="personal_id" class="col-md-4 col-form-label text-md-right">{{ __('National ID/Passport ID') }}</label>

                  <div class="col-md-6">
                    <input id="personal_id" type="text" maxlength="15" class="form-control{{ $errors->has('personal_id') ? ' is-invalid' : '' }}" name="personal_id" value="{{ old('personal_id') }}"  required >

                    @if ($errors->has('personal_id'))
                      <span class="invalid-feedback">
                        <strong>{{ $errors->first('personal_id') }}</strong>
                      </span>
                    @endif
                  </div>
                </div>


                <div class="form-group row">
                <label for="drug_allergy" class="col-md-4 col-form-label text-md-right">{{ __('Drug Allergy') }}</label>
                <div class="col-md-6">
                  <textarea id="drug_allergy" maxlength="100" class="form-control{{ $errors->has('drug_allergy') ? ' is-invalid' : '' }}" name="drug_allergy"   >{{ old('drug_allergy') }}</textarea>
                  @if ($errors->has('drug_allergy'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('drug_allergy') }}</strong>
                    </span>
                  @endif
                </div>
              </div>



              <div class="form-group row">
              <label for="underlying_disease" class="col-md-4 col-form-label text-md-right">{{ __('Underlying Disease') }}</label>
              <div class="col-md-6">
                <textarea id="underlying_disease" maxlength="100" class="form-control{{ $errors->has('underlying_disease') ? ' is-invalid' : '' }}" name="underlying_disease" >{{ old('underlying_disease') }}</textarea>
                @if ($errors->has('underlying_disease'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('underlying_disease') }}</strong>
                  </span>
                @endif
              </div>
            </div>
                <div class="form-group row mb-0">
                  <div class="col-md-6 offset-md-4">
                    <button type="submit" name="submit" class="btn btn-primary">
                      {{ __('Submit') }}
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  @endsection
