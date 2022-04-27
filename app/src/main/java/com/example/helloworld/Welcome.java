package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    TextView thankYouName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        thankYouName = findViewById(R.id.thank_you_user);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            if(bundle.containsKey(Constants.USER_NAME_KEY)){
                thankYouName.setText(bundle.getString(Constants.USER_NAME_KEY));
                //thankYouName.setText(getString(thank_you_txt) + bundle.getString(Constants.USER_NAME_KEY) );
            }
        }
    }

    public void onSubmit(View view) {
    }
}
