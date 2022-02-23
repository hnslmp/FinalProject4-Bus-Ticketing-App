package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class daftar extends AppCompatActivity {
    private TextView masuk;

    private EditText daftar_nama,daftar_email,daftar_password,daftar_nomortlp;
    private Button bt_daftar;
    private String nama,email,password,nomortlp;
    private String url = "https://vacillating-feedbac.000webhostapp.com/travel_app/user/register.php";

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

        daftar_nama = findViewById(R.id.editText_daftar_nama);
        daftar_email = findViewById(R.id.editText_daftar_imel);
        daftar_password = findViewById(R.id.editText_daftar_password);
        daftar_nomortlp = findViewById(R.id.editText_daftar_telepon);

        bt_daftar = findViewById(R.id.button_daftar);
        bt_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        daftar_nama.addTextChangedListener(signupTextWatcher);
        daftar_email.addTextChangedListener(signupTextWatcher);
        daftar_password.addTextChangedListener(signupTextWatcher);
        daftar_nomortlp.addTextChangedListener(signupTextWatcher);

    }

    private TextWatcher signupTextWatcher = new TextWatcher(){
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String signupusernamestr = daftar_nama.getText().toString().trim();
            String signupfullnamestr = daftar_email.getText().toString().trim();
            String signupnumberstr = daftar_password.getText().toString().trim();
            String signuppasswordstr = daftar_nomortlp.getText().toString().trim();

            bt_daftar.setEnabled(!signupusernamestr.isEmpty() && (!signupfullnamestr.isEmpty() && (!signupnumberstr.isEmpty() && !signuppasswordstr.isEmpty())));

        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void signup() {
        nama = daftar_nama.getText().toString().trim();
        email = daftar_email.getText().toString().trim();
        password = daftar_password.getText().toString().trim();
        nomortlp = daftar_nomortlp.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(getApplicationContext(), "Successfully registered.", Toast.LENGTH_SHORT).show();
                    Intent signup = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(signup);
                } else if (response.equals("failure")) {
                    Toast.makeText(getApplicationContext(), "Something Went Wrong.", Toast.LENGTH_SHORT).show();                  }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("name", nama);
                data.put("email", email);
                data.put("password", password);
                data.put("nomortlp", nomortlp);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}