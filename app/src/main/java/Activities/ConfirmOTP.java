package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.longtrang.vinid.R;

public class ConfirmOTP extends AppCompatActivity {
    TextView textViewPhonenumberChange;
    TextView textViewOTPSendAgain;
    TextView textViewOTPGuide;
    EditText editTextOTP;
    Button buttonNext;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_otp);
        assigningView();
        editTextOTP.requestFocus();
        getData();
    }

    public void assigningView() {
        textViewOTPGuide            = findViewById(R.id.tv_enter_otp_guide);
        textViewPhonenumberChange   = findViewById(R.id.tv_phonenumber_change);
        textViewOTPSendAgain        = findViewById(R.id.tv_OTP_send_again);
        editTextOTP                 = findViewById(R.id.edt_otp_code);
        buttonNext                  = findViewById(R.id.btn_otp_confirm);
    }
    public void getData() {
        Intent intent = getIntent();
        phoneNumber = intent.getStringExtra("phonenumber");
        textViewOTPGuide.setText(getResources().getString(R.string.enter_otp_code) + " " + phoneNumber);
    }
    public void goToPinCode(View view) {
        if (editTextOTP.length() == getResources().getInteger(R.integer.otp_code)) {
            startActivity(new Intent(ConfirmOTP.this, PinCode.class));
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.otp_code_warning), Toast.LENGTH_LONG).show();
        }
    }
    public void backToPhoneNumberRegister(View view) {
        startActivity(new Intent(ConfirmOTP.this, PhoneNumberRegister.class));
    }
}