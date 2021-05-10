package HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.longtrang.vinid.R;
import java.util.ArrayList;
import GridViewServices.Services;
import GridViewServices.ServicesAdapter;

public class HomePage extends AppCompatActivity {
    GridView gridViewServices;
    ArrayList<Services> arrayList;
    private BottomNavigationView bottomNavigationItemView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        assigningView();
        addViewToArrayList();
        setAdapter();
        bottomNavigationItemView.setSelectedItemId(R.id.nav_home);
        setItemSelectedFromListener();

    }
    private void addViewToArrayList() {
        arrayList   = new ArrayList<>();
        arrayList.add(new Services(getResources().getString(R.string.grocery), R.drawable.icon_grocery));
        arrayList.add(new Services(getResources().getString(R.string.food),
                R.drawable.icon_eating));
        arrayList.add(new Services(getResources().getString(R.string.Vinmart), R.drawable.icon_vinmart));
        arrayList.add(new Services(getResources().getString(R.string.Vincom), R.drawable.icon_vincom));
        arrayList.add(new Services(getResources().getString(R.string.voucher), R.drawable.icon_voucher));
        arrayList.add(new Services(getResources().getString(R.string.utilities), R.drawable.icon_utilities));
        arrayList.add(new Services(getResources().getString(R.string.Vinhomes), R.drawable.icon_vinhomes));
    }
    private void setAdapter() {
        ServicesAdapter servicesAdapter = new ServicesAdapter(this, R.layout.services, arrayList);
        gridViewServices.setAdapter(servicesAdapter);
    }
    private void assigningView() {
        gridViewServices            = findViewById(R.id.gridview_services);
        bottomNavigationItemView    = findViewById(R.id.bottom_navigation_bar);
    }
    private void setItemSelectedFromListener() {
        bottomNavigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_my_wallet:
                        startActivity(new Intent(getApplicationContext(), MyWallet.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_inbox:
                        startActivity(new Intent(getApplicationContext(), Inbox.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
            }
        });
    }
}