package HomeActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.longtrang.vinid.R;
import java.util.ArrayList;
import GridViewProfile.Category;
import GridViewProfile.CategoryAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Profile extends AppCompatActivity {
    @BindView(R.id.bottom_navigation_bar) NavigationBarView bottomNavigationView;
    @BindView(R.id.gridview_profile) GridView gridViewProfile;
    @BindView(R.id.tv_Profile_Infor) TextView textViewProfileInformation;
    @BindView(R.id.rating_bar) RatingBar ratingBar;
    private final String defaultPhoneNumber = "phonenumber";
    private final String defaultFullName = "fullname";
    private RatingBar ratingBarDialog;
    private BottomSheetDialog bottomSheetDialog;
    private Button buttonSendFeedBack;
    private ImageView buttonCloseDialog;
    private TextView textViewFeedBack;
    ArrayList<Category> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        getUserInformation();
        addViewToArrayList();
        setAdapter();
        bottomNavigationView.setSelectedItemId(R.id.nav_account);
        setItemSelectedFromListener();
        initialBottomSheetDialog();
        setRatingBar();
        setRatingBarDialog();
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
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_account:
                        return true;
                    case R.id.nav_qr_code_scanner:
                        startActivity(new Intent(getApplicationContext(), QRCode.class));
                        overridePendingTransition(0,0);
                        return true;
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
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void getUserInformation() {
        SharedPreferences sharedPreferences = getSharedPreferences("userInformation", MODE_PRIVATE);
        textViewProfileInformation.setText(new StringBuilder().append(sharedPreferences.getString("fullname",
                defaultFullName)).append("\n").append(sharedPreferences.getString("phonenumber",
                defaultPhoneNumber)).toString());
    }
    private void initialBottomSheetDialog() {
        bottomSheetDialog = new BottomSheetDialog(Profile.this, R.style.AppBottomSheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.profile_bottom_sheet_dialog);
        ratingBarDialog = bottomSheetDialog.findViewById(R.id.rating_bar_dialog);
        buttonSendFeedBack = bottomSheetDialog.findViewById(R.id.btn_Send_FeedBack);
        buttonCloseDialog = bottomSheetDialog.findViewById(R.id.btn_Close_Dialog);
        textViewFeedBack = bottomSheetDialog.findViewById(R.id.tv_feedback);
        ratingBarDialog.setRating(ratingBar.getRating());
        buttonSendFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setRating(ratingBarDialog.getRating());
                Toast.makeText(Profile.this, getResources().getString(R.string.thanks_for_rating),
                        Toast.LENGTH_LONG).show();
                try{
                    Thread.sleep(1500);
                    bottomSheetDialog.dismiss();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        buttonCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setRating(0);
                bottomSheetDialog.dismiss();
            }
        });
        onBackPress();
    }
    private void setRatingBar() {
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            ratingBarDialog.setRating(ratingBar.getRating());
            switch ((int) rating) {
                case 1 : case 2: case 3: case 4: case 5:
                    checkStar();
                    autoSetFeedBack();
                    break;
            }
        });
    }
    private void setRatingBarDialog() {
        ratingBarDialog.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                switch ((int) rating){
                    case 1: case 2: case 3: case 4: case 5:
                        autoSetFeedBack();
                }
            }
        });
    }
    private void checkStar(){
        try {
            Thread.sleep(400);
            ratingBar.setRating(ratingBarDialog.getRating());
            bottomSheetDialog.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void autoSetFeedBack() {
        if (ratingBar.getRating() == 1 || ratingBarDialog.getRating() == 1)
            textViewFeedBack.setText(getResources().getString(R.string.one_star));
        else if (ratingBar.getRating() == 2 || ratingBarDialog.getRating() == 2)
            textViewFeedBack.setText(getResources().getString(R.string.two_star));
        else if (ratingBar.getRating() == 3 || ratingBarDialog.getRating() == 3)
            textViewFeedBack.setText(getResources().getString(R.string.three_star));
        else if (ratingBar.getRating() == 4 || ratingBarDialog.getRating() == 4)
            textViewFeedBack.setText(getResources().getString(R.string.four_star));
        else if (ratingBar.getRating() == 5 || ratingBarDialog.getRating() == 5)
            textViewFeedBack.setText(getResources().getString(R.string.five_star));
    }
    private void onBackPress(){
        if(bottomSheetDialog.isShowing()) {
            ratingBar.setRating(0);
            bottomSheetDialog.dismiss();
        }
    }
}