<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
class UserTableSeeder extends Seeder
{
  /**
  * Run the database seeds.
  *
  * @return void
  */
  public function run()
  {




    DB::table('user_informations')->insert([
      [
        'name'=>'adminz',
        'surname'=>'adminz',
        'email'=>'adminz@gmail.com',
        'address'=>'adminz',
        'telephone_number'=>'0846256256',
        'date_of_birth'=>'2018-07-07',
        'personal_id'=>'1929900553039',
        'gender'=>1,
        'blood_type'=>1,

      ],
      [
        'name'=>'sommai',
        'surname'=>'tongsuk',
        'email'=>'s_ts@gmail.com',
        'address'=>'Tumbol Suthep Amphoe Mueang Chiang Mai Chiang Mai 50200',
        'telephone_number'=>'0853221770',
        'date_of_birth'=>'1999-05-07',
        'personal_id'=>'1509901738100',
        'gender'=>1,
        'blood_type'=>1,

      ],
      [
        'name'=>'Somsak',
        'surname'=>'Tongdee',
        'email'=>'S_td@gmail.com',
        'address'=>'5 Vibhavadee-Rangsit Road, Lardyao 2 10900',
        'telephone_number'=>'0846256256',
        'date_of_birth'=>'2018-06-08',
        'personal_id'=>'1509901738101',
        'gender'=>1,
        'blood_type'=>1,

      ],
      [
        'name'=>'kanok',
        'surname'=>'deeyium',
        'email'=>'K_ds@gmail.com',
        'address'=>'477 Soi Forknang Sukhumvit Bang Poo Mai Mueang Samut Prakarn Samut Prakan 10280',
        'telephone_number'=>'0813598775',
        'date_of_birth'=>'1988-08-12',
        'personal_id'=>'1509901738102',
        'gender'=>1,
        'blood_type'=>1,

      ],
      [
        'name'=>'Nimmit',
        'surname'=>'Tangwongsan',
        'email'=>'Nim_t@gmail.com',
        'address'=>'180 Dimon Sea Plaza Thaweewong Road ',
        'telephone_number'=>'0846931258',
        'date_of_birth'=>'1987-12-12',
        'personal_id'=>'1509901738103',
        'gender'=>1,
        'blood_type'=>1,

      ],
      [
        'name'=>'nipoom',
        'surname'=>'Nitiya',
        'email'=>'nipon@gmail.com',
        'address'=>'244 Manee Nopparat Road Sripoom, 50200 Muang ',
        'telephone_number'=>'0853223926',
        'date_of_birth'=>'2007-06-05',
        'personal_id'=>'1563374889253',
        'gender'=>1,
        'blood_type'=>1,

      ]
    ]


  );

  DB::table('users')->insert([
    [
      'username'=>'adminz',
      'password'=>Hash::make('7744536'),
      'user_id'=>1,
    ],
    [
      'username'=>'sommai1',
      'password'=>Hash::make('123456'),
      'user_id'=>2,
    ],
    [
      'username'=>'Somsak',
      'password'=>Hash::make('123456'),
      'user_id'=>3,
    ],
    [
      'username'=>'Konnok',
      'password'=>Hash::make('123456'),
      'user_id'=>4,
    ],
    [
      'username'=>'Nimmit',
      'password'=>Hash::make('123456'),
      'user_id'=>5,
    ],
    [
      'username'=>'nipon',
      'password'=>Hash::make('123456'),
      'user_id'=>6,
    ]
  ]
);

DB::table('user_roles')->insert([
  [
    'user_id'=>1,
    'role_id'=>1,
  ],
  [
    'user_id'=>2,
    'role_id'=>2,
  ],
  [
    'user_id'=>3,
    'role_id'=>2,
  ],
  [
    'user_id'=>4,
    'role_id'=>3,
  ],
  [
    'user_id'=>5,
    'role_id'=>4,
  ],
  [
    'user_id'=>6,
    'role_id'=>4,
  ]
]
);








}
}
