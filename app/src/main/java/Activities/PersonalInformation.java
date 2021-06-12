package Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import Fragments.DatePickerFragment;
import com.longtrang.vinid.R;

public class PersonalInformation extends AppCompatActivity {
    EditText editTextFullName;
    EditText editTextDateOfBirth;
    EditText editTextEmail;
    Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        assigningView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editTextDateOfBirth.setShowSoftInputOnFocus(false);
        }
    }
    public void showDatePickerDialog(View view) {
        DatePickerFragment pickDialog = new DatePickerFragment();
        pickDialog.show(getFragmentManager(), "datepicker");
    }
    public void assigningView() {
        editTextFullName    = findViewById(R.id.edt_full_name);
        editTextDateOfBirth = findViewById(R.id.edt_date_of_birth);
        editTextEmail       = findViewById(R.id.edt_email);
        buttonNext          = findViewById(R.id.btn_next_personal_information);
    }
}