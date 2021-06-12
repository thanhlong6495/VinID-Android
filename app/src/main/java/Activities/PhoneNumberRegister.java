<<<<<<< HEAD:app/src/main/java/RegisterActivities/PhoneNumberRegister.java
package RegisterActivities;
=======
package Activities;
>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/PhoneNumberRegister.java

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

import com.longtrang.vinid.R;

public class PhoneNumberRegister extends AppCompatActivity {
    TextView textViewPhoneNumber;
    TextView textViewInvitationCode;
    TextView textViewPolicy;
    EditText editTextPhoneNumber;
    Button   buttonNext;
<<<<<<< HEAD:app/src/main/java/RegisterActivities/PhoneNumberRegister.java
    static String   phoneNumber;
    Intent intent;
=======
    String   phoneNumber;
>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/PhoneNumberRegister.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_number_register);
        assigningView();
        editTextPhoneNumber.requestFocus();
    }
<<<<<<< HEAD:app/src/main/java/RegisterActivities/PhoneNumberRegister.java
=======

>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/PhoneNumberRegister.java
    public void assigningView() {
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
<<<<<<< HEAD:app/src/main/java/RegisterActivities/PhoneNumberRegister.java
        if (editTextPhoneNumber.length() < getResources().getInteger(R.integer.phone_number)) {
=======
        phoneNumber = editTextPhoneNumber.getText().toString().trim();
        if (phoneNumber.length() < getResources().getInteger(R.integer.phone_number)) {
>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/PhoneNumberRegister.java
            Toast.makeText(this, getResources().getString(R.string.phone_number_warning), Toast.LENGTH_LONG).show();
        }
        else {
            phoneNumber = editTextPhoneNumber.getText().toString().trim();
            SharedPreferences sharedPreferences = getSharedPreferences("userInformation",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("phonenumber", phoneNumber);
            editor.commit();
            intent = new Intent(PhoneNumberRegister.this, ConfirmOTP.class);
            intent.putExtra("phonenumber",phoneNumber);
            startActivity(intent);
        }
    }
}