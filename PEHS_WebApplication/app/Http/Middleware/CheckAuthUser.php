<?php

namespace App\Http\Middleware;

use Closure;
use Auth;
class CheckAuthUser
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
    if(Auth::guard('admin')->check() || Auth::guard('doctor')->check() || Auth::guard('medical_staff')->check()){

      return redirect()->to('/login');
    }
    return $next($request);

  }
}
