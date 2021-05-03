package com.example.tp4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();
    private ArrayList<String> mNotes = new ArrayList<>();
    private ArrayList<String> mStyles = new ArrayList<>();
    private ImageButton homeButton;
    private ImageButton reservationsButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        homeButton = findViewById(R.id.home);
        reservationsButton = findViewById(R.id.reservations);
        profileButton = findViewById(R.id.profile);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, Historique.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, Profil.class);
                startActivity(intent);
            }
        });
        initImageBitmaps();
    }
    private void initImageBitmaps(){

        mNames.add("Steakman's");
        mPrices.add("$$$$");
        mNotes.add("4/5");
        mStyles.add("SteakHouse");

        mNames.add("Houston");
        mPrices.add("$$$$");
        mNotes.add("4/5");
        mStyles.add("SteakHouse");

        mNames.add("Tomahawk");
        mPrices.add("$$$");
        mNotes.add("4.5/5");
        mStyles.add("SteakHouse apporter votre vin");

        mNames.add("La carcasse");
        mPrices.add("$$");
        mNotes.add("3.5/5");
        mStyles.add("SteakHouse");


        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_resto);
        RestoAdapter adapter = new RestoAdapter(this, mNames,mNotes,mPrices,mStyles);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
    }
}