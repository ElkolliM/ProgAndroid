package com.example.tp4_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText nas;
    private EditText fullname;
    private EditText phoneNumber;
    private ListAccounts accounts;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

       email = findViewById(R.id.editTextEmail);
       password = findViewById(R.id.editTextPassword);
       nas = findViewById(R.id.editTxtNAS);
       fullname = findViewById(R.id.editTxtFullName);
       phoneNumber = findViewById(R.id.editTextPhoneNumber);
       checkBox = findViewById(R.id.checkBox);
        accounts = ListAccounts.getInstance();
    }



    public void onClick(View v){

        if(!checkBox.isChecked()) {
            checkBox.setFocusable(true);
            AlertDialog alertDialog = new AlertDialog.Builder(CreateAccount.this).create();
            alertDialog.setTitle("Create an account");
            alertDialog.setMessage("You need to accept the terms and conditions first because creating an account.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }else {

            Account acc;
            if ((acc = accounts.createAccount(
                    fullname.getText().toString(),
                    phoneNumber.getText().toString(),
                    email.getText().toString(),
                    password.getText().toString(),
                    nas.getText().toString())) != null) {
                accounts.setAccountInBuffer(acc);

                Toast.makeText(getApplicationContext(), "account created", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(this, LoginActivity.class);
                startActivityForResult(myIntent, 1);

            } else {

                // affiche un message mauvais regEx
                AlertDialog alertDialog = new AlertDialog.Builder(CreateAccount.this).create();
                alertDialog.setTitle("Create an account");
                alertDialog.setMessage("One of the values you entered is written incorrectly. please try again. \n note : \n - NAS must 9 numbers \n - phone number is 10 numbers \n - email is of shape xxxx@xxx.xxx");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        }
    }




}