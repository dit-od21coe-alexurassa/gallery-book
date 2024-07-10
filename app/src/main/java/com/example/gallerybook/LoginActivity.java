package com.example.gallerybook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn, toSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);
        toSignupBtn = findViewById(R.id.toSignupBtn);

        // listen for click events
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to main activity screen
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        toSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to signup screen
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

    }
}