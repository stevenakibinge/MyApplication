package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity implements View.OnClickListener {
    private Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        start  = findViewById(R.id.btnservice_start);
        stop =findViewById(R.id.btnservice_stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==start){
            startService(new Intent(this,Myservice.class));

        }else
            if(v==stop){
                stopService(new Intent(this,Myservice.class));

            }

    }
}