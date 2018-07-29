@extends('layouts.app')

@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card border-secondary">
          <div class="card-header border-secondary bg-transparent">Medical Staff Homepage</div>

          <div class="card-body">
            @if (session('status'))
              <div class="alert alert-success">
                {{ session('status') }}
              </div>
            @endif

            You are logged in as role
            @if (Auth::guard('medical_staff')->check())
              @foreach ($users as $user)
                {{_('Medical Staff')}}

              @endforeach

            @endif

          </div>
        </div>
      </div>
    </div>
  </div>
@endsection
