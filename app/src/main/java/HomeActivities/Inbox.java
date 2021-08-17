package HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationBarView;
import com.longtrang.vinid.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Inbox extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar) NavigationBarView bottomNavigationItemView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        ButterKnife.bind(this);
        bottomNavigationItemView.setSelectedItemId(R.id.nav_inbox);
        setItemSelectedFromListener();
    }

    private void setItemSelectedFromListener() {
        bottomNavigationItemView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_inbox:
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_my_wallet:
                        startActivity(new Intent(getApplicationContext(), MyWallet.class));
                        overridePendingTransition(0, 0);
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