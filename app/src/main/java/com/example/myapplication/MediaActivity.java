package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MediaActivity extends AppCompatActivity {
   MediaPlayer player;

    Button bPlay;

    Button bStop_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
       bPlay=(Button)findViewById(R.id.play);
       bPlay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               player = MediaPlayer.create(getApplicationContext(),R.raw.tomorrow);
               player.start();
           }
       });
       bStop_pause = (Button)findViewById(R.id.pause);
       bStop_pause.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            if(player != null && player.isPlaying()){
                player.stop();
            }
           }
       });
    }
}
