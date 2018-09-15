@extends('layouts.app')
@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card  border-secondary">
          <div class="card-header bg-transparent border-secondary"><h5>{{ __('Create Health Record') }}</h5></div>

          <div class="card-body">
            {{-- <form method="POST" action="{{route('health_record.update',['health_record_id'=>1])}}"> --}}
            <form method="POST" action="{{route('health_record.store')}}">
              @csrf
              <input type="text" name="user_id" value='{{$user_id}}' style="display:none">
              <h4>Physical Information</h4><br />

              <div class="form-group row">
                <label for="weight" class="col-md-4 col-form-label text-md-right">{{ __('Weight') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="weight" type="number" step="any" min="0" class="form-control{{ $errors->has('weight') ? ' is-invalid' : '' }}" name="weight" value="{{ old('weight') }}" required autofocus>
                  {{-- <small style="color:#8c8c8c">Must be at least 4 characters, letter and number only.</small> --}}

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
                  <input id="height" type="number" step="any" min="0" class="form-control{{ $errors->has('height') ? ' is-invalid' : '' }}" value="{{ old('height') }}" name="height" required>
                  {{-- <small style="color:#8c8c8c">Must be at least 6 characters, letter and number only.</small> --}}
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
                  <input id="wrist" type="number" step="any" min="0" class="form-control{{ $errors->has('wrist') ? ' is-invalid' : '' }}" name="wrist" value="{{ old('wrist') }}" required>

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
                  <input id="bmi" type="number" step="any" min="0" class="form-control{{ $errors->has('bmi') ? ' is-invalid' : '' }}" name="bmi" value="{{ old('bmi') }}" required autofocus>
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
                  <input id="systolic" type="number" step="any" min="0" class="form-control{{ $errors->has('systolic') ? ' is-invalid' : '' }}" name="systolic" value="{{ old('systolic') }}" required autofocus>

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
                  <input id="diastolic" type="number" step="any" min="0" class="form-control{{ $errors->has('diastolic') ? ' is-invalid' : '' }}" name="diastolic" value="{{ old('diastolic') }}" required autofocus>

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
                  <input id="pulse" type="number" step="any" min="0" class="form-control{{ $errors->has('pulse') ? ' is-invalid' : '' }}" name="pulse" value="{{ old('pulse') }}" required autofocus>

                  @if ($errors->has('pulse'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('pulse') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <h4>Blood Information</h4><br />

              <div class="form-group row">
                <label for="blood_wbc" class="col-md-4 col-form-label text-md-right">{{ __('Blood WBC') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="blood_wbc" type="number" step="any" min="0" class="form-control{{ $errors->has('blood_wbc') ? ' is-invalid' : '' }}" name="blood_wbc" value="{{ old('blood_wbc') }}" required autofocus>
                  {{-- <small style="color:#8c8c8c">Must be at least 4 characters, letter and number only.</small> --}}

                  @if ($errors->has('blood_wbc'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('blood_wbc') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="blood_rbc" class="col-md-4 col-form-label text-md-right">{{ __('Blood RBC') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="blood_rbc" type="number" step="any" min="0" class="form-control{{ $errors->has('blood_rbc') ? ' is-invalid' : '' }}" name="blood_rbc" required>
                  @if ($errors->has('blood_rbc'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('blood_rbc') }}</strong>
                    </span>
                  @endif
                </div>
              </div>



              <div class="form-group row">
                <label for="hgb" class="col-md-4 col-form-label text-md-right">{{ __('HGB') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="hgb" type="number" step="any" min="0" class="form-control{{ $errors->has('hgb') ? ' is-invalid' : '' }}" name="hgb" value="{{ old('hgb') }}" required>

                  @if ($errors->has('hgb'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('hgb') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="hct" class="col-md-4 col-form-label text-md-right">{{ __('HCT') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="hct" type="number" step="any" min="0" class="form-control{{ $errors->has('hct') ? ' is-invalid' : '' }}" name="hct" value="{{ old('hct') }}" required autofocus>
                  @if ($errors->has('hct'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('hct') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="mcv" class="col-md-4 col-form-label text-md-right">{{ __('MCV') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="mcv" type="number" step="any" min="0" class="form-control{{ $errors->has('mcv') ? ' is-invalid' : '' }}" name="mcv" value="{{ old('mcv') }}" required autofocus>

                  @if ($errors->has('mcv'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('mcv') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="mch" class="col-md-4 col-form-label text-md-right">{{ __('MCH') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="mch" type="number" step="any" min="0" class="form-control{{ $errors->has('mch') ? ' is-invalid' : '' }}" name="mch" value="{{ old('mch') }}" required autofocus>

                  @if ($errors->has('mch'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('mch') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="mchc" class="col-md-4 col-form-label text-md-right">{{ __('MCHC') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="mchc" type="number" step="any" min="0" class="form-control{{ $errors->has('mchc') ? ' is-invalid' : '' }}" name="mchc" value="{{ old('mchc') }}" required autofocus>

                  @if ($errors->has('mchc'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('mchc') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="plt_count" class="col-md-4 col-form-label text-md-right">{{ __('PLT count') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="plt_count" type="number" step="any" min="0" class="form-control{{ $errors->has('plt_count') ? ' is-invalid' : '' }}" name="plt_count" value="{{ old('plt_count') }}" required autofocus>

                  @if ($errors->has('plt_count'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('plt_count') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="neutrophil" class="col-md-4 col-form-label text-md-right">{{ __('Neutrophil') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="neutrophil" type="number" step="any" min="0" class="form-control{{ $errors->has('neutrophil') ? ' is-invalid' : '' }}" name="neutrophil" value="{{ old('neutrophil') }}" required autofocus>

                  @if ($errors->has('neutrophil'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('neutrophil') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="lymphocyte" class="col-md-4 col-form-label text-md-right">{{ __('Lymphocyte') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="lymphocyte" type="number" step="any" min="0" class="form-control{{ $errors->has('lymphocyte') ? ' is-invalid' : '' }}" name="lymphocyte" value="{{ old('lymphocyte') }}" required autofocus>

                  @if ($errors->has('lymphocyte'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('lymphocyte') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="monocyte" class="col-md-4 col-form-label text-md-right">{{ __('Monocyte') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="monocyte" type="number" step="any" min="0" class="form-control{{ $errors->has('monocyte') ? ' is-invalid' : '' }}" name="monocyte" value="{{ old('monocyte') }}" required autofocus>

                  @if ($errors->has('monocyte'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('monocyte') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="eosinophil" class="col-md-4 col-form-label text-md-right">{{ __('Eosinophil') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="eosinophil" type="number" step="any" min="0" class="form-control{{ $errors->has('eosinophil') ? ' is-invalid' : '' }}" name="eosinophil" value="{{ old('eosinophil') }}" required autofocus>

                  @if ($errors->has('eosinophil'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('eosinophil') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="basophil" class="col-md-4 col-form-label text-md-right">{{ __('Basophil') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="basophil" type="number" step="any" min="0" class="form-control{{ $errors->has('basophil') ? ' is-invalid' : '' }}" name="basophil" value="{{ old('basophil') }}" required autofocus>

                  @if ($errors->has('basophil'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('basophil') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <h4>Urine Information</h4><br />

              <div class="form-group row">
                <label for="urine_color" class="col-md-4 col-form-label text-md-right">{{ __('Urine Color') }}<b  style="color:red"> *</b></label>
                <div class="col-md-6">
                  <select name="urine_color" id="urine_color" class="form-control{{ $errors->has('urine_color') ? ' is-invalid' : '' }}" required>
                    <option  value="" disabled selected>Please Select</option>
                    <option  value="yellow"  >Yellow</option>
                    <option  value="colorless"  >Colorless</option>
                    <option  value="dark yellow"  >Dark Yellow</option>
                    <option  value="bright yellow">Bright Yellow</option>
                    <option  value="orange">Orange</option>
                    <option  value="red">Red</option>
                    <option  value="brown">Brown</option>
                    <option  value="black">Black</option>
                    <option  value="white">White</option>
                    <option  value="green">Green</option>
                    <option  value="blue">Blue</option>
                    <option  value="purple">Purple</option>
                  </select>
                  @if ($errors->has('urine_color'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('urine_color') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="appearance" class="col-md-4 col-form-label text-md-right">{{ __('Appearance') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  {{-- <input id="appearance" type="text" class="form-control{{ $errors->has('appearance') ? ' is-invalid' : '' }}" name="appearance" value="{{ old('appearance') }}" required> --}}
                  <select name="appearance" id="appearance" class="form-control{{ $errors->has('appearance') ? ' is-invalid' : '' }}" required>
                    <option  value="" disabled selected>Please Select</option>
                    <option  value="clear"  >Clear</option>
                    <option  value="slightly cloudy"  >Slightly Cloudy</option>
                    <option  value="cloudy"  >Cloudy</option>
                    <option  value="turbid"  >Turbid</option>
                  </select>
                  @if ($errors->has('appearance'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('appearance') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="specific_gravity" class="col-md-4 col-form-label text-md-right">{{ __('Specific Gravity') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="specific_gravity" type="number" step="any" min="0" class="form-control{{ $errors->has('specific_gravity') ? ' is-invalid' : '' }}" name="specific_gravity" value="{{ old('specific_gravity') }}" required>
                  @if ($errors->has('specific_gravity'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('specific_gravity') }}</strong>
                    </span>
                  @endif
                </div>
              </div>



              <div class="form-group row">
                <label for="ph" class="col-md-4 col-form-label text-md-right">{{ __('pH') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="ph" type="number" step="any" min="0" class="form-control{{ $errors->has('ph') ? ' is-invalid' : '' }}" name="ph" value="{{ old('ph') }}" required autofocus>
                  @if ($errors->has('ph'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('ph') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="albumin" class="col-md-4 col-form-label text-md-right">{{ __('Albumin') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <select name="albumin" id="albumin" class="form-control{{ $errors->has('albumin') ? ' is-invalid' : '' }}" required>
                    <option  value="" disabled selected>Please Select</option>
                    <option  value="positive">Positive</option>
                    <option  value="negative">Negative</option>
                  </select>
                  @if ($errors->has('albumin'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('albumin') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="sugar" class="col-md-4 col-form-label text-md-right">{{ __('Sugar') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <select name="sugar" id="sugar" class="form-control{{ $errors->has('sugar') ? ' is-invalid' : '' }}" required>
                    <option  value="" disabled selected>Please Select</option>
                    <option  value="positive">Positive</option>
                    <option  value="negative">Negative</option>
                  </select>
                  @if ($errors->has('sugar'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('sugar') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="urine_rbc" class="col-md-4 col-form-label text-md-right">{{ __('Urine RBC') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="urine_rbc" type="number" step="any" min="0" class="form-control{{ $errors->has('urine_rbc') ? ' is-invalid' : '' }}" name="urine_rbc" value="{{ old('urine_rbc') }}" required autofocus>

                  @if ($errors->has('urine_rbc'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('urine_rbc') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="urine_wbc" class="col-md-4 col-form-label text-md-right">{{ __('Urine WBC') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="urine_wbc" type="number" step="any" min="0" class="form-control{{ $errors->has('urine_wbc') ? ' is-invalid' : '' }}" name="urine_wbc" value="{{ old('urine_wbc') }}" required autofocus>

                  @if ($errors->has('urine_wbc'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('urine_wbc') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="epithelial_cell" class="col-md-4 col-form-label text-md-right">{{ __('Epithelial Cell') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="epithelial_cell" type="number" step="any" min="0" class="form-control{{ $errors->has('epithelial_cell') ? ' is-invalid' : '' }}" name="epithelial_cell" value="{{ old('epithelial_cell') }}" required autofocus>

                  @if ($errors->has('epithelial_cell'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('epithelial_cell') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <h4>Clinical Chemistry Information</h4><br />

              <div class="form-group row">
                <label for="glucose" class="col-md-4 col-form-label text-md-right">{{ __('Glucose') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="glucose" type="number" step="any" min="0" class="form-control{{ $errors->has('glucose') ? ' is-invalid' : '' }}" name="glucose" value="{{ old('glucose') }}" required autofocus>

                  @if ($errors->has('glucose'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('glucose') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="bun" class="col-md-4 col-form-label text-md-right">{{ __('BUN') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="bun" type="number" step="any" min="0" class="form-control{{ $errors->has('bun') ? ' is-invalid' : '' }}" name="bun" required>
                  @if ($errors->has('bun'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('bun') }}</strong>
                    </span>
                  @endif
                </div>
              </div>



              <div class="form-group row">
                <label for="creatine" class="col-md-4 col-form-label text-md-right">{{ __('Creatine') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="creatine" type="number" step="any" min="0" class="form-control{{ $errors->has('creatine') ? ' is-invalid' : '' }}" name="creatine" value="{{ old('creatine') }}" required>

                  @if ($errors->has('creatine'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('creatine') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="uric_acid" class="col-md-4 col-form-label text-md-right">{{ __('Uric Acid') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="uric_acid" type="number" step="any" min="0" class="form-control{{ $errors->has('uric_acid') ? ' is-invalid' : '' }}" name="uric_acid" value="{{ old('uric_acid') }}" required autofocus>
                  @if ($errors->has('uric_acid'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('uric_acid') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="cholesterol" class="col-md-4 col-form-label text-md-right">{{ __('Cholesterol') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="cholesterol" type="number" step="any" min="0" class="form-control{{ $errors->has('cholesterol') ? ' is-invalid' : '' }}" name="cholesterol" value="{{ old('cholesterol') }}" required autofocus>

                  @if ($errors->has('cholesterol'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('cholesterol') }}</strong>
                    </span>
                  @endif
                </div>
              </div>


              <div class="form-group row">
                <label for="triglyceride" class="col-md-4 col-form-label text-md-right">{{ __('Triglyceride') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="triglyceride" type="number" step="any" min="0" class="form-control{{ $errors->has('triglyceride') ? ' is-invalid' : '' }}" name="triglyceride" value="{{ old('triglyceride') }}" required autofocus>

                  @if ($errors->has('triglyceride'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('triglyceride') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="hdl_c" class="col-md-4 col-form-label text-md-right">{{ __('HDL-C') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="hdl_c" type="number" step="any" min="0" class="form-control{{ $errors->has('hdl_c') ? ' is-invalid' : '' }}" name="hdl_c" value="{{ old('hdl_c') }}" required autofocus>

                  @if ($errors->has('hdl_c'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('hdl_c') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="ldl" class="col-md-4 col-form-label text-md-right">{{ __('Calculated LDL') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="ldl" type="number" step="any" min="0" class="form-control{{ $errors->has('ldl') ? ' is-invalid' : '' }}" name="ldl" value="{{ old('ldl') }}" required autofocus>

                  @if ($errors->has('ldl'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('ldl') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="ast_sgot" class="col-md-4 col-form-label text-md-right">{{ __('AST/SGOT') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="ast_sgot" type="number" step="any" min="0" class="form-control{{ $errors->has('ast_sgot') ? ' is-invalid' : '' }}" name="ast_sgot" value="{{ old('ast_sgot') }}" required autofocus>

                  @if ($errors->has('ast_sgot'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('ast_sgot') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="alt_sgpt" class="col-md-4 col-form-label text-md-right">{{ __('ALT/SGPT') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="alt_sgpt" type="number" step="any" min="0" class="form-control{{ $errors->has('alt_sgpt') ? ' is-invalid' : '' }}" name="alt_sgpt" value="{{ old('alt_sgpt') }}" required autofocus>

                  @if ($errors->has('alt_sgpt'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('alt_sgpt') }}</strong>
                    </span>
                  @endif
                </div>
              </div>

              <div class="form-group row">
                <label for="alp" class="col-md-4 col-form-label text-md-right">{{ __('ALP') }}<b  style="color:red"> *</b></label>

                <div class="col-md-6">
                  <input id="alp" type="number" step="any" min="0" class="form-control{{ $errors->has('alp') ? ' is-invalid' : '' }}" name="alp" value="{{ old('alp') }}" required autofocus>

                  @if ($errors->has('alp'))
                    <span class="invalid-feedback">
                      <strong>{{ $errors->first('alp') }}</strong>
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
