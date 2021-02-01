package com.netcom.netsmartapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class termsConditionsActivity extends AppCompatActivity {
    Toolbar tc_toolbar;
    TextView terms_and_conditions_contains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        tc_toolbar=findViewById(R.id.tc_toolbar);
        terms_and_conditions_contains=findViewById(R.id.terms_and_conditions_contains);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            terms_and_conditions_contains.setText(Html.fromHtml(getString(R.string.terms_and_condions_descriptions), Html.FROM_HTML_MODE_COMPACT));
        } else {
            terms_and_conditions_contains.setText(Html.fromHtml(getString(R.string.terms_and_condions_descriptions)));
        }

        tc_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(termsConditionsActivity.this, WelcomeActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
            }
        });

    }
}