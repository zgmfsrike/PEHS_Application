
@extends('layouts.app')
@section('content')

  <div class="">
    @php
    $route = 'admin.search_user';
    switch ($user_role) {
      case 'doctors':
      $create_user = 'Create Doctor';
      $search_text = "Search Doctor by name";
      break;

      case 'medical_staffs':
      $create_user = 'Create Medical Staff';
      $search_text = "Search Medical Staff by name";
      break;

      case 'patients':
      $create_user = 'Create Patient';
      $search_text = "Search Patient by name";
      break;
    }
    @endphp

    @if(Auth::guard('doctor')->check())
      @php
      $route_profile = 'doctor.view_user_profile';
      $route_history = 'doctor.health_record_history';
      $route = 'doctor.search_user';
      @endphp
    @elseif(Auth::guard('medical_staff')->check())
      @php
      $route_profile = 'm_staff.view_user_profile';
      $route_history = 'health_record.history';
      $route = 'medical_staff.search_user';
      @endphp
    @endif
    <div>
      <div class="col-md-6">
        <form action="{{route($route,['role'=>$user_role])}}" method="POST">
          @csrf
          <div class="input-group float-left ">
            <input class="form-control" id="search" name="search" placeholder="{{$search_text}}" value="@if(!empty($search_value)){{$search_value}}@endif"required>
              <span class="input-group-btn">
                <button type="submit" class="btn btn-secondary"><i class="fa fa-search" style="font-size:24px"></i></button>
              </span>

            </div>
          </form>
        </div>

        @if(Auth::guard('admin')->check())
          <div class="col-md-6-offset">
            <div class="float-right">

              <a href="{{route('admin.create_user',['role'=>$user_role])}}"><button class="btn btn-primary">{{$create_user}}</button></a>
              <p></p>
            </div>

          </div>
        @endif
      </div>




    </div>
    @if(Auth::guard('admin')->check())
      <div class="table table-responsive table-bordered" >
        <table class="table text-center " style="background-color:white;">
          <thead class="">
            @if(!empty ($not_found_user))
              <div class="alert alert-danger text-center">
                {{$not_found_user}}.
              </div>
            @endif
            @if(count($users))
              <tr>
                <th scope="col" class="text-center">Username</th>
                <th scope="col" class="text-center">Name</th>
                <th scope="col" class="text-center">Surname</th>
                <th scope="col" class="text-center">Email</th>
                <th scope="cole" class="text-center">Profile</th>
                <th scope="cole" class="text-center">Edit</th>
                <th scope="cole" class="text-center">Delete</th>

              </tr>
            @endif
          </thead>

          <tbody>


            @foreach ($users as $i=>$user)
              <tr>
                <td>{{$user->username}}</td>
                <td>{{$user->name}}</td>
                <td>{{$user->surname}}</td>
                <td>{{$user->email}}</td>
                <td><a href="{{route('admin.view_user_profile',['user_id'=>$user->user_id,'role'=>$user_role])}}"><button class="btn btn-info ">View</button></a></td>
                <td><a href="{{route('admin.edit_user',['user_id'=>$user->user_id,'role'=>$user_role])}}"><button class="btn btn-warning glyphicon glyphicon-pencil"><i class="fa fa-cog" style="font-size:24px"></i></button></a></td>
                <td>

                  <!-- Button trigger modal -->
                  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_modal_{{$user->user_id}}">
                    <i class="fa fa-remove" style="font-size:24px"></i>
                  </button>

                  <!-- Modal -->
                  <div class="modal fade" id="delete_modal_{{$user->user_id}}" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">Delete Account</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <div class="alert alert-danger">
                            <b><i class="fa fa-warning"></i>&nbsp Are you sure to delete this account ?</b>
                          </div>
                        </div>
                        <div class="modal-footer">
                          <form action="{{route('admin.delete_user',['user_id'=>$user->user_id,'role'=>$user_role])}}" method="post">
                            @csrf
                            {{-- <input type="hidden" name="_method" value="DELETE"> --}}
                            <button type="submit" class="btn btn-danger">Delete</button>

                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                          </form>

                        </div>
                      </div>
                    </div>
                  </div>

                </td>
              </tr>
            @endforeach
          </tbody>
        </table>
      </div>
      <div class="row">
        {{ $users->links() }}
      </div>
    @elseif(Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check())
      @if(!empty ($not_found_user))  <br />
        <div class="alert alert-danger text-center" style=" margin-top:30px;">
          {{$not_found_user}}.
        </div>
      @endif
      @if(count($users))
        <div class="table table-responsive table-bordered " style="margin-top:50px;">
          <table class="table text-center " >
            <thead class="">

              <tr >
                <th scope="col" class="text-center" >Name</th>
                <th scope="col" class="text-center" >Surname</th>
                <th scope="col" class="text-center" >Blood Type</th>
                <th scope="cole" class="text-center" >Drug Allergy</th>
                <th scope="cole" class="text-center" >Underlying Disease</th>
                <th scope="cole" class="text-center">Profile</th>
                <th scope="cole" class="text-center" >History</th>
                @if(Auth::guard('medical_staff')->check())
                  <th scope="cole" class="text-center" >Health Record</th>
                @endif

              </tr>
            @endif
          </thead>

          <tbody>


            @foreach ($users as $i=>$user)
              @php
              if($user->drug_allergy == ""){
                $drug_allergy = "-";
              }else{
                $drug_allergy = $user->drug_allergy ;
              }

              if($user->underlying_disease == ""){
                $underlying_disease = "-";
              }else{
                $underlying_disease = $user->underlying_disease ;
              }
              @endphp
              <tr>
                <td >{{$user->name}}</td>
                <td >{{$user->surname}}</td>
                <td>{{$user->blood_type}}</td>
                <td >{{$drug_allergy}}</td>
                <td >{{$underlying_disease}}</td>
                <td ><a href="{{route($route_profile,['user_id'=>$user->user_id,'role'=>$user_role])}}"><button class="btn btn-info ">View</button></a></td>
                <td >
                  {!! Form::open(['route' => [$route_history]]) !!}
                  {!! Form::hidden('user_id', $user->user_id) !!}
                  {!! Form::submit('Record History', array('class' => 'btn btn-info')) !!}
                  {!! Form::close() !!}
                </td>
                @if(Auth::guard('medical_staff')->check())

                  <td>
                    {!! Form::open(['route' => ['health_record.create']]) !!}
                    {!! Form::hidden('user_id', $user->user_id) !!}
                    {!! Form::submit('Create Health Record', array('class' => 'btn btn-primary')) !!}
                    {!! Form::close() !!}
                  </td>
                @endif
              </tr>
            @endforeach
          </tbody>
        </table>
      </div>
      <div class="row">
        {{ $users->links() }}
      </div>
    @endif



  @endsection
