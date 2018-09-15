<?php

namespace Tests\Feature;

use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithoutMiddleware;
class StaffDeleteHealthRecordTest extends TestCase
{
    use WithoutMiddleware;
    /**
     * A basic test example.
     *
     * @return void
     */
    public function testDeleteHealthRecord()
    {
      $response = $this->json('POST','/medical_staff/delete/health_record/2');
      $response->assertSessionHas('success_hr','Delete health record successfully');
    }
}
