package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class InfoActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textView=findViewById(R.id.acces);
        button=(Button)findViewById(R.id.read);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prog="";
                try{
                    InputStream inputStream= getAssets().open("calc.c");
                    int c=inputStream.available();
                    byte[] space = new byte[c];
                    inputStream.read(space);
                    inputStream.close();
                    prog=new String(space);

                }catch (IOException st){
                    st.printStackTrace();
                }
                textView.setText((CharSequence)prog);
            }
        });





    }
}
