package com.example.helloworld;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText nameField;
    private EditText emailField;
    private EditText userField;
    final Calendar myCalendar= Calendar.getInstance();
    private EditText datePicked;
    private Button submit;
    private Button back;
    private TextView thankYouName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.name);
        emailField = findViewById(R.id.email);
        userField = findViewById(R.id.user_name);
        datePicker();
        //goBack();
    }

    // validating
    public void onSubmit(View view){
        String name = nameField.toString();
        String email = emailField.toString();
        String username = userField.toString();
        //validate missing fields
        if (name.equals("") || email.equals("") || username.equals("")){
            Toast.makeText(getApplicationContext(),getString(R.string.please_enter_a_valid_email),Toast.LENGTH_LONG).show();
            return;
        }
        //validate email
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(),getString(R.string.please_enter_a_valid_email),Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), Welcome.class);
        intent.putExtra(Constants.USER_NAME_KEY, username);
        startActivity(intent);
    }
    private void datePicker(){
        //Adding date picker
        datePicked = (EditText)findViewById(R.id.birthday);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker v, int year, int month, int day){
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DATE,day);
                updateLabel();
            }
        };
        datePicked.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this,date,
                        myCalendar.get(Calendar.DAY_OF_YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        datePicked.setText(dateFormat.format(myCalendar.getTime()));
    }
    private void goBack(){
        back = (Button)findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity.class);;
                startActivity(intent);
            }
        });
    }
    public String getName(){
        return userField.toString();
    }
}