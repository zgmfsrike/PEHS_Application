<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Support\Facades\Auth;

class RedirectIfAuthenticated
{
  /**
  * Handle an incoming request.
  *
  * @param  \Illuminate\Http\Request  $request
  * @param  \Closure  $next
  * @param  string|null  $guard
  * @return mixed
  */
  public function handle($request, Closure $next, $guard = null)
  {
    // if (Auth::guard($guard)->check()) {
    //     return redirect('/home');
    // }
    switch ($guard) {
      case 'admin':
      if(Auth::guard($guard)->check()){
        return redirect()->route('admin.home');
      }
      break;

      case 'doctor':
      if(Auth::guard($guard)->check()){
        return redirect()->route('doctor.home');
      }
      break;

      case 'medical_staff':
      if(Auth::guard($guard)->check()){
        return redirect()->route('medical_staff.home');
      }
      break;

      default:
      // code...
      break;
    }

    return $next($request);
  }
}
