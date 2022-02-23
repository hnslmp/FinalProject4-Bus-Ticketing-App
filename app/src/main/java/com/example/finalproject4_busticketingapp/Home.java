package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    Button btnSearch;
    EditText etAsal, etTujuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSearch = findViewById(R.id.btnSearch);
        etAsal = findViewById(R.id.etAsal);
        etTujuan = findViewById(R.id.etTujuan);

        String tujuan = etTujuan.getText().toString();
        String asal = etAsal.getText().toString();
        String asalM = "tMedan";

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent tMedan = new Intent(Home.this, BusListActivity.class).putExtra("tMedan", asalM);
                    startActivity(tMedan);



            }
        });

        
    }
}