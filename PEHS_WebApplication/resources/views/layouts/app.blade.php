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
</head>
<body>
  <div id="app">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark navbar-laravel">
      <div class="container">
        <a class="navbar-brand" href="{{ url('/') }}">
          {{ config('app.name', 'Laravel') }}
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Left Side Of Navbar -->
          <ul class="navbar-nav mr-auto">
            @if (Auth::guard('admin')->check())
              <li><a class="nav-link" href="{{ route('admin.login') }}">{{ __('Create Doctor') }}</a></li>
              <li><a class="nav-link" href="{{ route('admin.login') }}">{{ __('View Doctor List') }}</a></li>
              <li><a class="nav-link" href="{{ route('admin.login') }}">{{ __('View Patient List') }}</a></li>
            @endif

            @if(Auth::guard('doctor')->check())
              <li><a class="nav-link" href="{{ route('admin.login') }}">{{ __('View Patient List') }}</a></li>
            @endif

          </ul>

          <!-- Right Side Of Navbar -->
          <ul class="navbar-nav ml-auto">
            <!-- Authentication Links -->
            @guest
              <li><a class="nav-link" href="{{ route('admin.login') }}">{{ __('Login as Administrator') }}</a></li>
              <li><a class="nav-link" href="{{ route('doctor.login') }}">{{ __('Login as Doctor') }}</a></li>
              <li><a class="nav-link" href="{{ route('register') }}">{{ __('Register') }}</a></li>
            @else
              <li class="nav-item dropdown">
                <a id="navbarDropdown" class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
                  @if(Auth::guard('doctor')->check())
                    @foreach ($doctors as $doctor)
                      {{$doctor->username}} <span class="caret"></span>
                    @endforeach
                  @elseif(Auth::guard('admin')->check())
                    @foreach ($admins as $admin)
                      {{$admin->username}} <span class="caret"></span>
                    @endforeach

                  @endif
                </a>

                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="{{ route('logout') }}"
                  onclick="event.preventDefault();
                  document.getElementById('logout-form').submit();">
                  {{ __('Logout') }}
                </a>
                @if(Auth::guard('admin')->check())
                  <form id="logout-form" action="{{ route('admin.logout') }}" method="POST" style="display: none;">
                  @elseif(Auth::guard('doctor')->check())
                    <form id="logout-form" action="{{ route('doctor.logout') }}" method="POST" style="display: none;">
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

      <main class="py-4">
        @yield('content')
      </main>
    </div>
  </body>
  </html>
