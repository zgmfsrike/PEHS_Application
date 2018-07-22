package com.yangzxcc.macintoshhd.pehs.sql.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yangzxcc.macintoshhd.pehs.R;
import com.yangzxcc.macintoshhd.pehs.sql.model.Patient;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnChangeProfile;
    Patient patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        final Intent intent = getIntent();
        final Patient patient = (Patient)intent.getSerializableExtra("patient");
        tvWelcome.setText(getString(R.string.welcome) + " " + patient.getName());
        btnChangeProfile = (Button)findViewById(R.id.btnChangeProfile);
        btnChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(WelcomeActivity.this,ProfileActivity.class);
                intent1.putExtra("patient", patient);
                startActivity(intent1);
            }
        });

    }
}
