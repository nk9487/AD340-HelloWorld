package com.example.helloworld;

import static com.example.helloworld.R.string.thanks_text;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcomes extends AppCompatActivity {

    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomes);

        welcomeText = findViewById(R.id.welcomeText);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            if (bundle.containsKey(Constants.USER_NAME_KEY)) {
                welcomeText.setText(getString(thanks_text, bundle.getString(Constants.USER_NAME_KEY)));
            }
        }
    }

    public void onBackClick(View view) {
        finish();
    }
}