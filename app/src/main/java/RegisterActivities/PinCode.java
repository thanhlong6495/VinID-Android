package RegisterActivities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import com.longtrang.vinid.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PinCode extends AppCompatActivity {
    @BindView(R.id.edt_PIN1) EditText editTextPin1;
    @BindView(R.id.edt_PIN2) EditText editTextPin2;
    @BindView(R.id.edt_PIN3) EditText editTextPin3;
    @BindView(R.id.edt_PIN4) EditText editTextPin4;
    @BindView(R.id.edt_PIN5) EditText editTextPin5;
    @BindView(R.id.edt_PIN6) EditText editTextPin6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_code);
        ButterKnife.bind(this);
        editTextPin1.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        controlCursor();
    }
    //click on button next
    @OnClick(R.id.btn_Next_PinCode)
    protected void goToPersonalInfomation() {
        if (editTextPin1.length() > 0 && editTextPin2.length() > 0 && editTextPin3.length() > 0 && editTextPin4.length() > 0 && editTextPin5.length() > 0 && editTextPin6.length() > 0){
            startActivity(new Intent(PinCode.this, PersonalInformation.class));
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.pin_code_warning), Toast.LENGTH_LONG).show();
        }
    }
    //click on back arrow
    @OnClick(R.id.btn_Back_PIN)
    protected void backToConfirmOTP() {
        startActivity(new Intent(PinCode.this, ConfirmOTP.class));
    }
    
    public void controlCursor() {
        editTextPin1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {
                //To Do
            }
            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //To Do
            }
            @Override
            public void afterTextChanged(Editable string) {
                if (string.length() > 0) {
                    editTextPin2.requestFocus();
                }
            }
        });
        editTextPin2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {
                //To Do
            }
            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //To Do
            }
            @Override
            public void afterTextChanged(Editable string) {
                if (string.length() > 0) {
                    editTextPin3.requestFocus();
                }
            }
        });
        editTextPin3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {
                //To Do
            }
            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //To Do
            }
            @Override
            public void afterTextChanged(Editable string) {
                if (string.length() > 0) {
                    editTextPin4.requestFocus();
                }
            }
        });
        editTextPin4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {
                //To Do
            }
            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //To Do
            }
            @Override
            public void afterTextChanged(Editable string) {
                if (string.length() > 0) {
                    editTextPin5.requestFocus();
                }
            }
        });
        editTextPin5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {
                //To Do
            }
            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                //To Do
            }
            @Override
            public void afterTextChanged(Editable string) {
                if (string.length() > 0) {
                    editTextPin6.requestFocus();
                }
            }
        });
    }

}