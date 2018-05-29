@extends('layouts.app')

@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">{{ __('Register') }}</div>

          <div class="card-body">
            <form method="POST" action="{{ route('register') }}">
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
                  <input id="surname" type="text" class="form-control{{ $errors->has('surname') ? ' is-invalid' : '' }}" name="surname" value="{{ old('surname') }}"  required autofocus>

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
                  <textarea id="address" class="form-control{{ $errors->has('address') ? ' is-invalid' : '' }}" name="address" value="{{ old('address') }}"  required ></textarea>

                  @if ($errors->has('address'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('address') }}</strong>
                    </span>
                  @endif
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
                  <select name="gender" id="gender" lass="form-control{{ $errors->has('gender') ? ' is-invalid' : '' }}" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                  </select>
                  @if ($errors->has('gender'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('gender') }}</strong>
                    </span>
                  @endif
                </div>
              </div>





              <div class="form-group row mb-0">
                <div class="col-md-6 offset-md-4">
                  <button type="submit" class="btn btn-primary">
                    {{ __('Register') }}
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
