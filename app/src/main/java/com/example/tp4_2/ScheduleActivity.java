package com.example.tp4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {


    private ArrayList<String> mHours = new ArrayList<>();
    private ArrayList<String> mBook = new ArrayList<>();
    private TextView mRestoName;
    private TextView mTable;
    private ImageButton homeButton;
    private ImageButton reservationsButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        mRestoName = findViewById(R.id.scheduleRestoNom);
        mTable = findViewById(R.id.scheduleTable);
        homeButton = findViewById(R.id.home);
        reservationsButton = findViewById(R.id.reservations);
        profileButton = findViewById(R.id.profile);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, Historique.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, Profil.class);
                startActivity(intent);
            }
        });

        if(getIntent().hasExtra("resto_name")){
            mRestoName.setText(getIntent().getStringExtra("resto_name"));
        }
        if(getIntent().hasExtra("table")){
            mTable.setText(getIntent().getStringExtra("table"));
        }
        initImageBitmaps();
    }
    private void initImageBitmaps(){


        mHours.add("11:00");
        mBook.add("TAKEN");


        mHours.add("12:00");
        mBook.add("BOOK");


        mHours.add("13:00");
        mBook.add("BOOK");


        mHours.add("14:00");
        mBook.add("BOOK");

        mHours.add("15:00");
        mBook.add("TAKEN");


        mHours.add("16:00");
        mBook.add("BOOK");


        mHours.add("17:00");
        mBook.add("BOOK");


        mHours.add("18:00");
        mBook.add("BOOK");

        mHours.add("19:00");
        mBook.add("TAKEN");

        mHours.add("20:00");
        mBook.add("TAKEN");

        mHours.add("21:00");
        mBook.add("BOOK");

        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_schedule);
        ScheduleAdapter adapter = new ScheduleAdapter(this, mHours,mBook,mTable.getText().toString(),mRestoName.getText().toString());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
    }
}