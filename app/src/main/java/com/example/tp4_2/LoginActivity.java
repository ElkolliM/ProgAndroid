package com.example.tp4_2;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button button;
    TextView txtOublieMdp;
    AlertDialog.Builder builder;
    Intent myIntent;
    ListAccounts accounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accounts = ListAccounts.getInstance();

        Account acc;
        if((acc = accounts.createAccount("test","1111111111","test@mail.com","12345","111111111")) != null){
            acc.addReservation(new Reservations("steak","10 p.m", "table 1"));
            System.out.println("Account test created: " +  acc.getFullName());
        }

//        myIntent = new Intent(this, Historique.class);
//        startActivityForResult(myIntent,1);

    }

    public void onClick(View v){

            System.out.println("" +v.getTag());

            switch(v.getTag().toString()) {
                case "tagLogIn" : {
                    EditText email = findViewById(R.id.editTxtFullName);
                    EditText password = findViewById(R.id.editTxtNAS);
                    Account acc = accounts.getAccount(email.getText().toString(), password.getText().toString());

                    if(acc != null){
                        Intent myIntent = new Intent(this, HomePage.class);
                        startActivityForResult(myIntent,1);
                    }
                    else{
                        // affiche un message si exist passe
                        AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                        alertDialog.setTitle("Access");
                        alertDialog.setMessage("wrong email or password. Please try again or create an account.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }

                }
                break;
                case "tagCreateAccount" : {
                      myIntent = new Intent(this, CreateAccount.class);
                      startActivityForResult(myIntent,1);
                }
            }
    }
}