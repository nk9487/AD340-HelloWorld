package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    TextView welcome;
    TextView name;
    TextView occupation;
    TextView age;
    TextView description;
    private Button back;
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
//            if(bundle.containsKey(Constants.USER_NAME_KEY)){
//                welcome.setText(getString(R.string.thanks_message)+bundle.getString(Constants.USER_NAME_KEY));
//            }
            if(bundle.containsKey(Constants.USER_NAME_KEY)){
                name.setText(bundle.getString(Constants.USER_NAME_KEY));
            }
            if(bundle.containsKey(Constants.USER_AGE_KEY)){
                age.setText(bundle.getString(Constants.USER_AGE_KEY));
            }
            if(bundle.containsKey(Constants.USER_OCCUPATION_KEY)){
               occupation.setText(bundle.getString(Constants.USER_OCCUPATION_KEY));
            }
            if(bundle.containsKey(Constants.USER_DESCRIPTION_KEY)){
                description.setText(bundle.getString(Constants.USER_DESCRIPTION_KEY));
            }
        }
    }
    private void onBackClick(){
        finish();
//        back = (Button)findViewById(R.id.welcome_button_back);
//        back.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v){
//                Intent intent = new Intent(Welcome.this, MainActivity.class);;
//                startActivity(intent);
//            }
//        });
    }

}
