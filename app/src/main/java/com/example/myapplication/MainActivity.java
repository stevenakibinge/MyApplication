package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mus =(Button)findViewById(R.id.button);
        mus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MediaActivity.class);
                startActivity(intent);
            }
        });

    }
    public void sendMessage(View view){
        EditText message=(EditText)findViewById(R.id.message);
        Intent intent=new Intent(this,DisplayMessageActivity.class);
        intent.putExtra("MESSAGE",message.getText().toString());
        startActivity(intent);
        message.setText("");
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()) {
        case R.id.setting:
            startActivity(new Intent(this, InfoActivity.class));
            return true;
        case R.id.network:

            startActivity(new Intent(this, UpdateActivity.class));
            return true;
        default:
            /*return super.onOptionsItemSelected(item);*/
            return true;

    }
    }
}
