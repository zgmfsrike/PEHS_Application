package com.yangzxcc.macintoshhd.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yangzxcc.macintoshhd.pehs.R;

public class EditProfile extends AppCompatActivity {

    TextInputLayout textInputLayoutName;
    TextInputEditText textInputEditName;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        textInputLayoutName=(TextInputLayout)findViewById(R.id.textInputLayoutName);
        textInputEditName=(TextInputEditText)findViewById(R.id.textInputEditName);
        btnUpdate=(Button)findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfile.this,Profile.class));

            }
        });
    }


}
