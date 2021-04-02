package com.longtrang.vinid;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneNumberRegister extends AppCompatActivity {
    TextView textViewPhoneNumber, textViewInvitationCode,textViewPolicy;
    EditText editTextPhoneNumber;
    Button buttonNext;
    String phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_number_register);
        mappingView();
        editTextPhoneNumber.requestFocus();
        Intent intent = getIntent();
    }

    public void mappingView(){
        textViewPhoneNumber     = findViewById(R.id.tv_enter_phonenumber_register);
        textViewInvitationCode  = findViewById(R.id.tv_invitation_code);
        textViewPolicy          = findViewById(R.id.tv_policy);
        editTextPhoneNumber     = findViewById(R.id.edt_phonenumber_register);
        buttonNext              = findViewById(R.id.btn_next);
    }

    public void clickOnInvitationCode(View view) {
        Dialog dialog = new Dialog(PhoneNumberRegister.this);
        dialog.setContentView(R.layout.dialog_invitation_code);
        dialog.show();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public void goToConfirmOTP(View view) {
        phoneNumber = editTextPhoneNumber.getText().toString().trim();
        if(phoneNumber.isEmpty() || phoneNumber.length() != 10){
            Toast.makeText(this, getResources().getString(R.string.phone_number_warning), Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(PhoneNumberRegister.this, ConfirmOTP.class);
            intent.putExtra("phone number",phoneNumber);
            startActivity(intent);
        }

    }
}