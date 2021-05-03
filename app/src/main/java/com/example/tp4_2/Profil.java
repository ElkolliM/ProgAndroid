package com.example.tp4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class Profil extends AppCompatActivity {

    private TextView txtViewDistance;
    private TextView txtViewBudget;
    private SeekBar seekBarDistance;
    private SeekBar seekBarBudget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Account account = ListAccounts.getInstance().getAccountInBuffer();

        TextView name = findViewById(R.id.txtViewFullName);
        TextView email = findViewById(R.id.txtViewEmail);
        TextView password = findViewById(R.id.txtViewPassword);
        TextView nas = findViewById(R.id.txtViewNAS);
        TextView phoneNumber = findViewById(R.id.txtViewPhoneNumber);

        name.setText(account.getFullName());
       email.setText(account.getEmail());
        nas.setText(account.getNas());
       password.setText(account.getPassword());
       phoneNumber.setText(account.getPhoneNum());

        txtViewBudget = findViewById(R.id.textViewBudget);
        txtViewDistance =findViewById(R.id.textViewDistance);
        seekBarBudget = findViewById(R.id.seekBarBudget);
        seekBarBudget.setProgress(10);
        seekBarDistance=findViewById(R.id.seekBarDistance);
        seekBarDistance.setProgress(2);
        seekBarBudget.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtViewBudget.setText("Budget : "+ progress +"\t $");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtViewDistance.setText("Distance : "+ progress +" miles");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
            case "imgBtnHome": {

                Intent myIntent = new Intent(this, HomePage.class);
                startActivityForResult(myIntent, 1);
            }
            break;

        }
    }

}
