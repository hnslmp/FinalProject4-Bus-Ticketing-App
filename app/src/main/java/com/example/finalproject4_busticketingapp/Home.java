package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Home extends AppCompatActivity {
    Button btnSearch;
    EditText etAsal, etTujuan, etAriv, etDep;
    Calendar calendar  = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSearch = findViewById(R.id.btnSearch);
        etAsal = findViewById(R.id.etAsal);
        etTujuan = findViewById(R.id.etTujuan);

        etDep = findViewById(R.id.et_dep);
        etAriv = findViewById(R.id.et_ariv);

        DatePickerDialog.OnDateSetListener Date= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,day);

                SimpleDateFormat sdf = new SimpleDateFormat("EEE,dd MMM,yyyy");
                etDep.setText(sdf.format(calendar.getTime()));
                etAriv.setText(sdf.format(calendar.getTime()));
            }
        };
        etDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Home.this,Date,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etAriv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Home.this,Date,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

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