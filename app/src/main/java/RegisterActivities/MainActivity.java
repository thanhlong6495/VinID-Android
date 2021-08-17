package RegisterActivities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;
import com.longtrang.vinid.R;
import java.util.Locale;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_Vietnamese) TextView textViewLanguageVietnamese;
    @BindView(R.id.tv_Japanese) TextView textViewLanguageJapanese;
    @BindView(R.id.tv_English) TextView textViewLanguageEnglish;
    @BindView(R.id.PhoneNumber) EditText editTextPhonenumber;
    private Locale   mMyLocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.PhoneNumber)
    void goToPhoneNumberRegister(){
           Intent intent = new Intent(MainActivity.this, PhoneNumberRegister.class);
           startActivity(intent);
    }
    @OnClick(R.id.tv_Vietnamese)
    void btnVietnameseClick() {
        mMyLocale = new Locale("vi", "VN");
        onChangeLanguage(mMyLocale);
    }
    @OnClick(R.id.tv_English)
    void btnEnglishClick() {
        mMyLocale = new Locale("en", "US");
        onChangeLanguage(mMyLocale);
    }
    @OnClick(R.id.tv_Japanese)
    void btnJapaneseClick() {
        mMyLocale = new Locale("ja", "JP");
        onChangeLanguage(mMyLocale);
    }
//    Change languages on this activity follow the location
    public void onChangeLanguage(Locale mMyLocale) {
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        Configuration configuration = new Configuration();
//        check android version
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
}