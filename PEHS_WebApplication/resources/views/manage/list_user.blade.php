@extends('layouts.app')
@section('content')
  <div class="">
    @php
    switch ($user_role) {
      case 'doctor':
      $create_route = 'admin.create_doctor';
      $create_user = 'Create Doctor';
      $edit_route = 'admin.edit_doctor';
      $delete_route = 'admin.delete_doctor';
      $profile_route = "admin.view_doctor_profile";
      $search_text = "Search Doctor by name";
      $search_route = "admin.search_doctor";
      break;

      case 'medical_staff':
      $create_route = 'admin.create_medical_staff';
      $create_user = 'Create Medical Staff';
      $edit_route = 'admin.edit_medical_staff';
      $delete_route = 'admin.delete_medicalStaff';
      $profile_route = 'admin.view_medical_staff_profile';
      $search_text = "Search Medical Staff by name";
      $search_route = "admin.search_medical_staff";
      break;

      case 'patient':
      $create_route = 'admin.create_patient';
      $create_user = 'Create Patient';
      $edit_route = 'admin.edit_patient';
      $delete_route = 'admin.delete_patient';
      $profile_route = 'admin.view_patient_profile';
      $search_text = "Search Patient by name";
      $search_route = "admin.search_patient";
      break;
    }
    @endphp
    <div>
      <div class="col-md-6">
        <form action="{{route($search_route)}}" method="POST">
          @csrf
          <div class="input-group float-left ">
            <input class="form-control" id="search" name="search" placeholder="{{$search_text}}" value="@if(!empty($search_value)){{$search_value}}@endif"required>
              <span class="input-group-btn">
                <button type="submit" class="btn btn-default"><i class="fa fa-search" style="font-size:24px"></i></button>
              </span>
            </div>
          </form>
        </div>
        <div class="col-md-6-offset">
          <div class="float-right">
            <a href="{{route($create_route)}}"><button class="btn btn-primary">{{$create_user}}</button></a>
            <p></p>
          </div>

        </div>


      </div>




    </div>
    <div class="table-responsive table-bordered">
      <table class="table text-center">
        <thead class="thead-light">
          <tr>
            <th scope="col" class="text-center">ID</th>
            <th scope="col" class="text-center">Username</th>
            <th scope="col" class="text-center">Name</th>
            <th scope="col" class="text-center">Surname</th>
            <th scope="col" class="text-center">Email</th>
            <th scope="cole" class="text-center">Profile</th>
            <th scope="cole" class="text-center">Edit</th>
            <th scope="cole" class="text-center">Delete</th>
          </tr>
        </thead>
        <tbody>
          @foreach ($users as $i=>$user)
            <tr>
              <th scope="row">{{$user->user_id}}</th>
              <td>{{$user->username}}</td>
              <td>{{$user->name}}</td>
              <td>{{$user->surname}}</td>
              <td>{{$user->email}}</td>
              <td><a href="{{route($profile_route,['user_id'=>$user->user_id])}}"><button class="btn btn-info ">View</button></a></td>
              <td><a href="{{route($edit_route,['user_id'=>$user->user_id])}}"><button class="btn btn-warning glyphicon glyphicon-pencil"><i class="fa fa-cog" style="font-size:24px"></i></button></a></td>
              <td>
                <form action="{{route($delete_route,['user_id'=>$user->user_id])}}" method="post">
                  @csrf
                  <input type="hidden" name="_method" value="DELETE">


                  <!-- Button trigger modal -->
                  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_modal">
                    <i class="fa fa-remove" style="font-size:24px"></i>
                  </button>

                  <!-- Modal -->
                  <div class="modal fade" id="delete_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                          <button type="submit" class="btn btn-danger">Delete</button>
                          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>

                        </div>
                      </div>
                    </div>
                  </div>
                </form>
              </td>
            </tr>
          @endforeach
        </tbody>
      </table>
    </div>
    <div class="row">
      {{ $users->links() }}
    </div>


  @endsection
