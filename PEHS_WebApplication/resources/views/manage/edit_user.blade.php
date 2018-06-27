@extends('layouts.app')
@section('content')
  @php
  switch ($user_role) {
    case 'doctors':
    $edit_route = 'admin.update_doctor';
    $edit_title = 'Edit Doctor Information';
    break;

    case 'medical_staffs':
    $edit_route = 'admin.update_medica_staff';
    $edit_title = 'Edit Medical Staff Information';
    break;

    case 'patients':
    $edit_route = 'admin.update_patient';
    $edit_title = 'Edit Patient Information';
    break;

    default:
    // code...
    break;
  }
  @endphp
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header"><b>{{$edit_title}}</b></div>
          <div class="card-body">
            @if (Auth::guard('admin')->check())
              <form action="{{route('admin.update_user',['user_id'=>$user_id,'role'=>$user_role])}}" method="POST">
              @elseif(Auth::guard('doctor')->check())
                <form action="{{route('doctor.update_profile',['user_id'=>$user_id,'role'=>$user_role])}}" method="POST">
                @elseif(Auth::guard('medical_staff')->check())
                  <form action="{{route('medical_staff.update_profile',['user_id'=>$user_id,'role'=>$user_role])}}" method="POST">
                  @endif
                  @csrf
                  @foreach ($users as $i=>$user)
                    <div class="form-group row">
                      <label for="name" class="col-md-4 col-form-label text-md-right">{{ __('Name') }}</label>

                      <div class="col-md-6">
                        <input id="name" type="text" class="form-control{{ $errors->has('name') ? ' is-invalid' : '' }}" name="name" value="{{$user->name}}" required autofocus>

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
                        <input id="surname" type="text" class="form-control{{ $errors->has('surname') ? ' is-invalid' : '' }}" name="surname" value="{{ $user->surname }}" required autofocus>

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
                        <input id="date_of_birth" type="date" class="form-control{{ $errors->has('date_of_birth') ? ' is-invalid' : '' }}" value="{{$user->date_of_birth }}" name="date_of_birth" min="{{$min}}" max="{{$max}}" required >

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
                        <textarea id="address" maxlength="200" class="form-control{{ $errors->has('address') ? ' is-invalid' : '' }}" name="address"  required >{{$user->address}}</textarea>

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
                        <input id="telephone_number" type="text" maxlength="15" class="form-control{{ $errors->has('telephone_number') ? ' is-invalid' : '' }}" name="telephone_number" value="{{$user->telephone_number }}"  required >

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
                        <input type="radio" name="gender" id="male" value="male" required @if($user->gender == 'male'){{__('checked')}}@endif>
                          <label for="male">Male</label>&nbsp
                          <input type="radio" name="gender" id="female" value="female" required @if($user->gender == 'female'){{__('checked')}}@endif>
                            <label for="female">Female</label>&nbsp
                            <input type="radio" name="gender" id="other" value="other" required @if($user->gender == 'other'){{__('checked')}}@endif>
                              <label for="other">Other</label>
                              @if ($errors->has('gender'))
                                <span class="invalid-feedback">
                                  <strong>{{ $errors->first('gender') }}</strong>
                                </span>
                              @endif
                            </div>
                          </div>
                          @if ($user_role == "patients")
                            <div class="form-group row">
                              <label for="drug_allergy" class="col-md-4 col-form-label text-md-right">{{ __('Drug Allergy') }}</label>
                              <div class="col-md-6">
                                <textarea id="drug_allergy" maxlength="100" class="form-control{{ $errors->has('drug_allergy') ? ' is-invalid' : '' }}" name="drug_allergy" >{{$user->drug_allergy}}</textarea>
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
                                <textarea id="underlying_disease" maxlength="100" class="form-control{{ $errors->has('underlying_disease') ? ' is-invalid' : '' }}" name="underlying_disease">{{ $user->underlying_disease }}</textarea>
                                @if ($errors->has('underlying_disease'))
                                  <span class="invalid-feedback">
                                    <strong>{{ $errors->first('underlying_disease') }}</strong>
                                  </span>
                                @endif
                              </div>
                            </div>
                          @endif
                        @endforeach
                        <div class="form-group row mb-0">
                          <div class="col-md-6 offset-md-4">
                            <input type="hidden" name="_method" value="PUT">
                            <button type="submit" class="btn btn-primary">
                              {{ __('Submit') }}
                            </button>&nbsp
                            @if (Auth()->guard('admin')->check())
                                <a href="{{route('admin.list_user',['role'=>$user_role]) }}"  class="btn btn-secondary">Back</a>
                            @elseif(Auth()->guard('doctor')->check())
                              <a href="{{route('doctor.view_profile',['role'=>$user_role,'user_id'=>$user_id]) }}"  class="btn btn-secondary">Back</a>
                            @elseif(Auth()->guard('medical_staff')->check())
                              <a href="{{route('medical_staff.view_profile',['role'=>$user_role,'user_id'=>$user_id]) }}"  class="btn btn-secondary">Back</a>
                            @endif

                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          @endsection
