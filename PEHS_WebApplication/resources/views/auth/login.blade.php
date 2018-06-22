@extends('layouts.app')

@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">{{ __('Login') }}</div>
          <div class="card-body">
            @if(session('login_fail'))
              <div class="alert alert-danger">
                {{session('login_fail')}}
              </div>
            @endif
            <form method="POST" action="{{route('login')}}">
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

              {{-- <div class="form-group row">
              <div class="col-md-8 ">
              <label for="role" class="col-md-6 col-form-label text-md-right">{{ __('Role ') }}</label>&nbsp&nbsp&nbsp
              <select id="role"  name="role" required >
              <option  disabled>Please Select Role</option>
              <option value="1" @if(old('role') == '1')selected @endif>Admin</option>
              <option value="2" @if(old('role') == '2')selected @endif>Doctor</option>
              <option value="3" @if(old('role') == '3')selected @endif>Medical Staff</option>
            </select>
          </div>
        </div> --}}

        <div class="form-group row mb-0">
          <div class="col-md-8 offset-md-4">
            <button type="submit" class="btn btn-primary">
              {{ __('Login') }}
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
  $('select[name="role"]').on('change', function() {
    /* Act on the event */
    var role = $(this).val();
    if(role == 1){
      $(this).closest('form')
      .attr('action', '/admin/login');
    }else if(role == 2){
      $(this).closest('form')
      .attr('action', '/doctor/login');
    }else if(role == 3){
      $(this).closest('form')
      .attr('action', '/medical_staff/login');
    }
  });
});
</script>
@endsection
