package RegisterActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.longtrang.vinid.R;

import HomeActivities.HomePage;

public class TopicService extends AppCompatActivity {
    protected ToggleButton toggleButtonEating;
    protected ToggleButton toggleButtonShopping;
    protected ToggleButton toggleButtonVincom;
    protected ToggleButton toggleButtonVinhomes;
    protected ToggleButton toggleButtonPoint;
    protected ToggleButton toggleButtonHomeHelper;
    protected ToggleButton toggleButtonBuyTicket;
    protected ToggleButton toggleButtonPayment;
    protected ToggleButton toggleButtonVoucher;
    protected TextView textViewSkip;
    protected Button buttonNext;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_service);
        assigningView();
    }
    private void assigningView() {
        toggleButtonEating      = findViewById(R.id.btn_eating);
        toggleButtonShopping    = findViewById(R.id.btn_shopping);
        toggleButtonVincom      = findViewById(R.id.btn_vincom);
        toggleButtonVinhomes    = findViewById(R.id.btn_vinhomes);
        toggleButtonPoint       = findViewById(R.id.btn_point);
        toggleButtonHomeHelper  = findViewById(R.id.btn_home_helper);
        toggleButtonBuyTicket   = findViewById(R.id.btn_buy_ticket);
        toggleButtonPayment     = findViewById(R.id.btn_payment);
        toggleButtonVoucher     = findViewById(R.id.btn_voucher);
        textViewSkip            = findViewById(R.id.tv_skip_choose_topic);
        buttonNext              = findViewById(R.id.btn_start_using);
    }

    public void goToHomePage(View view) {
        intent = new Intent(TopicService.this, HomePage.class);
        startActivity(intent);
    }
}