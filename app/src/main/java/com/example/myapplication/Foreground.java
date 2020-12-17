package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Foreground extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        editText= findViewById(R.id.edit_text_input);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startService(View view){
        String input = editText.getText().toString();
        Intent serviceIntent = new Intent(this,Foreground.class);
        serviceIntent.putExtra("inputExtra", input);
        //ContextCompat.startForegroundService(this, serviceIntent);

     startForegroundService(serviceIntent);

    }
    public void stopService(View v) {
        Intent serviceIntent = new Intent(this,Foreground.class);
        stopService(serviceIntent);
    }
}