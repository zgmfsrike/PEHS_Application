@extends('layouts.app')
@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-7">
        <div class="card">
          <div class="card-header"><b>{{_('Profile')}}</b></div>
          <div class="card-body">
            @foreach ($users as $i=>$user)
              <div class=" row">
                <label for="name" class="col-md-6 text-md-right"><b>{{ __('Name : ') }}</b></label>
                <div class="col-md-6">
                  <p name="name" id="name">{{$user->name}}</p>
                </div>
              </div>

              <div class="row">
                <label for="surname" class="col-md-6 text-md-right"><b>{{ __('Surname : ') }}</b></label>
                <div class="col-md-6">
                  <p name="surname" id="surname">{{$user->surname}}</p>
                </div>
              </div>

              <div class="row">
                <label for="gender" class="col-md-6 text-md-right"><b>{{ __('Gender : ') }}</b></label>
                <div class="col-md-6">
                  <p id="gender" name="gender">{{$user->gender}}</p>
                </div>
              </div>

              <div class=" row">
                <label for="date_of_birth" class="col-md-6  text-md-right"><b>{{ __('Date of Birth : ') }}</b></label>
                <div class="col-md-6">
                  <p id="date_of_birth" name="date_of_birth">{{$user->date_of_birth }}</p>

                </div>
              </div>

              <div class=" row">
                <label for="address" class="col-md-6  text-md-right"><b>{{ __('Address : ') }}</b></label>

                <div class="col-md-6">
                  <p id="address" name="address">{{$user->address}}</p>
                </div>
              </div>

              <div class="row">
                <label for="telephone_number" class="col-md-6  text-md-right"><b>{{ __('Telephone Number : ') }}</b></label>

                <div class="col-md-6">
                  <p id="telephone_number" name="telephone_number">{{$user->telephone_number }}</p>

                </div>
              </div>


              @if ($user_role == "patient")
                <div class=" row">
                  <label for="drug_allergy" class="col-md-6 text-md-right"><b>{{ __('Drug Allergy : ') }}</b></label>
                  <div class="col-md-6">
                    <p id="drug_allergy" name="drug_allergy">@if($user->drug_allergy == ""){{ _('-') }}@else{{$user->drug_allergy}}@endif</p>
                    </div>
                  </div>

                  <div class="row">
                    <label for="underlying_disease" class="col-md-6 text-md-right"><b>{{ __('Underlying Disease :') }}</b></label>
                    <div class="col-md-6">
                      <p id="underlying_disease" name="underlying_disease">@if($user->underlying_disease== ""){{ _('-') }}@else{{ $user->underlying_disease }}@endif</p>
                      </div>
                    </div>
                  @endif
                @endforeach
                <div>
                  <div class=" row justify-content-center">
                    {{-- <a href="{{route($edit_route,['user_id'=>$user->user_id])}}"><button class="btn btn-warning"><i class="fa fa-cog" style="font-size:24px"></i></button></a> --}}
                    @if(Auth::guard('doctor')->check())
                      <a href="{{route('doctor.edit_profile',['user_id'=>$user_id])}}"><button class=" btn btn-warning">Edit</button></a>&nbsp
                    @elseif(Auth::guard('medical_staff')->check())
                      <a href="{{route('medical_staff.edit_profile',['user_id'=>$user_id])}}"><button class=" btn btn-warning">Edit</button></a>&nbsp
                    @endif
                    @if (Auth::guard('admin')->check())
                      @php
                      switch ($user_role) {
                        case 'doctor':
                        $back_route = 'admin.list_doctor';
                        break;
                        case 'medical_staff':
                        $back_route = 'admin.list_medical_staff';
                        break;
                        case 'patient':
                        $back_route = 'admin.list_patient';
                        break;

                      }
                      @endphp
                      <a href="{{route($back_route) }}"><button class=" btn">back</button></a>
                    @endif
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>



    @endsection
