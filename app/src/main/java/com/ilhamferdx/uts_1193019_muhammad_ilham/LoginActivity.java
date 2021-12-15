package com.ilhamferdx.uts_1193019_muhammad_ilham;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    EditText editText_username,editText_password;
    FloatingActionButton buttonLogin;
    Button buttonRegister;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_username  = findViewById(R.id.input_username);
        editText_password = findViewById(R.id.input_password);
        buttonRegister = findViewById(R.id.btnRegister);
        buttonLogin = findViewById(R.id.btnLogin);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_USERNAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);
        String password = sharedPreferences.getString(KEY_PASSWORD,null);

        if(name != null || password != null){
            //so set data on textview
            editText_username.setText(name);
            editText_password.setText(password);
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValidate = editText_username.getText().toString();
                String passwordValidate = editText_password.getText().toString();
                if (usernameValidate.equals(name) && passwordValidate.equals(password)){
                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else if (usernameValidate.isEmpty() && passwordValidate.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill your username and password!", Toast.LENGTH_SHORT).show();
                }else if (usernameValidate.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill your username!", Toast.LENGTH_SHORT).show();
                } else if (passwordValidate.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill your password!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Username or password wrong!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}