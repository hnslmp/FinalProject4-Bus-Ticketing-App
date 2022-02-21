package com.example.finalproject4_busticketingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_username,et_password;
    Button bt_login;
    TextView tv_daftar;
    private String username,password;
    private final String url = "https://vacillating-feedbac.000webhostapp.com/travel_app/user/login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.editText_login_username);
        et_password = findViewById(R.id.editText_login_password);

        bt_login = findViewById(R.id.button_masuk);
        bt_login.setOnClickListener(this);

        tv_daftar = findViewById(R.id.textView_login_daftar);
        tv_daftar.setOnClickListener(this);

        et_username.addTextChangedListener(loginTextWatcher);
        et_password.addTextChangedListener(loginTextWatcher);
    }

    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = et_username.getText().toString().trim();
            String passwordInput = et_password.getText().toString().trim();

            bt_login.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_login_daftar:
                Intent in_daftar = new Intent(getApplicationContext(),daftar.class);
                startActivity(in_daftar);
                break;

            case R.id.button_masuk:
                login();
                break;
        }
    }

    public void login() {
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("res", response);
                if (response.equals("success")) {
                    Intent intent = new Intent(MainActivity.this, Home.class); //ganti ke activity home nanti disini
                    startActivity(intent);
                    finish();
                } else if (response.equals("failure")) {
                    Toast.makeText(MainActivity.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("email", username);
                data.put("password", password);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

}