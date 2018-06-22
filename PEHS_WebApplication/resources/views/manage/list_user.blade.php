@extends('layouts.app')
@section('content')
    <div class="float-right ">
      @php
      switch ($user_role) {
        case 'doctor':
        $create_route = 'admin.create_doctor';
        $create_user = 'Create Doctor';
        $edit_route = 'admin.edit_doctor';
        $delete_route = 'admin.delete_doctor';
        $profile_route = "admin.view_doctor_profile";
        break;

        case 'medical_staff':
        $create_route = 'admin.create_medical_staff';
        $create_user = 'Create Medical Staff';
        $edit_route = 'admin.edit_medical_staff';
        $delete_route = 'admin.delete_medicalStaff';
        $profile_route = 'admin.view_medical_staff_profile';
        break;

        case 'patient':
        $create_route = 'admin.create_patient';
        $create_user = 'Create Patient';
        $edit_route = 'admin.edit_patient';
        $delete_route = 'admin.delete_patient';
        $profile_route = 'admin.view_patient_profile';
        break;
      }
      @endphp
      <a href="{{route($create_route)}}"><button class="btn btn-primary">{{$create_user}}</button></a>
      <p></p>
    </div>
    <div class="table-responsive">
      <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Email</th>
            <th scope="cole">Profile</th>
            <th></th>
            <th></th>
            <th></th>

          </tr>
        </thead>
        <tbody>
          @foreach ($users as $i=>$user)
            <tr>
              <th scope="row">{{$user->user_id}}</th>
              <td>{{$user->name}}</td>
              <td>{{$user->surname}}</td>
              <td>{{$user->email}}</td>
              <td><a href="{{route($profile_route,['user_id'=>$user->user_id])}}"><button class="btn btn-info">View</button></a></td>
              <td><a href="{{route($edit_route,['user_id'=>$user->user_id])}}"><button class="btn btn-warning glyphicon glyphicon-pencil"><i class="fa fa-cog" style="font-size:24px"></i></button></a></td>
              <td>
                <form action="{{route($delete_route,['user_id'=>$user->user_id])}}" method="post">
                  @csrf
                  <input type="hidden" name="_method" value="DELETE">
                  <button type="submit" class="btn btn-danger"><i class="fa fa-remove" style="font-size:24px"></i></button>
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
