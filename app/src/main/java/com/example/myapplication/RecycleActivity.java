package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity implements Ricyle.ItemClickListener {
    RecyclerView recyclerView;
    Ricyle adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView=findViewById(R.id.tview);
        List<String> data = new ArrayList<>();
        data.add("Bikes");
        data.add("Plasma Screens");
        data.add("Computer");
        data.add("Smart phones");
        data.add("Home Appliances");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapt=new Ricyle(this,data);
        adapt.setClickListener(this);
        recyclerView.setAdapter(adapt);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
