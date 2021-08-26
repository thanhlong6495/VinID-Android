package HomeActivities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.longtrang.vinid.R;
import org.jetbrains.annotations.NotNull;
import Fragments.FragmentPayment;
import Fragments.FragmentUsingCard;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QRCode extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationView bottomNavigationItemView;
    @BindView(R.id.btn_Using_Card)
    Button buttonUsingCard;
    @BindView(R.id.btn_Payment_By_Code)
    Button buttonPaymentByCode;
    @BindView(R.id.btn_Code_Scanner)
    Button buttonCodeScanner;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);
        bottomNavigationItemView.setSelectedItemId(R.id.nav_qr_code_scanner);
        setItemSelectedFromListener();
        autoFocusButton(buttonPaymentByCode);
    }

    private void setItemSelectedFromListener() {
        bottomNavigationItemView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(
                    @NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_qr_code_scanner:
                        return true;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(),
                                Profile.class)); overridePendingTransition(0,
                            0); return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),
                                HomePage.class)); overridePendingTransition(0
                            , 0); return true;
                    case R.id.nav_inbox:
                        startActivity(new Intent(getApplicationContext(),
                                Inbox.class)); overridePendingTransition(0,
                            0); return true;
                    case R.id.nav_my_wallet:
                        startActivity(new Intent(getApplicationContext(),
                                MyWallet.class)); overridePendingTransition(0
                            , 0); return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
            }
        });
    }

    @OnClick(R.id.btn_Payment_By_Code)
    protected void payment() {
        FragmentPayment fragmentPayment = new FragmentPayment();
        initializeFragment(fragmentPayment);
        fragmentPayment.setImageQRCode();
        buttonPaymentByCode.setBackgroundColor(ContextCompat.getColor(QRCode.this, R.color.button_qr_code_payment));
        buttonCodeScanner.setBackgroundColor(ContextCompat.getColor(QRCode.this, R.color.white));
        buttonUsingCard.setBackgroundColor(ContextCompat.getColor(QRCode.this
                , R.color.white));
    }

    @OnClick(R.id.btn_Code_Scanner)
    protected void scanCode() {
        buttonCodeScanner.setBackgroundColor(ContextCompat.getColor(QRCode.this, R.color.button_qr_code_payment));
        buttonPaymentByCode.setBackgroundColor(ContextCompat.getColor(QRCode.this, R.color.white));
        buttonUsingCard.setBackgroundColor(ContextCompat.getColor(QRCode.this
                , R.color.white));
        //        Initialize intent integrator
        IntentIntegrator intentIntegrator = new IntentIntegrator(QRCode.this);
        //        set beep
        intentIntegrator.setBeepEnabled(true);
        //        Locked orientation
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(CameraScanner.class);
        //        intentIntegrator.initiateScan();
        startActivity(new Intent(getApplicationContext(), CameraScanner.class));

    }

    @OnClick(R.id.btn_Using_Card)
    protected void usingCard() {
        initializeFragment(new FragmentUsingCard());
        buttonUsingCard.setBackgroundColor(ContextCompat.getColor(QRCode.this
                , R.color.button_qr_code_payment));
        buttonPaymentByCode.setBackgroundColor(ContextCompat.getColor(QRCode.this, R.color.white));
        buttonCodeScanner.setBackgroundColor(ContextCompat.getColor(QRCode.this, R.color.white));
    }

    //    @Override
    //    protected void onActivityResult(int requestCode, int resultCode,
    //    @androidx.annotation
    //    .Nullable @Nullable Intent data) {
    //        super.onActivityResult(requestCode, resultCode, data);
    ////        Initialize intent result
    //        IntentResult intentResult = IntentIntegrator
    //        .parseActivityResult(requestCode,
    //        resultCode,
    //                data);
    ////        check condition
    //        if(intentResult.getContents()!=null){
    //            AlertDialog.Builder builder = new AlertDialog.Builder
    //            (QRCode.this);
    //            builder.setTitle("Result");
    //            builder.setMessage(intentResult.getContents());
    //            builder.setPositiveButton("Ok", new DialogInterface
    //            .OnClickListener() {
    //                @Override
    //                public void onClick(DialogInterface dialog, int which) {
    //                    dialog.dismiss();
    //                }
    //            });
    //            builder.show();
    //        }
    //    }
    private void autoFocusButton(Button button) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        }, 200);
    }
    private void initializeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.show_fragment_place, fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(QRCode.this,HomePage.class));
    }
}