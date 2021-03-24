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

import androidx.appcompat.app.AppCompatActivity;

public class RegisterForm extends AppCompatActivity {
    TextView txtPhonenumber, txtInvitationcode,txtPolicy;
    EditText edtPhonenumber;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        AnhXa();
        Intent intent = getIntent();
    }
    public void AnhXa(){
        txtPhonenumber = findViewById(R.id.phonenumber);
        txtInvitationcode = findViewById(R.id.invitationcode);
        txtPolicy = findViewById(R.id.tvpolicy);
        edtPhonenumber = findViewById(R.id.edtphone_number);
        btnNext = findViewById(R.id.btnnext);
    }

    public void InvitationcodeClick(View view) {
        Dialog dialog = new Dialog(RegisterForm.this);
        dialog.setContentView(R.layout.dialog_invitation_code);
        dialog.show();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public void EnterPhoneNumber(View view) {

    }
}