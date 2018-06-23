
@if(session('success'))
  <div class="alert alert-success">
    {{session('success')}}
  </div>
@endif

@if(session('error'))
  <div class="alert alert-danger">
    {{session('error')}}
  </div>
@endif

@if(session('id_exist'))
  <div class="alert alert-danger">
    {{session('id_exist')}}
  </div>
@endif
