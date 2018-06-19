@extends('layouts.app')
@section('content')
  @php
    switch ($user_role) {
      case 'doctor':
        $edit_route = 'admin.update_doctor';
        $edit_title = 'Edit Doctor Information';
        break;

        case 'medical_staff':
          $edit_route = 'admin.update_medica_staff';
          $edit_title = 'Edit Medical Staff Information';
          break;

          case 'patient':
            $edit_route = 'admin.update_patient';
            $edit_title = 'Edit Patient Information';
            break;

      default:
        // code...
        break;
    }
  @endphp
  <h1>{{$edit_title}}</h1>

    <form action="{{route($edit_route,['user_id'=>$user_id])}}" method="POST">
      @csrf
      @foreach ($users as $i=>$user)
        @if ($user_role == "doctor" || $user_role == "medical_staff")
          <input type="text" name="name" value="{{$user->name}}">
          @if ($errors->has('name'))
            <span class="invalid-feedback">
              <strong>{{ $errors->first('name') }}</strong>
            </span>
          @endif
          <input type="text" name="surname" value="{{$user->surname}}">
        @elseif ($user_role = "patient")
          <input type="text" name="name" value="{{$user->name}}">
          @if ($errors->has('name'))
            <span class="invalid-feedback">
              <strong>{{ $errors->first('name') }}</strong>
            </span>
          @endif
          <input type="text" name="surname" value="{{$user->surname}}">
        @endif
      @endforeach

      <input type="hidden" name="_method" value="PUT">
      <input class="button" type="submit" value="Submit">
    </form>



  @endsection
