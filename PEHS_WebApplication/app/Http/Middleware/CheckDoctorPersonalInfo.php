<?php

namespace App\Http\Middleware;
use Auth;
use Closure;
use DB;
use App\UserInformation;

class CheckDoctorPersonalInfo
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
      $id = $request->route('user_id');
      if($id == Auth::user()->user_id){
        return $next($request);
      }
        return redirect()->to('/doctor/view_profile/doctors/'.Auth::user()->user_id);
    }
}
