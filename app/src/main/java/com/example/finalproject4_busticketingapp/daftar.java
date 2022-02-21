package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class daftar extends AppCompatActivity {
    private TextView masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        masuk = findViewById(R.id.textView_daftar_masuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in_masuk = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in_masuk);
            }
        });
    }

}