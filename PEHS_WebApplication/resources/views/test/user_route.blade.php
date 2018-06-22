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
