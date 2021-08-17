package Fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.longtrang.vinid.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatePickerFragment extends DialogFragment{
    @BindView(R.id.Date_Picker_Spinner) DatePicker datePicker;
    @BindView(R.id.btn_Done_DatePicker) Button buttonDone;
    @BindView(R.id.btn_Close_DatePicker) ImageButton buttonClose;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_picker, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @OnClick(R.id.btn_Close_DatePicker)
    protected void closeDatePicker(){
        onDestroyView();
    }
    @OnClick(R.id.btn_Done_DatePicker)
    void chooseDateOfBirth(){
        int year    = datePicker.getYear();
        int month   = datePicker.getMonth();
        int day     = datePicker.getDayOfMonth();
        EditText editTextDateOfBirth = getActivity().findViewById(R.id.edt_Date_Of_Birth);
        editTextDateOfBirth.setText(year + "/" + (month + 1) + "/" + day);
        onDestroyView();
    }
}
