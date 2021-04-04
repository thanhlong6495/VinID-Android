package com.longtrang.vinid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInformation extends AppCompatActivity {
    FragmentManager fragmentManager = getFragmentManager();
    EditText editTextFullName, editTextDateOfBirth, editTextEmail;
    Button buttonNext, buttonDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        mappingView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editTextDateOfBirth.setShowSoftInputOnFocus(false);
        }
    }
    public void showDatePickerDialog(View view) {
        buttonNext.setVisibility(View.INVISIBLE);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DatePicker datePicker = new DatePicker();
        fragmentTransaction.add(R.id.framelayout_fragment_date_picker, datePicker,"FragmentDatePicker");
        fragmentTransaction.addToBackStack("FragmentDatePicker");
        fragmentTransaction.commit();
    }
    public void mappingView() {
        editTextFullName    = findViewById(R.id.edt_full_name);
        editTextDateOfBirth = findViewById(R.id.edt_date_of_birth);
        editTextEmail       = findViewById(R.id.edt_email);
        buttonNext          = findViewById(R.id.btn_next_personal_information);
        buttonDone          = findViewById(R.id.btn_done);
    }
}