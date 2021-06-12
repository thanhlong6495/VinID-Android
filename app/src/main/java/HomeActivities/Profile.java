package HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.longtrang.vinid.R;
import java.util.ArrayList;
import GridViewProfile.Category;
import GridViewProfile.CategoryAdapter;

public class Profile extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    GridView gridViewProfile;
    ArrayList<Category> arrayList;
    public TextView textViewProfileInformation;
    private final String defaultPhoneNumber = "phonenumber";
    private final String defaultFullName = "fullname";
    private RatingBar ratingBar;
    private RatingBar ratingBarDiaglog;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        assigningView();
        getInformation();
        addViewToArrayList();
        setAdapter();
        bottomNavigationView.setSelectedItemId(R.id.nav_account);
        setItemSelectedFromListener();
        setRatingBar();
    }
    private void assigningView() {
        ratingBar                   = findViewById(R.id.rating_bar);
        textViewProfileInformation  = findViewById(R.id.tv_profile_information);
        bottomNavigationView        = findViewById(R.id.bottom_navigation_bar);
        gridViewProfile             = findViewById(R.id.gridview_profile);
    }
    private void addViewToArrayList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Category(R.drawable.img_point, getResources().getString(R.string.point)));
        arrayList.add(new Category(R.drawable.my_pocket,
                getResources().getString(R.string.my_pocket)));
        arrayList.add(new Category(R.drawable.address_book,
                getResources().getString(R.string.address_book)));
        arrayList.add(new Category(R.drawable.transaction_history,
                getResources().getString(R.string.transaction_history)));
        arrayList.add(new Category(R.drawable.contact_book,
                getResources().getString(R.string.contact_book)));
        arrayList.add(new Category(R.drawable.redeemed_gift,
                getResources().getString(R.string.redeemed_gift)));
        arrayList.add(new Category(R.drawable.setting, getResources().getString(R.string.setting)));
        arrayList.add(new Category(R.drawable.help_center,
                getResources().getString(R.string.help_center)));
        arrayList.add(new Category(R.drawable.share_friend,
                getResources().getString(R.string.share_with_friends)));
    }
    private void setAdapter() {
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, R.layout.profile_category,
                arrayList);
        gridViewProfile.setAdapter(categoryAdapter);
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
                        startActivity(new Intent(getApplicationContext(), Inbox.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_account:
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void getInformation() {
        SharedPreferences sharedPreferences = getSharedPreferences("userInformation", MODE_PRIVATE);
        textViewProfileInformation.setText(new StringBuilder().append(sharedPreferences.getString("fullname",
                defaultFullName)).append("\n").append(sharedPreferences.getString("phonenumber",
                defaultPhoneNumber)).toString());
    }
    private void setBottomSheetDialog() {
        bottomSheetDialog = new BottomSheetDialog(this, R.style.AppBottomSheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.profile_bottom_sheet_dialog);
        ratingBarDiaglog = bottomSheetDialog.findViewById(R.id.rating_bar_dialog);
        bottomSheetDialog.show();
    }
    private void setRatingBar() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                switch ((int) rating) {
                    case 1:
                        try {
                            Thread.sleep(500);
                            setBottomSheetDialog();
                            ratingBarDiaglog.setRating(ratingBar.getRating());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    case 2:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        setBottomSheetDialog();
                        ratingBarDiaglog.setNumStars(2);
                    case 3:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        setBottomSheetDialog();
                        ratingBarDiaglog.setNumStars(3);
                    case 4:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        setBottomSheetDialog();
                        ratingBarDiaglog.setNumStars(4);
                    case 5:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        setBottomSheetDialog();
                        ratingBarDiaglog.setNumStars(5);
                }
            }
        });
    }
}