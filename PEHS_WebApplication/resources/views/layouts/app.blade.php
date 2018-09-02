<!DOCTYPE html>
<html lang="{{ app()->getLocale() }}">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- CSRF Token -->
  <meta name="csrf-token" content="{{ csrf_token() }}">

  <title>{{ config('app.name', 'Laravel') }}</title>

  <!-- Scripts -->
  <script src="{{ asset('js/app.js') }}" defer></script>

  <!-- Fonts -->
  <link rel="dns-prefetch" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

  <!-- Styles -->
  <link href="{{ asset('css/app.css') }}" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
  <div id="app">
    <nav class="navbar navbar-expand-md navbar-light navbar-laravel ">
      <div class="container">
        <a class="navbar-brand" href="{{ url('login') }}">
          {{ config('app.name', 'Laravel') }}
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        @if(Auth::guard('admin')->check())
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!-- Left Side Of Navbar -->
            <ul class="navbar-nav mr-auto">
              <li class="nav-item dropdown">
                <a id="manageDropdown" class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
                  {{ __('Management ') }}<span class="caret"></span>
                </a>


                <div class="dropdown-menu" aria-labelledby="manageDropdown">
                  <a class="nav-link" href="{{ route('admin.list_user',['role'=>'doctors'])}}">{{ __('Doctor') }}</a>
                  <a class="nav-link" href="{{ route('admin.list_user',['role'=>'medical_staffs'])}}">{{ __('MedicalStaff') }}</a>
                  <a class="nav-link" href="{{ route('admin.list_user',['role'=>'patients'])}}">{{ __('Patient') }}</a>
                </div>
              </li>
            </ul>
          @elseif(Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check())
            @php
            switch (Auth::user()->role_id) {
              case 2:
              $list_route = 'doctor.list_patient';
              break;
              case 3:
              $list_route = 'medical_staff.list_patient';
              break;

            }
            @endphp
            <a class="nav-link" href="{{ route($list_route,['role'=>'patients'])}}">{{ __('List of Patient') }}</a>
          @endif
          <!-- Right Side Of Navbar -->
          <ul class="navbar-nav ml-auto">
            <!-- Authentication Links -->
            @guest
              <li><a class="nav-link" href="{{ route('login') }}">{{ __('Login') }}</a></li>
              <li><a class="nav-link" href="{{ route('register_user') }}">{{ __('Register') }}</a></li>
            @else
              <li class="nav-item dropdown">
                <a id="navbarDropdown" class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
                  {{ Auth::user()->username }} <span class="caret"></span>
                </a>

                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  @php
                  $id = Auth::user()->user_id;
                  switch (Auth::user()->role_id) {
                    case 2:
                    $role = 'doctors';
                    break;

                    case 3:
                    $role = 'medical_staffs';
                    break;
                  }
                  @endphp

                  @if(Auth::guard('doctor')->check())
                    <a class="dropdown-item" href="{{route('doctor.view_profile',['user_id'=>$id,'role'=>$role])}}">{{ __('Profile') }}</a>
                  @elseif(Auth::guard('medical_staff')->check())
                    <a class="dropdown-item" href="{{ route('medical_staff.view_profile',['user_id'=>$id,'role'=>$role]) }}">{{ __('Profile') }}</a>
                  @endif
                  <a class="dropdown-item" href="{{ route('logout') }}"
                  onclick="event.preventDefault();
                  document.getElementById('logout-form').submit();">
                  {{ __('Logout') }}
                </a>

                @if(Auth::user())
                  <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                  @endif
                  @csrf

                </form>
              </div>
            </li>

          @endguest
        </ul>
      </div>
    </div>
  </nav>
  <div class="col-md-12 ">
    {{-- @extends('layouts.sidebar') --}}
    <main class="py-4">
      <div class="container">
        @include('manage.message')
        @yield('content')


      </div>

    </main>
  </div>
</div>
</body>
</html>
