package RegisterActivities;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.longtrang.vinid.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneNumberRegister extends AppCompatActivity {
    @BindView(R.id.tv_invitation_code) TextView textViewInvitationCode;
    @BindView(R.id.edt_phonenumber_register) EditText editTextPhoneNumber;
    @BindView(R.id.btn_Next_PhoneNumber) Button buttonNext;
    String phoneNumber;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_number_register);
        ButterKnife.bind(this);
        editTextPhoneNumber.requestFocus();
    }
    @OnClick(R.id.tv_invitation_code)
     void clickOnInvitationCode() {
        Dialog dialog = new Dialog(PhoneNumberRegister.this);
        dialog.setContentView(R.layout.dialog_invitation_code);
        dialog.show();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
    @OnClick(R.id.btn_Next_PhoneNumber)
    protected void goToConfirmOTP() {
        if (editTextPhoneNumber.length() < getResources().getInteger(R.integer.PHONE_NUMBER_DIGIT)) {
            Toast.makeText(this, getResources().getString(R.string.phone_number_warning), Toast.LENGTH_LONG).show();
            }
        else {
            phoneNumber = editTextPhoneNumber.getText().toString().trim();
            intent = new Intent(PhoneNumberRegister.this, ConfirmOTP.class);
            intent.putExtra("phonenumber", phoneNumber);
            startActivity(intent);
            SharedPreferences sharedPreferences = getSharedPreferences("userInformation",
                        MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("phonenumber", phoneNumber);
            editor.apply();
            }
        }
    }