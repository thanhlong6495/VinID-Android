package HomeActivities;

import android.content.Intent;

import com.journeyapps.barcodescanner.CaptureActivity;

public class CameraScanner extends CaptureActivity {
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(CameraScanner.this,HomePage.class));
    }
}


