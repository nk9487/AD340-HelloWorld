package com.example.helloworld;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText nameField;
    private EditText emailField;
    private EditText userNameField;
    private EditText descriptionField;
    private EditText occupationField;
    private TextView ageField;
    private   int dobYear = 0;
    private  int dobMonth = 0;
    private   int dobDay = 0;
    private   int calculatedYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ageField = findViewById(R.id.birthday_field);
        nameField = findViewById(R.id.full_name_field);
        emailField = findViewById(R.id.email_field);
        userNameField = findViewById(R.id.user_name_field);
        occupationField = findViewById(R.id.occupation_field);
        descriptionField = findViewById(R.id.description_field);
        ageField = findViewById(R.id.birthday_field);

    }

    // validating
    public void onSubmit(View view){
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String username = userNameField.getText().toString();
        //String age = ""+calculatedYear;
        String occupation = occupationField.getText().toString();
        String description = descriptionField.getText().toString();
        //validate missing fields
        if (username.equals("") || name.equals("") || occupation.equals("") || description.equals("")||
                email.equals("") || dobMonth ==0 || dobDay == 0 || dobYear == 0  ){
            Toast.makeText(getApplicationContext(),getString(R.string.please_enter_a_valid_content),Toast.LENGTH_LONG).show();
            return;
        }
        //validate email
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(),getString(R.string.please_enter_a_valid_email),Toast.LENGTH_LONG).show();
            return;
        }


        if(!checkAge()){
            Toast.makeText(getApplicationContext(), getString(R.string.eighteen_error), Toast.LENGTH_LONG).show();
            return;

        }
        Intent intent = new Intent(getApplicationContext(), Welcomes.class);
        intent.putExtra(Constants.USER_NAME_KEY, username);
        intent.putExtra(Constants.USER_AGE_KEY, ""+calculatedYear);
        intent.putExtra(Constants.USER_DESCRIPTION_KEY, description);
        intent.putExtra(Constants.USER_OCCUPATION_KEY, occupation);

        startActivity(intent);
    }
    private boolean checkAge(){
        int todayDate = LocalDate.now().getYear();
        int instantDOB =   LocalDate.of(dobYear,dobMonth,dobDay).getYear();
        calculatedYear = todayDate - instantDOB;
        return calculatedYear >= 18;
    }

    public void onDobClick(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.USER_AGE_KEY, ageField.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.USER_AGE_KEY)) {
            ageField.setText(savedInstanceState.getString(Constants.USER_AGE_KEY));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        nameField.setText("");
        userNameField.setText("");
        emailField.setText("");
        ageField.setText("");
        occupationField.setText("");
        descriptionField.setText("");
        dobYear = 0;
        dobDay = 0;
        dobMonth = 0;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {

        month = month + 1;
        dobYear = year;
        dobMonth = month;
        dobDay = day;
        ageField.setText(month + getString(R.string.text_slash_symbol)+ day + getString(R.string.text_slash_symbol)+ year);
    }


    public static class DatePickerFragment extends DialogFragment  {
        @NonNull
        @Override

        public Dialog onCreateDialog(Bundle savedInstances){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(),year, month,day);
        }

    }


}