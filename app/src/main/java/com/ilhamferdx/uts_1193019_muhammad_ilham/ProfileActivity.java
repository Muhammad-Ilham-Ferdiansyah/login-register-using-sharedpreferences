package com.ilhamferdx.uts_1193019_muhammad_ilham;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView textView_email,textView_username;
    Button button_showmore;
    Button button_logout;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView_email = findViewById(R.id.email);
        textView_username = findViewById(R.id.username);
        button_showmore = findViewById(R.id.showmore);
        button_logout = findViewById(R.id.logout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_USERNAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);

        if(name != null || email != null){
            //so set data on textview
            textView_email.setText(email);
            textView_username.setText(name);
        }

        button_showmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(ProfileActivity.this,"Log out successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}