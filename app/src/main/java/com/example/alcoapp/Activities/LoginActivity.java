package com.example.alcoapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alcoapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewsInitialize();
    }

    private void viewsInitialize() {
        EditText loginLogin = findViewById(R.id.LLogin);
        EditText loginPassword = findViewById(R.id.LPassword);
        EditText registerLogin = findViewById(R.id.RLogin);
        EditText registerPassword = findViewById(R.id.RPassword);
        EditText registerRepeatPassword = findViewById(R.id.RRepeatPassword);
        Button loginButton = findViewById(R.id.LButton);
        Button registerButton = findViewById(R.id.RButton);
        setOnClickListeners(loginButton,registerButton);

    }

    private void setOnClickListeners(Button loginButton, Button registerButton) {
        final Intent intent = new Intent(this,MainActivity.class);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Login butt works", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Register Butt Works", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });
    }
}
