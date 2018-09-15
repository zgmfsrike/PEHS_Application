<?php

namespace Tests\Feature;

use Tests\TestCase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithoutMiddleware;
class StaffUpdateHealthRecordTest extends TestCase
{
  use WithoutMiddleware;
  /**
  * A basic test example.
  *
  * @return void
  */
  public function testUpdateHealthrecord()
  {
    // code...
    $this->startSession();
    $health_information =[
      'health_record_id'=>2,
      'weight'=>99,
      'height'=>181,
      'wrist'=>78,
      'bmi'=>21.2,
      'systolic'=>117,
      'diastolic'=>75,
      'pulse'=>60,

      'blood_wbc'=>8.0,
      'blood_rbc'=>6.24,
      'hgb'=>14.0,
      'hct'=>40.3,
      'mcv'=>89,
      'mch'=>27,
      'mchc'=>31,
      'plt_count'=>322,
      'neutrophil'=>50,
      'lymphocyte'=>38,
      'monocyte'=>9,
      'eosinophil'=>3,
      'basophil'=>1,

      'urine_color'=>"yellow",
      'appearance'=>"clear",
      'specific_gravity'=>1.002,
      'ph'=>4,
      'albumin'=>"negative",
      'sugar'=>"negative",
      'urine_rbc'=>2,
      'urine_wbc'=>3,
      'epithelial_cell'=>3,

      'glucose'=>77,
      'bun'=>9.9,
      'creatine'=>1.12,
      'uric_acid'=>3.98,
      'cholesterol'=>200,
      'triglyceride'=>127,
      'hdl_c'=>19,
      'ldl'=>70,
      'ast_sgot'=>20,
      'alt_sgpt'=>40,
      'alp'=>109,
    ];
    $response = $this->json('POST','/medical_staff/update/health_record',$health_information);
    $response->assertSessionHas('success_hr','Update health record successfully');
  }

  public function testUpdateHealthrecordWithInvalidInfo()
  {
    // code...
    $this->startSession();
    $health_information =[
      'health_record_id'=>2,
      'weight'=>'ssssss',
      'height'=>181,
      'wrist'=>78,
      'bmi'=>21.2,
      'systolic'=>117,
      'diastolic'=>75,
      'pulse'=>60,

      'blood_wbc'=>8.0,
      'blood_rbc'=>6.24,
      'hgb'=>14.0,
      'hct'=>40.3,
      'mcv'=>89,
      'mch'=>27,
      'mchc'=>31,
      'plt_count'=>322,
      'neutrophil'=>50,
      'lymphocyte'=>38,
      'monocyte'=>9,
      'eosinophil'=>3,
      'basophil'=>1,

      'urine_color'=>"yellow",
      'appearance'=>"clear",
      'specific_gravity'=>1.002,
      'ph'=>4,
      'albumin'=>"negative",
      'sugar'=>"negative",
      'urine_rbc'=>2,
      'urine_wbc'=>3,
      'epithelial_cell'=>3,

      'glucose'=>77,
      'bun'=>9.9,
      'creatine'=>1.12,
      'uric_acid'=>3.98,
      'cholesterol'=>200,
      'triglyceride'=>127,
      'hdl_c'=>19,
      'ldl'=>70,
      'ast_sgot'=>20,
      'alt_sgpt'=>40,
      'alp'=>109,
    ];
    $response = $this->json('POST','/medical_staff/update/health_record',$health_information);
    $this->see('The weight must be a number.');
  }
  public function testUpdateHealthrecordWithEmptyInfo()
  {
    // code...
    $this->startSession();
    $health_information =[
      'health_record_id'=>2,
      'weight'=>'',
      'height'=>181,
      'wrist'=>78,
      'bmi'=>21.2,
      'systolic'=>117,
      'diastolic'=>75,
      'pulse'=>60,

      'blood_wbc'=>8.0,
      'blood_rbc'=>6.24,
      'hgb'=>14.0,
      'hct'=>40.3,
      'mcv'=>89,
      'mch'=>27,
      'mchc'=>31,
      'plt_count'=>322,
      'neutrophil'=>50,
      'lymphocyte'=>38,
      'monocyte'=>9,
      'eosinophil'=>3,
      'basophil'=>1,

      'urine_color'=>"yellow",
      'appearance'=>"clear",
      'specific_gravity'=>1.002,
      'ph'=>4,
      'albumin'=>"negative",
      'sugar'=>"negative",
      'urine_rbc'=>2,
      'urine_wbc'=>3,
      'epithelial_cell'=>3,

      'glucose'=>77,
      'bun'=>9.9,
      'creatine'=>1.12,
      'uric_acid'=>3.98,
      'cholesterol'=>200,
      'triglyceride'=>127,
      'hdl_c'=>19,
      'ldl'=>70,
      'ast_sgot'=>20,
      'alt_sgpt'=>40,
      'alp'=>109,
    ];
    $response = $this->json('POST','/medical_staff/update/health_record',$health_information);
    $this->see('The weight field is required.');
  }
}
