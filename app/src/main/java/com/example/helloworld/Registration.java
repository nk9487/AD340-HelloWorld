package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    private EditText nameField;
    private EditText emailAddress;
    private EditText userName;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //back button
        back = (Button)findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //assign input from the user
        nameField = findViewById(R.id.name);
        emailAddress = findViewById(R.id.email);
        userName = findViewById(R.id.user_name);
    }

    // validating
    public void onSubmit(View view){
    }
    public void onBack(View view){
       // view = findViewById(R.id.registration);
        // sign up Button

    }

}