package HomeActivities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.longtrang.vinid.R;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QRCode extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar) BottomNavigationView bottomNavigationItemView;
    @BindView(R.id.btn_Using_Card) Button buttonUsingCard;
    @BindView(R.id.btn_Payment_By_Code) Button buttonPaymentByCode;
    @BindView(R.id.btn_Code_Scanner) Button buttonCodeScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);
        bottomNavigationItemView.setSelectedItemId(R.id.nav_qr_code_scanner);
        setItemSelectedFromListener();
    }
    private void setItemSelectedFromListener(){
        bottomNavigationItemView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_qr_code_scanner:
                        buttonPaymentByCode.requestFocus();
                        return true;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_inbox:
                        startActivity(new Intent(getApplicationContext(), Inbox.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_my_wallet:
                        startActivity(new Intent(getApplicationContext(), MyWallet.class));
                        overridePendingTransition(0,0);
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
            }
        });
    }
@OnClick(R.id.btn_Payment_By_Code)
    protected void payment(){
        buttonPaymentByCode.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.button_qr_code_payment));
        buttonCodeScanner.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.white));
        buttonUsingCard.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.white));
}
@OnClick(R.id.btn_Code_Scanner)
    protected void scanCode(){
        buttonCodeScanner.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.button_qr_code_payment));
        buttonPaymentByCode.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.white));
        buttonUsingCard.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.white));
//        Initialize intent integrator
        IntentIntegrator intentIntegrator = new IntentIntegrator(QRCode.this);
//        set prompt text
//        intentIntegrator.setPrompt(getResources().getString(R.string.prompt_text));
//        set beep
        intentIntegrator.setBeepEnabled(true);
//        Locked orientation
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(CameraScanner.class);
//        initialize scan
//        intentIntegrator.initiateScan();
        startActivity(new Intent(getApplicationContext(),CameraScanner.class));
}
@OnClick(R.id.btn_Using_Card)
    protected void usingCard(){
        buttonUsingCard.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.button_qr_code_payment));
        buttonPaymentByCode.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.white));
        buttonCodeScanner.setBackgroundColor(ContextCompat.getColor(QRCode.this,R.color.white));
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        Initialize intent result
//        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode,
//                data);
////        check condition
//        if(intentResult.getContents()!=null){
//            AlertDialog.Builder builder = new AlertDialog.Builder(QRCode.this);
//            builder.setTitle("Result");
//            builder.setMessage(intentResult.getContents());
//            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });
//            builder.show();
//        }
//        else {
//            Toast.makeText(QRCode.this,"OOPS... You did not scan anything",Toast.LENGTH_LONG).show();
//        }
//    }
}