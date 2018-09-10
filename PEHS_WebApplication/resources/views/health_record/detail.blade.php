@extends('layouts.app')
@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-10">
        @if (Auth::guard('doctor')->check())
          @php
          $route = 'doctor.health_record_detail';
          @endphp
        @elseif (Auth::guard('medical_staff')->check())
          @php
          $route = 'health_record.detail';
          @endphp
        @endif
        @php
        $b_text = $p_text = $u_text = $c_text = 'btn btn-link ';
        $b_active = $u_active = $p_active = $c_active= '';
        switch ($category) {
          case 'blood':
          $health_value = 'blood_ex_value';
          $health_name = 'blood_ex_name';
          $b_text .= 'text-light';
          $b_active = 'active';
          $health_standard = 'blood_ex_standard';
          $health_unit = 'blood_ex_unit';
          break;
          case 'urine':
          $health_value = 'urine_ex_value';
          $health_name = 'urine_ex_name';
          $u_text .= 'text-light';
          $u_active = 'active';
          $health_standard = 'urine_ex_standard';
          $health_unit = 'urine_ex_unit';
          break;
          case 'physical':
          $health_value = 'physical_ex_value';
          $health_name = 'physical_ex_name';
          $p_text .= 'text-light';
          $p_active = 'active';
          $health_standard = 'physical_ex_standard';
          $health_unit = 'physical_ex_unit';
          break;
          case 'chemistry':
          $health_value = 'clinical_chemistry_value';
          $health_name = 'clinical_chemistry_name';
          $c_text .= 'text-light';
          $c_active = 'active';
          $health_standard = 'clinical_chemistry_standard';
          $health_unit = 'clinical_chemistry_unit';
          break;
        }
        @endphp

        <div class="card border-secondary">
          <div class="card-header border-secondary bg-transparent"><b>{{_('Health Record Detail')}}</b></div>
          <div class="card-body">
            <ul class="nav nav-pills nav-fill">
              <li class="nav-item">
                <a class="nav-link {{$p_active}}">
                  {!! Form::open(['route' => [$route]]) !!}
                  {!! Form::hidden('health_record_id', $health_record_id) !!}
                  {!! Form::hidden('category', 'physical') !!}
                  {!! Form::submit('Physical', array('class' => $p_text)) !!}
                  {!! Form::close() !!}
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link {{$b_active}}">
                  {!! Form::open(['route' => [$route]]) !!}
                  {!! Form::hidden('health_record_id', $health_record_id) !!}
                  {!! Form::hidden('category', 'blood') !!}
                  {!! Form::submit('Blood', array('class' => $b_text)) !!}
                  {!! Form::close() !!}
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link {{$u_active}}">
                  {!! Form::open(['route' => [$route]]) !!}
                  {!! Form::hidden('health_record_id', $health_record_id) !!}
                  {!! Form::hidden('category', 'urine') !!}
                  {!! Form::submit('Urine', array('class' => $u_text)) !!}
                  {!! Form::close() !!}
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link {{$c_active}}">
                  {!! Form::open(['route' => [$route]]) !!}
                  {!! Form::hidden('health_record_id', $health_record_id) !!}
                  {!! Form::hidden('category', 'chemistry') !!}
                  {!! Form::submit('Clinical Chemistry', array('class' => $c_text)) !!}
                  {!! Form::close() !!}
                </a>
              </li>
            </ul><br />
            <div class="table-responsive">
              <table class="table">
                <thead>
                  <tr>
                    <th class='text-md-center' scope="col">Lab Test</th>
                    <th class='text-md-center' scope="col">Result</th>
                    <th class='text-md-center' scope="col">Standard Range</th>
                    <th class='text-md-center' scope="col">Unit</th>
                  </tr>
                </thead>
                <tbody>
                  @foreach ($healrh_record_detail as $health_info)
                    <tr class='text-md-center'>
                      <td>{{$health_info->$health_name}}</td>
                      <td>{{$health_info->$health_value}}</td>
                      <td>{{$health_info->$health_standard}}</td>
                      <td>{{$health_info->$health_unit}}</td>
                    </tr>
                  @endforeach
                </tbody>
              </table>
            </div>
            <div class=" row justify-content-center">
              @if (Auth::guard('doctor')->check())
                <a href="{{route('doctor.view_hr_list')}}"><button class=" btn btn-secondary center">Back</button></a>
              @elseif(Auth::guard('medical_staff')->check())
                <a href="{{route('m_staff.view_hr_list')}}"><button class=" btn btn-secondary center">Back</button></a>
              @endif

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>



@endsection
