package RegisterActivities;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static com.longtrang.vinid.R.*;

public class ConfirmOTP extends AppCompatActivity {
    private TextView textViewPhonenumberChange;
    private TextView textViewOTPSendAgain;
    private TextView textViewOTPGuide;
    private TextView textViewCountDownTimer;
    private EditText editTextOTP;
    String phoneNumber;
    private CountDownTimer countDownTimer;
    private int remainingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.confirm_otp);
        assigningView();
        editTextOTP.requestFocus();
        getData();
        setCountDownTimer();
        textViewOTPSendAgain.setOnClickListener(v -> {
            countDownTimer.cancel();
            setCountDownTimer();
        });
    }
    public void assigningView() {
        textViewCountDownTimer      = findViewById(id.tv_countdown_timer);
        textViewOTPGuide            = findViewById(id.tv_enter_otp_guide);
        textViewPhonenumberChange   = findViewById(id.tv_phonenumber_change);
        textViewOTPSendAgain        = findViewById(id.tv_OTP_send_again);
        editTextOTP                 = findViewById(id.edt_otp_code);
    }
    public void getData() {
        Intent intent = getIntent();
        phoneNumber = intent.getStringExtra("phonenumber");
        textViewOTPGuide.setText(new StringBuilder().append(getResources().getString(string.enter_otp_code)).append(" ").append(phoneNumber).toString());
    }
    public void goToPinCode(View view) {
        if (editTextOTP.length() == getResources().getInteger(integer.otp_code)) {
            startActivity(new Intent(ConfirmOTP.this, PinCode.class));
        }
        else {
            Toast.makeText(this, getResources().getString(string.otp_code_warning), Toast.LENGTH_LONG).show();
        }
    }
    public void backToPhoneNumberRegister(View view) {
        startActivity(new Intent(ConfirmOTP.this, PhoneNumberRegister.class));
    }
    private void setCountDownTimer() {
        countDownTimer = new CountDownTimer(getResources().getInteger(integer.otp_countdowntimer), getResources().getInteger(integer.convert_time)) {
            @Override
            public void onTick(long millisUntilFinished) {
                editTextOTP.setFocusableInTouchMode(true);
                remainingTime = (int) millisUntilFinished;
                updateTime();
            }
            @Override
            public void onFinish() {
                editTextOTP.setFocusable(false);
                countDownTimer.cancel();
                Toast.makeText(ConfirmOTP.this, getResources().getString(string.otp_time_warning), Toast.LENGTH_LONG).show();
            }
        };
        countDownTimer.start();
    }
    private void updateTime() {
        int minutes = (remainingTime / 1000) / 60;
        int seconds = (remainingTime /1000) % 60;
        @SuppressLint("DefaultLocale") String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        textViewCountDownTimer.setText(timeFormatted);
    }
}