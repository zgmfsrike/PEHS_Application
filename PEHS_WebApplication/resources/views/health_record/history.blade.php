@extends('layouts.app')
@section('content')
  <div class="">
      <h3>Health Record History</h3><br />



    @if(Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check())
      @php
      $route = 'admin.home';
      $search_text = 'Search for patient';
      $user_role = 'patients';
      @endphp
    @endif
    <div>
    </div>
    @if(Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check())
      <div class="table-responsive table-bordered">
        <table class="table text-center">
          <thead class="">
            @if(count($health_records))
              <tr>
                <br />
                <th scope="col" class="text-center">ID</th>
                <th scope="col" class="text-center">Date</th>
                <th scope="col" class="text-center">Detail</th>
                @if(Auth::guard('medical_staff')->check())
                  <th scope="col" class="text-center">Edit</th>
                  <th scope="col" class="text-center">Delete</th>
                @endif

              </tr>
            @else
              <br />
              <div class="alert alert-danger text-center">
                {{"Not found the health record information"}}.
              </div>
            @endif
          </thead>

          <tbody>


            @foreach ($health_records as $i=>$health_record)
              @php
              if($health_record->drug_allergy== ""){
                $drug_allergy = "-";
              }else{
                $drug_allergy = $health_record->drug_allergy ;
              }

              if($health_record->underlying_disease == ""){
                $underlying_disease = "-";
              }else{
                $underlying_disease = $health_record->underlying_disease ;
              }
              @endphp
              <tr>
                <td>{{$health_record->health_record_id}}</td>
                <td>{{$health_record->health_record_date}}</td>
                @if(Auth::guard('medical_staff')->check())
                  <td>
                    {!! Form::open(['route' => ['health_record.detail']]) !!}
                    {!! Form::hidden('health_record_id', $health_record->health_record_id) !!}
                    {!! Form::hidden('category', 'physical') !!}
                    {!! Form::submit('Detail', array('class' => 'btn btn-info')) !!}
                    {!! Form::close() !!}
                  </td>
                <td><a href="{{route('health_record.edit',['health_record_id'=>$health_record->health_record_id])}}"><button class="btn btn-warning glyphicon glyphicon-pencil"><i class="fa fa-cog" style="font-size:24px"></i></button></a></td>
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
