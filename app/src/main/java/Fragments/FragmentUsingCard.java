package Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.longtrang.vinid.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentUsingCard extends Fragment {
    private final String defaultname = "fullname";
    @BindView(R.id.tv_Full_Name) TextView textViewFullName;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_card, container, false);
        ButterKnife.bind(this,view);
        getFullName();
        return view;
    }
    private void getFullName(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userInformation", Context.MODE_PRIVATE);
        textViewFullName.setText(new StringBuilder(sharedPreferences.getString("fullname", defaultname)));
    }
}
