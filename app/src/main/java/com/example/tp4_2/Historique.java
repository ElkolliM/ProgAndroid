package com.example.tp4_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Historique extends AppCompatActivity {


    private ImageButton homeButton;
    private ImageButton reservationsButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        homeButton = findViewById(R.id.home);
        reservationsButton = findViewById(R.id.reservations);
        profileButton = findViewById(R.id.profile);
        TextView txtview = findViewById(R.id.txtViewNo);
        Account account = ListAccounts.getInstance().getAccountInBuffer();
        if(account.getReservations().size() != 0) {
            txtview.setText("Reservations:");
        }
        else {
            AlertDialog alertDialog = new AlertDialog.Builder(Historique.this).create();
            alertDialog.setTitle("Empty");
            alertDialog.setMessage("You haven't made any reservations yet.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        initImageBitmaps();
        txtview.setText("No reservations");
    }
    private void initImageBitmaps(){




        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_schedule);
        Account account = ListAccounts.getInstance().getAccountInBuffer();
        HistoriqueAdapter adapter = new HistoriqueAdapter(this, account);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);

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
