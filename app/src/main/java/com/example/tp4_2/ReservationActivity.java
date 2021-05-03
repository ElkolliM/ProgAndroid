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

public class ReservationActivity extends AppCompatActivity {

    TextView nomResto;
    private ArrayList<String> mTables = new ArrayList<>();
    private ArrayList<String> mTimes = new ArrayList<>();
    private ImageButton homeButton;
    private ImageButton reservationsButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        nomResto = findViewById(R.id.reservationRestoNom);
        homeButton = findViewById(R.id.home);
        reservationsButton = findViewById(R.id.reservations);
        profileButton = findViewById(R.id.profile);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationActivity.this, Historique.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationActivity.this, Profil.class);
                startActivity(intent);
            }
        });

        if(getIntent().hasExtra("resto_name")){
            nomResto.setText(getIntent().getStringExtra("resto_name"));
        }
        initImageBitmaps();
    }
    private void initImageBitmaps(){

        mTables.add("Table 1");
        mTimes.add("FULL");

        mTables.add("Table 2");
        mTimes.add("SEE TIMES");

        mTables.add("Table 3");
        mTimes.add("FULL");

        mTables.add("Table 4");
        mTimes.add("SEE TIMES");

        mTables.add("Table 5");
        mTimes.add("SEE TIMES");

        mTables.add("Table 6");
        mTimes.add("FULL");

        mTables.add("Table 7");
        mTimes.add("SEE TIMES");

        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_reserveravtion);
        ReservationAdapter adapter = new ReservationAdapter(this, mTables,mTimes,nomResto.getText().toString());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
    }
}