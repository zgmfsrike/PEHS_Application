<?php

namespace App\Http\Middleware;

use Closure;

class CheckMStaffPersonalInfo
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
        return redirect()->to('/doctor/view_profile/medical_staffs/'.Auth::user()->user_id);
    }
}
