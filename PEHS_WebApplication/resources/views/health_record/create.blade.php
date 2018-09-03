<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <div class="card  border-secondary">
        <div class="card-header bg-transparent border-secondary"><h5>{{ __('Register for Patient') }}</h5></div>

        <div class="card-body">
          <form method="POST" action="{{route('health_record.store')}}">
            @csrf

            <div class="form-group row">
              <label for="weight" class="col-md-4 col-form-label text-md-right">{{ __('Weight') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="weight" type="number" class="form-control{{ $errors->has('weight') ? ' is-invalid' : '' }}" name="weight" value="{{ old('weight') }}" required autofocus>
                <small style="color:#8c8c8c">Must be at least 4 characters, letter and number only.</small>

                @if ($errors->has('weight'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('weight') }}</strong>
                  </span>
                @endif
              </div>
            </div>

            <div class="form-group row">
              <label for="height" class="col-md-4 col-form-label text-md-right">{{ __('Height') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="height" type="number" class="form-control{{ $errors->has('height') ? ' is-invalid' : '' }}" name="height" required>
                <small style="color:#8c8c8c">Must be at least 6 characters, letter and number only.</small>
                @if ($errors->has('height'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('height') }}</strong>
                  </span>
                @endif
              </div>
            </div>



            <div class="form-group row">
              <label for="wrist" class="col-md-4 col-form-label text-md-right">{{ __('Wrist') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="wrist" type="number" class="form-control{{ $errors->has('wrist') ? ' is-invalid' : '' }}" name="wrist" value="{{ old('wrist') }}" required>

                @if ($errors->has('wrist'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('wrist') }}</strong>
                  </span>
                @endif
              </div>
            </div>


            <div class="form-group row">
              <label for="bmi" class="col-md-4 col-form-label text-md-right">{{ __('BMI') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="bmi" type="number" class="form-control{{ $errors->has('bmi') ? ' is-invalid' : '' }}" name="bmi" value="{{ old('bmi') }}" required autofocus>
                @if ($errors->has('bmi'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('bmi') }}</strong>
                  </span>
                @endif
              </div>
            </div>

            <div class="form-group row">
              <label for="systolic" class="col-md-4 col-form-label text-md-right">{{ __('Systolic') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="systolic" type="number" class="form-control{{ $errors->has('systolic') ? ' is-invalid' : '' }}" name="systolic" value="{{ old('systolic') }}" required autofocus>

                @if ($errors->has('systolic'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('systolic') }}</strong>
                  </span>
                @endif
              </div>
            </div>


            <div class="form-group row">
              <label for="diastolic" class="col-md-4 col-form-label text-md-right">{{ __('Diastolic') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="diastolic" type="number" class="form-control{{ $errors->has('diastolic') ? ' is-invalid' : '' }}" name="diastolic" value="{{ old('diastolic') }}" required autofocus>

                @if ($errors->has('diastolic'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('diastolic') }}</strong>
                  </span>
                @endif
              </div>
            </div>

            <div class="form-group row">
              <label for="pulse" class="col-md-4 col-form-label text-md-right">{{ __('Pulse') }}<b  style="color:red"> *</b></label>

              <div class="col-md-6">
                <input id="pulse" type="number" class="form-control{{ $errors->has('pulse') ? ' is-invalid' : '' }}" name="pulse" value="{{ old('pulse') }}" required autofocus>

                @if ($errors->has('pulse'))
                  <span class="invalid-feedback">
                    <strong>{{ $errors->first('pulse') }}</strong>
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
