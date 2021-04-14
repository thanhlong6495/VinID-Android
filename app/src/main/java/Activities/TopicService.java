package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ToggleButton;

import com.longtrang.vinid.R;

public class TopicService extends AppCompatActivity {
    ToggleButton toggleButtonEating;
    ToggleButton toggleButtonShopping;
    ToggleButton toggleButtonVincom;
    ToggleButton toggleButtonVinhomes;
    ToggleButton toggleButtonPoint;
    ToggleButton toggleButtonHomeHelper;
    ToggleButton toggleButtonBuyTicket;
    ToggleButton toggleButtonPayment;
    ToggleButton toggleButtonVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_service);
    }
}