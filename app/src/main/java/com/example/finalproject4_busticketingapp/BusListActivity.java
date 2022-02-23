package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalproject4_busticketingapp.list.Trip;
import com.example.finalproject4_busticketingapp.utils.TripAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BusListActivity extends AppCompatActivity {
    ListView listTrip;
    TripAdapter tripAdapter;
    public static ArrayList<Trip> tripArrayList = new ArrayList<>();
    Trip trip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        listTrip = findViewById(R.id.listTrip);
        tripAdapter = new TripAdapter(this, tripArrayList);
        listTrip.setAdapter(tripAdapter);

        Intent intent = getIntent();
        String tMedan = intent.getStringExtra("tMedan");
        retrieveData();

        listTrip.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(new Intent(getApplicationContext(), PesanTiketActivity.class).putExtra("position", position));
            }
        });
    }

    private void retrieveData() {
        StringRequest request = new StringRequest(Request.Method.POST, "https://vacillating-feedbac.000webhostapp.com/travel_app/bus/readjakarta.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tripArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            Log.e("anyText", response);
                            JSONArray jsonArray = jsonObject.getJSONArray("trip");
                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String idTrip = object.getString("id_trip");
                                    String tujuan = object.getString("tujuan");
                                    String asal = object.getString("asal");
                                    String nama_bus = object.getString("nama_bus");
                                    String harga = object.getString("harga");

                                    trip = new Trip(idTrip, tujuan, asal, harga, nama_bus);
                                    tripArrayList.add(trip);
                                    tripAdapter.notifyDataSetChanged();

                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BusListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}