package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button signUp;
    Button signIn;
    Button guest;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // sign up Button
        signUp = (Button)findViewById(R.id.button_sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });

        // sign in Button
        signIn = (Button)findViewById(R.id.button_sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });

        // guest
        guest = (Button)findViewById(R.id.button_guest);
        guest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });

    }
}