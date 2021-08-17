package RegisterActivities;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import Fragments.DatePickerFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.longtrang.vinid.R;

public class PersonalInformation extends AppCompatActivity {
    @BindView(R.id.edt_Full_Name) EditText editTextFullName;
    @BindView(R.id.edt_Date_Of_Birth) EditText editTextDateOfBirth;
    @BindView(R.id.edt_Email) EditText editTextEmail;
    @SuppressLint("ResourceAsColor")
    protected String fullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editTextDateOfBirth.setShowSoftInputOnFocus(false);
        }
    }

    @OnClick(R.id.edt_Date_Of_Birth)
    //pop up dialogfragment
    protected void onClickDateOfBirth(){
        DatePickerFragment pickDialog = new DatePickerFragment();
        pickDialog.show(getFragmentManager(), "datepicker");
    }

    //click on next button
    @OnClick(R.id.btn_Next_Persional_Infor)
    protected void goToTopicService() {
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