package com.ilhamferdx.uts_1193019_muhammad_ilham;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView textView_email,textView_username,textView_alamat,textView_telepon,textView_jenkel,textView_hobi;
    Button button_back;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_TELEPON = "telepon";
    private static final String KEY_JENKEL = "jenkel";
    private static final String KEY_HOBI = "hobi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView_email = findViewById(R.id.email);
        textView_username = findViewById(R.id.username);
        textView_alamat = findViewById(R.id.alamat);
        textView_telepon = findViewById(R.id.telepon);
        textView_jenkel = findViewById(R.id.jenkel);
        textView_hobi = findViewById(R.id.hobi);
        button_back = findViewById(R.id.back);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_USERNAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        String alamat = sharedPreferences.getString(KEY_ALAMAT,null);
        String telepon = sharedPreferences.getString(KEY_TELEPON,null);
        String jenkel = sharedPreferences.getString(KEY_JENKEL,null);
        String hobi = sharedPreferences.getString(KEY_HOBI,null);

        if(name != null || email != null || alamat != null || telepon != null){
            //so set data on textview
            textView_email.setText(email);
            textView_username.setText(name);
            textView_alamat.setText(alamat);
            textView_telepon.setText(telepon);
            textView_jenkel.setText(jenkel);
            textView_hobi.setText(hobi);
        }

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }

}