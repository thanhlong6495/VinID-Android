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
    EditText edtPhoneNumber;
    TextView tvphonenumber, tvintroduce_title,tvintroduce_detail,tvVi, tvEn,tvJa;
    Locale mMyLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        tvVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyLocale = new Locale("vi","VN");
                onChangeLanguage(mMyLocale);
            }
        });
        tvEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyLocale = new Locale("en","US");
                onChangeLanguage(mMyLocale);
            }
        });
        tvJa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyLocale = new Locale("ja","JP");
                onChangeLanguage(mMyLocale);
            }
        });

    }
    public void AnhXa(){
        tvVi               = findViewById(R.id.btnVietnamese);
        tvEn               = findViewById(R.id.btnEnglish);
        tvJa               = findViewById(R.id.btnJapanese);
        edtPhoneNumber      = findViewById(R.id.phonenumber);
        tvphonenumber       = findViewById(R.id.tvphonenumber);
        tvintroduce_title   = findViewById(R.id.tvintroduce_title);
        tvintroduce_detail  = findViewById(R.id.tvintroduce_detail);

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
    public void GoToRegisForm(View view) {

        Intent intent = new Intent(MainActivity.this,RegisterForm.class);
        startActivity(intent);

    }
}