package Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.longtrang.vinid.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentPayment extends Fragment {
    public @BindView(R.id.img_QR_Code)
    ImageView imageViewQRCode;
    public ArrayList<Integer> arrayQRCode = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    public void setImageQRCode() {
        //Add image to arrayQRCode
        arrayQRCode.add(R.drawable.my_qr_code_1);
        arrayQRCode.add(R.drawable.my_qr_code_2);
        arrayQRCode.add(R.drawable.my_qr_code_3);
        //Auto change image after 60s
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                imageViewQRCode.setImageResource(arrayQRCode.get(i));
                ++i;
                if (i == arrayQRCode.size()) i = 0;
                imageViewQRCode.postDelayed(this,getResources().getInteger(R.integer.QR_Code_refresh));
            }
        };
        handler.postDelayed(runnable,0);
    }

}
