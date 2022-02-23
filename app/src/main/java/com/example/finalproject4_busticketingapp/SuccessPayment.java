package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SuccessPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_payment);
        Intent i = new Intent(SuccessPayment.this,Home.class);
        new Handler().postDelayed(() -> {
            startActivity(i);
            finish();
        },1000);
    }
}