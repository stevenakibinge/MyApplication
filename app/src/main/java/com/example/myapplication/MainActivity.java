package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myapplication.R.id.backg;

public class MainActivity extends AppCompatActivity {
    Button btAlarm; // for alarm
    EditText eAlarm;// for alarm
    // creating and instantiate a  Broadcast Reciever to recieve the message
  BroadcastReceiver obj = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
          int x =intent.getIntExtra("level", 1);
          //  Battery should be in progress bar that we created earlier so we call its id
          ProgressBar progressBar = findViewById(R.id.pro);
          // pass the int for the value of battery level
          progressBar.setProgress(x);
          // the message will be displayed in the text view we create earlier
          TextView textView= findViewById(R.id.t4);
          textView.setText("Batttery Level"+Integer.parseInt(String.valueOf(x))+"%");
      }
  };
         class receiver extends BroadcastReceiver{
              
             @Override
             public void onReceive(Context context, Intent intent) {

             }
         }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating tool bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btAlarm = (Button)findViewById(R.id.btnalarm);
        eAlarm= (EditText)findViewById(R.id.editAlarm);

        btAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(eAlarm.getText().toString());
                Intent geo = new Intent(getApplicationContext(),MyReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),0,geo,0);
                AlarmManager am= (AlarmManager)getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time*3000,pi);
                // making a toast
                Toast.makeText(getApplicationContext(),"Alarm is set in"+time+"secs",Toast.LENGTH_SHORT).show();

           

            }
        });

        // registering a reciever for the battery using intent
        registerReceiver(obj,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        Button mus = (Button) findViewById(R.id.button);

        mus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(intent);
            }
        });

    }

    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }
// creating the menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                startActivity(new Intent(this, InfoActivity.class));
                return true;
            case R.id.network:

                startActivity(new Intent(this, UpdateActivity.class));
                return true;
            case R.id.list:
                startActivity(new Intent(this, ProductActivity.class));
                return true;
            case R.id.lecy:
                startActivity(new Intent(this, RecycleActivity.class));
                return true;
            case backg:
                startActivity(new Intent(this,Services.class));
                return true;
            case R.id.foreground:
                startActivity(new Intent(this,Foreground.class));
                return true;
            case R.id.store:
                startActivity(new Intent(this,Storage.class));
                return true;
            case R.id.ext:
                startActivity(new Intent(this,ExternalStorage.class));
                return true;
            case R.id.content:
                startActivity(new Intent(this,ContentProActivity.class));
                return true;


            case R.id.c:
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData( Uri.parse("tel:0780784682"));
                startActivity(in);


            return true;
        case R.id.m:
            Intent j= new Intent(Intent.ACTION_SEND);
            j.setData(Uri.parse("mailto"));
            String to []={"edithnapiera@gmail.com","ainyofeunice@gmail.com","onekraphael8@gmail.com"};
            j.putExtra(Intent.EXTRA_EMAIL,to);
            j.putExtra(Intent.EXTRA_SUBJECT,"Welcome to our group mail");
            j.putExtra(Intent.EXTRA_TEXT,"this is first of its kind");
            j.setType("message/rfc822");
            startActivity(j);
            return  true;
        default:
            /*return super.onOptionsItemSelected(item);*/
            return true;

    }
    }
}
