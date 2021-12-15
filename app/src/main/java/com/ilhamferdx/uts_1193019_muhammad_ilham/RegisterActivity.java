package com.ilhamferdx.uts_1193019_muhammad_ilham;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText username,email,password,alamat,telepon,jenkel,hobi;
    Button buttonRegister;

    SharedPreferences sharedPreferences;
    //create a shared preferences name and also create a key name
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_TELEPON = "telepon";
    private static final String KEY_JENKEL = "jenkel";
    private static final String KEY_HOBI = "hobi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.et_username);
        email    = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        alamat   = findViewById(R.id.et_alamat);
        telepon   = findViewById(R.id.et_telepon);
        jenkel   = findViewById(R.id.et_jenkel);
        hobi   = findViewById(R.id.et_hobi);

        buttonRegister = findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        //when open activity first check sharedpreferences data available or not
        String name = sharedPreferences.getString(KEY_USERNAME,null);

        if (name != null){
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_USERNAME,username.getText().toString());
                editor.putString(KEY_EMAIL,email.getText().toString());
                editor.putString(KEY_PASSWORD,password.getText().toString());
                editor.putString(KEY_ALAMAT,alamat.getText().toString());
                editor.putString(KEY_TELEPON,telepon.getText().toString());
                editor.putString(KEY_JENKEL,jenkel.getText().toString());
                editor.putString(KEY_HOBI,hobi.getText().toString());
                editor.apply();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

                Toast.makeText(RegisterActivity.this,"Registration Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}