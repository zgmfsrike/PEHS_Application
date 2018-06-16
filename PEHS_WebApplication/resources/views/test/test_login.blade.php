@extends('layouts.app')
@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">{{ __('Login') }}</div>

          <div class="card-body">
            <form method="POST" action="{{ route('login') }}" >
              @csrf

              <div class="form-group row">
                <label for="username" class="col-sm-4 col-form-label text-md-right">{{ __('Username') }}</label>

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
                <div class="col-md-6 offset-md-4">
                  <div class="role">
                    <label>
                      <select id="role" name="role" >
                        <option selected disabled>Please Select Role</option>
                        <option value="1">Admin</option>
                        <option value="2">Doctor</option>
                        <option value="3">Medical Staff</option>
                      </select>
                    </label>
                  </div>
                </div>
              </div>
              <p id='test'>ROLE</p>
            <div class="form-group row mb-0">
              <div class="col-md-8 offset-md-4">
                <button type="submit" class="btn btn-primary">
                  {{ __('Login') }}
                </button>

                <a class="btn btn-link" href="{{ route('password.request') }}">
                  {{ __('Forgot Your Password?') }}
                </a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

@endsection
