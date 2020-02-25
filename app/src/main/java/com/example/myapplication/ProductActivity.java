package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        setTitle("Product List ");
        ListView myList =findViewById(R.id.list);
        List<String> data = new ArrayList<>();
        data.add("Bikes");
        data.add("Plasma Screens");
        data.add("Computer");
        data.add("Smart phones");
        data.add("Home Appliances");
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ProductActivity.this, android.R.layout.simple_list_item_1,data);
        myList.setAdapter(myAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = myAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
