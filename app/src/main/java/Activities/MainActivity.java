<<<<<<< HEAD:app/src/main/java/RegisterActivities/MainActivity.java
package RegisterActivities;
=======
package Activities;
>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/MainActivity.java

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
<<<<<<< HEAD:app/src/main/java/RegisterActivities/MainActivity.java
import com.longtrang.vinid.R;
=======

import com.longtrang.vinid.R;

>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/MainActivity.java
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editTextPhoneNumber;
    TextView textViewLanguageVietnamese;
    TextView textViewLanguageJapanese;
    TextView textViewLanguageEnglish;
    Locale   mMyLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assigningView();
<<<<<<< HEAD:app/src/main/java/RegisterActivities/MainActivity.java
        setLanguge();

=======
        textViewLanguageVietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyLocale = new Locale("vi","VN");
                onChangeLanguage(mMyLocale);
            }
        });
        textViewLanguageEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyLocale = new Locale("en","US");
                onChangeLanguage(mMyLocale);
            }
        });
        textViewLanguageJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyLocale = new Locale("ja","JP");
                onChangeLanguage(mMyLocale);
            }
        });
>>>>>>> be95a8073c19b250768282c0fc5001f0f31477ce:app/src/main/java/Activities/MainActivity.java
    }
    public void assigningView() {
        textViewLanguageVietnamese  = findViewById(R.id.btnVietnamese);
        textViewLanguageEnglish     = findViewById(R.id.btnEnglish);
        textViewLanguageJapanese    = findViewById(R.id.btnJapanese);
        editTextPhoneNumber         = findViewById(R.id.phonenumber);
    }
    public void onChangeLanguage(Locale mMyLocale) {
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        Configuration configuration = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(mMyLocale);
        }
        else {
            configuration.locale = mMyLocale;
        }
        getBaseContext().getResources().updateConfiguration(configuration,displayMetrics);
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void goToRegisForm(View view) {
        Intent intent = new Intent(MainActivity.this, PhoneNumberRegister.class);
        startActivity(intent);
    }
    private void setLanguge() {
        textViewLanguageVietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyLocale = new Locale("vi","VN");
                onChangeLanguage(mMyLocale);
            }
        });
        textViewLanguageEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyLocale = new Locale("en","US");
                onChangeLanguage(mMyLocale);
            }
        });
        textViewLanguageJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyLocale = new Locale("ja","JP");
                onChangeLanguage(mMyLocale);
            }
        });
    }
}