package com.longtrang.vinid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editTextPhoneNumber;
    TextView textViewPhoneNumber, textViewIntroduceTitle,textViewIntroduceContent,textViewLanguageVietnamese, textViewLanguageEnglish,textViewLanguageJapanese;
    Locale mMyLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        textViewLanguageVietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyLocale = new Locale("vi","VN");
                onChangeLanguage(mMyLocale);
            }
        });
        textViewLanguageEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyLocale = new Locale("en","US");
                onChangeLanguage(mMyLocale);
            }
        });
        textViewLanguageJapanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyLocale = new Locale("ja","JP");
                onChangeLanguage(mMyLocale);
            }
        });

    }
    public void AnhXa(){
        textViewLanguageVietnamese               = findViewById(R.id.btnVietnamese);
        textViewLanguageEnglish               = findViewById(R.id.btnEnglish);
        textViewLanguageJapanese               = findViewById(R.id.btnJapanese);
        editTextPhoneNumber      = findViewById(R.id.phonenumber);
        textViewPhoneNumber       = findViewById(R.id.tvphonenumber);
        textViewIntroduceTitle   = findViewById(R.id.tvintroduce_title);
        textViewIntroduceContent  = findViewById(R.id.tvintroduce_detail);

    }
    public void onChangeLanguage(Locale mMyLocale){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        Configuration configuration = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(mMyLocale);
        }else{
            configuration.locale = mMyLocale;
        }

        getBaseContext().getResources().updateConfiguration(configuration,displayMetrics);
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void goToRegisForm(View view) {

        Intent intent = new Intent(MainActivity.this,RegisterForm.class);
        startActivity(intent);

    }
}