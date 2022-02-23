package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PesanTiketActivity extends AppCompatActivity {

    TextView tv_asal, tv_tujuan, tv_harga,tv_id;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_tiket);
        tv_asal = findViewById(R.id.tv_asal);
        tv_harga = findViewById(R.id.tv_harga);
        tv_tujuan = findViewById(R.id.tv_tujuan);
        tv_id = findViewById(R.id.tv_id);
        btnBooking = findViewById(R.id.btnBooking);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("position");
        tv_tujuan.setText(BusListActivity.tripArrayList.get(position).getTujuan());
        tv_harga.setText(BusListActivity.tripArrayList.get(position).getHarga());
        tv_asal.setText(BusListActivity.tripArrayList.get(position).getAsal());
        tv_id.setText(BusListActivity.tripArrayList.get(position).getIdTrip());

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent success = new Intent(PesanTiketActivity.this, SuccessPayment.class);
                startActivity(success);
                finish();
            }
        });





    }
}