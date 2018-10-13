@extends('layouts.app')
@section('content')
  <div class="">
    <h3>Health Record List</h3><br />
    @if(session('success_hr'))
      <div class="alert alert-success">
          {{session('success_hr')}}
      </div>
    @endif



    @if(Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check())
      @if(Auth::guard('medical_staff')->check())
        @php
        $route_search = 'health_record.search';
        @endphp

      @elseif(Auth::guard('doctor')->check())
        @php
        $route_search = 'doctor.health_record_search';
        @endphp

      @endif
      @php
      $search_text = 'Search for patient health record';
      $user_role = 'patients';
      @endphp
    @endif
    <div>
      <div class="col-md-6">
        <form action="{{route($route_search)}}" method="POST">
          @csrf
          <div class="input-group float-left ">
            <input class="form-control" id="search" name="search" placeholder="{{$search_text}}" value="@if(!empty($search_value)){{$search_value}}@endif"required>
              <span class="input-group-btn">
                <button type="submit" class="btn btn-secondary"><i class="fa fa-search" style="font-size:24px"></i></button>
              </span>
            </div>
          </form>
        </div>
      </div>




    </div>
    @if(Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check())
      <div class="table-responsive table-bordered">
        <table class="table text-center">
          <thead class="">
            @if(isset($result))
              @if($result == "not_found")<br />
                <div class="alert alert-danger text-center">
                  {{"Not found the health record information"}}.
                </div>
              @endif
            @endif
            @if(count($health_records))
              <tr>
                <br />
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Date</th>
                <th scope="col" class="text-center">Name</th>
                <th scope="col" class="text-center">Surname</th>
                <th scope="col" class="text-center">Detail</th>
                @if(Auth::guard('medical_staff')->check())
                  <th scope="col" class="text-center">Edit</th>
                  <th scope="col" class="text-center">Delete</th>
                @endif

              </tr>
            @endif
          </thead>

          <tbody>


            @foreach ($health_records as $i=>$health_record)
              @php
              if($health_record->drug_allergy== ""){
                $drug_allergy = "-";
              }else{
                $drug_allergy = $user->drug_allergy ;
              }

              if($health_record->underlying_disease == ""){
                $underlying_disease = "-";
              }else{
                $underlying_disease = $user->underlying_disease ;
              }
              @endphp
              <tr>
                <td>{{$health_record->health_record_id}}</td>
                <td>{{$health_record->health_record_date}}</td>
                <td>{{$health_record->name}}</td>
                <td>{{$health_record->surname}}</td>


                @if(Auth::guard('medical_staff')->check())
                  <td>
                    {!! Form::open(['route' => ['health_record.detail']]) !!}
                    {!! Form::hidden('health_record_id', $health_record->health_record_id) !!}
                    {!! Form::hidden('category', 'physical') !!}
                    {!! Form::submit('Detail', array('class' => 'btn btn-info')) !!}
                    {!! Form::close() !!}
                  </td>
                  <td><a href="{{route('health_record.edit',['health_record_id'=>$health_record->health_record_id])}}"><button class="btn btn-warning glyphicon glyphicon-pencil"><i class="fa fa-cog" style="font-size:24px"></i></button></a></td>
                  {{-- <td>
                  {!! Form::open(['route' => ['edit']]) !!}
                  {!! Form::hidden('health_record_id', $health_record->health_record_id) !!}
                  {!! Form::submit('Edit', array('class' => 'btn btn-warning glyphicon glyphicon-pencil')) !!}
                  {!! Form::close() !!}

                </td> --}}
                <td>
                  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete_modal_{{$health_record->health_record_id}}">
                    <i class="fa fa-remove" style="font-size:24px"></i>
                  </button>

                  <div class="modal fade" id="delete_modal_{{$health_record->health_record_id}}" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">Delete Health Record</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <div class="alert alert-danger">
                            <b><i class="fa fa-warning"></i>&nbsp Are you sure to delete this health record ?</b>
                          </div>
                        </div>
                        <div class="modal-footer">
                          <form action="{{route('health_record.delete',['health_record_id'=>$health_record->health_record_id])}}" method="post">
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
              @elseif (Auth::guard('doctor')->check())
                <td>
                  {!! Form::open(['route' => ['doctor.health_record_detail']]) !!}
                  {!! Form::hidden('health_record_id', $health_record->health_record_id) !!}
                  {!! Form::hidden('category', 'physical') !!}
                  {!! Form::submit('Detail', array('class' => 'btn btn-info')) !!}
                  {!! Form::close() !!}
                </td>

              @endif
            </tr>
          @endforeach
        </tbody>
      </table>
    </div>
    <div class="row">
      {{ $health_records->links() }}
    </div>

  @endif



@endsection
