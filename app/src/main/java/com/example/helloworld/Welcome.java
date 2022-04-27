package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    TextView welcome;
    TextView name;
    TextView occupation;
    TextView age;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        name = findViewById(R.id.id_name);
        age= findViewById(R.id.id_age);
        occupation = findViewById(R.id.id_occupation);
        description = findViewById(R.id.id_description);


        //welcome = findViewById(R.id.thank_you_user);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            if(bundle.containsKey(Constants.USER_NAME_KEY)){
                welcome.setText(bundle.getString(Constants.USER_NAME_KEY));
            }
            if(bundle.containsKey(Constants.USER_AGE_KEY)){
                welcome.setText(""+bundle.getString(Constants.USER_AGE_KEY));
            }
            if(bundle.containsKey(Constants.USER_OCCUPATION_KEY)){
                welcome.setText(bundle.getString(Constants.USER_OCCUPATION_KEY));
            }
            if(bundle.containsKey(Constants.USER_DESCRIPTION_KEY)){
                welcome.setText(bundle.getString(Constants.USER_DESCRIPTION_KEY));
            }
        }
    }

    public void onSubmit(View view) {
    }
}
