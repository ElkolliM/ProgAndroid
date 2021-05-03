package com.example.tp4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }


    public void onClick(View v) {


        switch (v.getTag().toString()) {
            case "imgBtnSearch" : {
                Intent myIntent = new Intent(this, SearchActivity.class);
                startActivityForResult(myIntent, 1);

            }break;
            case "imgBtnReservations" : {

                Intent myIntent = new Intent(this, Historique.class);
                startActivityForResult(myIntent, 1);
            }break;
            case "imgBtnProfil": {
                Intent myIntent = new Intent(this, Profil.class);
                startActivityForResult(myIntent, 1);

            }
            break;
            case "tagSeeResto": {

                Intent myIntent = new Intent(this, SearchActivity.class);
                startActivityForResult(myIntent, 1);
            }
            break;

        }

    }

}