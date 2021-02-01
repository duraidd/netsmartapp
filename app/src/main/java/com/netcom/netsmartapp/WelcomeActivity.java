package com.netcom.netsmartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    Button register;
    Button login;
    TextView welcome_termsconditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);
        welcome_termsconditions=findViewById(R.id.welcome_termsconditions);

        register = findViewById(R.id.reg_btn);
        login = findViewById(R.id.log_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
        welcome_termsconditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(WelcomeActivity.this, termsConditionsActivity.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });
    }
}