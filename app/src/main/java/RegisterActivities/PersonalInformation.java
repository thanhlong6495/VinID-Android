package RegisterActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import Fragments.DatePickerFragment;
import com.longtrang.vinid.R;

public class PersonalInformation extends AppCompatActivity {
    EditText editTextFullName;
    EditText editTextDateOfBirth;
    EditText editTextEmail;
    Button buttonNext;
    public String fullName;
    @SuppressLint("ResourceAsColor")
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

    public void goToTopicService(View view) {
        if (editTextFullName.length() > 0 && editTextDateOfBirth.length() > 0 && editTextEmail.length() > 0) {
            Intent intent = new Intent(PersonalInformation.this, TopicService.class);
            fullName = editTextFullName.getText().toString();
            SharedPreferences sharedPreferences = getSharedPreferences("userInformation",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("fullname", fullName);
            editor.apply();
            startActivity(intent);
        }
        else {
            Toast.makeText(this, getResources().getString(R.string.information_warning), Toast.LENGTH_LONG).show();
        }
    }
}