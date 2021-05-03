package com.example.tp4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ArrayList<String> mType = new ArrayList<>();
    private ArrayList<String> mItem1 = new ArrayList<>();
    private ArrayList<String> mItem2 = new ArrayList<>();
    private ArrayList<String> mItem3 = new ArrayList<>();
    private ArrayList<String> mItem1Price = new ArrayList<>();
    private ArrayList<String> mItem2Price = new ArrayList<>();
    private ArrayList<String> mItem3Price = new ArrayList<>();
    private TextView nomResto;
    private Button booknow;
    private ImageButton homeButton;
    private ImageButton reservationsButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        homeButton = findViewById(R.id.home);
        reservationsButton = findViewById(R.id.reservations);
        profileButton = findViewById(R.id.profile);
        nomResto = findViewById(R.id.restoNameMenu);
        booknow = findViewById(R.id.bookNowButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Historique.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Profil.class);
                startActivity(intent);
            }
        });

        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ReservationActivity.class);
                intent.putExtra("resto_name", nomResto.getText());
                startActivity(intent);
            }
        });
        if(getIntent().hasExtra("resto_name")){
            nomResto.setText(getIntent().getStringExtra("resto_name"));
        }
        initImageBitmaps();
    }
    private void initImageBitmaps(){

        mType.add("Steaks");
        mItem1.add("Filet Mignon");
        mItem2.add("Bavette");
        mItem3.add("Rib eye");
        mItem1Price.add("30,00 $");
        mItem2Price.add("25,00 $");
        mItem3Price.add("45,00 $");

        mType.add("Salade");
        mItem1.add("Californienne");
        mItem2.add("César");
        mItem3.add("Maison");
        mItem1Price.add("25,00 $");
        mItem2Price.add("17,50 $");
        mItem3Price.add("17,50 $");

        mType.add("Tartare");
        mItem1.add("Saumon");
        mItem2.add("Boeuf");
        mItem3.add("Thon");
        mItem1Price.add("25,00 $");
        mItem2Price.add("25,00 $");
        mItem3Price.add("25,00 $");




        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_menu);
        MenuAdapter adapter = new MenuAdapter(this, mType,mItem1,mItem2,mItem3,mItem1Price,mItem2Price,mItem3Price);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
    }
}