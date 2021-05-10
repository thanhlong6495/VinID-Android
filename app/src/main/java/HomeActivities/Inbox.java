package HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.longtrang.vinid.R;

public class Inbox extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        assigningView();
        bottomNavigationView.setSelectedItemId(R.id.nav_inbox);
        setItemSelectedFromListener();
    }
    private void assigningView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
    }
    private void setItemSelectedFromListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_my_wallet:
                        startActivity(new Intent(getApplicationContext(), MyWallet.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_inbox:
//                        startActivity(new Intent(getApplicationContext(), Inbox.class));
//                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}