package com.example.gallerybook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    Button signupBtn, toLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        signupBtn = findViewById(R.id.signupBtn);
        toLoginBtn = findViewById(R.id.toLoginBtn);

        // listen for click events
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to main activity screen
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
            }
        });

        toLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigate to login screen
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }
}