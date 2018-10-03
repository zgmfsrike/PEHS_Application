package com.yangzxcc.macintoshhd.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yangzxcc.macintoshhd.HealthAdapter;
import com.yangzxcc.macintoshhd.pehs.R;

public class RecordHelper extends AppCompatActivity{

    HealthAdapter healthAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_helper);

        healthAdapter.setOnItemClickListener(new HealthAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Context context = v.getContext();
                Intent intent = new Intent();
                switch (position){
                    case 0:
                        intent = new Intent(context,Record.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }
}
