package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView v;
    ImageView logo;
    Animation frombottom,fromtop;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        v=(TextView) findViewById(R.id.textView3);
        logo= findViewById(R.id.imageView3);
        frombottom= AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop =AnimationUtils.loadAnimation(this,R.anim.fromtop);
        v.setAnimation(frombottom);
        logo.setAnimation(fromtop);

       handler= new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
       },4000);
    }
}
