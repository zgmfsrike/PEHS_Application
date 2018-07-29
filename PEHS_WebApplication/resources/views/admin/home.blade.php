@extends('layouts.app')


@section('content')
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card border-secondary">
          <div class="card-header bg-transparent border-secondary">Admin Homepage</div>

          <div class="card-body">
            @if (session('status'))
              <div class="alert alert-success">
                {{ session('status') }}
              </div>
            @endif

            You are logged in as role
            @if (Auth::guard('admin')->check())
              @foreach ($admin as $object)
                {{_('Admin')}}

              @endforeach

            @endif

          </div>
        </div>
      </div>
    </div>
  </div>
@endsection
