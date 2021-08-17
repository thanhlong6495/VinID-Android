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
import com.longtrang.vinid.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.longtrang.vinid.R.*;

public class ConfirmOTP extends AppCompatActivity {
    @BindView(R.id.tv_OTP_Send_Again) TextView textViewOTPSendAgain;
    @BindView(id.tv_OTP_Guide) TextView textViewOTPGuide;
    @BindView(R.id.edt_OTP_Code) EditText editTextOTP;
    @BindView(R.id.tv_CountDown_Timer) TextView textViewCountDownTimer;
    String phoneNumber;
    private CountDownTimer countDownTimer;
    private int remainingTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.confirm_otp);
        ButterKnife.bind(this);
        editTextOTP.requestFocus();
        getPhoneNumber();
        setCountDownTimer();
        textViewOTPSendAgain.setOnClickListener((View v) -> {
            countDownTimer.cancel();
            setCountDownTimer();
        });
    }
    //get the registered phone number
    public void getPhoneNumber() {
        Intent intent = getIntent();
        phoneNumber = intent.getStringExtra("phonenumber");
        textViewOTPGuide.setText(new StringBuilder().append(getResources().getString(string.enter_otp_code)).append(" ").append(phoneNumber).toString());
    }
    //click on next button
    @OnClick(id.btn_Next_OTP)
    protected void goToPinCode(View view) {
        if (editTextOTP.length() == getResources().getInteger(integer.OTP_CODE_DIGIT)) {
            countDownTimer.cancel();
            startActivity(new Intent(ConfirmOTP.this, PinCode.class));
        }
        else {
            Toast.makeText(this, getResources().getString(string.otp_code_warning), Toast.LENGTH_LONG).show();
        }
    }
    //click on back arrow
    @OnClick(id.btn_Back_OTP)
     protected void backToPhoneNumberRegister() {
        startActivity(new Intent(ConfirmOTP.this, PhoneNumberRegister.class));
    }
    private void setCountDownTimer() {
        countDownTimer = new CountDownTimer(getResources().getInteger(integer.OTP_COUNTDOWNTIMER),
                getResources().getInteger(integer.CONVERT_TIME)) {
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