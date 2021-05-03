package com.example.tp4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAccounts accounts = ListAccounts.getInstance();
        Account acc = accounts.getAccount("test@test.com","12345");
        accounts.setAccountInBuffer(acc);
        Toast.makeText(getApplicationContext(), acc.getEmail(), Toast.LENGTH_SHORT).show();
    }
}