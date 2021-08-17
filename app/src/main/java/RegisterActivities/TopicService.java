package RegisterActivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.longtrang.vinid.R;
import HomeActivities.HomePage;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopicService extends AppCompatActivity {
    protected @BindView(R.id.btn_eating) ToggleButton toggleButtonEating;
    protected @BindView(R.id.btn_shopping) ToggleButton toggleButtonShopping;
    protected @BindView(R.id.btn_vincom) ToggleButton toggleButtonVincom;
    protected @BindView(R.id.btn_vinhomes) ToggleButton toggleButtonVinhomes;
    protected @BindView(R.id.btn_point) ToggleButton toggleButtonPoint;
    protected @BindView(R.id.btn_home_helper) ToggleButton toggleButtonHomeHelper;
    protected @BindView(R.id.btn_buy_ticket) ToggleButton toggleButtonBuyTicket;
    protected @BindView(R.id.btn_payment) ToggleButton toggleButtonPayment;
    protected @BindView(R.id.btn_voucher) ToggleButton toggleButtonVoucher;
    protected @BindView(R.id.tv_skip_choose_topic) TextView textViewSkip;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_service);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.btn_start_using,R.id.tv_skip_choose_topic})
    protected void goToHomePage() {
        intent = new Intent(TopicService.this, HomePage.class);
        startActivity(intent);
    }
}