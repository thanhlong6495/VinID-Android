package Fragments;

import android.annotation.SuppressLint;
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

public class DatePickerFragment extends DialogFragment{
    DatePicker datePicker;
    Button buttonDone;
    ImageButton imageButtonClose;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_picker, container, false);
        datePicker          = view.findViewById(R.id.date_picker_spinner);
        imageButtonClose    = view.findViewById(R.id.img_btn_close_date_picker_dialog);
        buttonDone          = view.findViewById(R.id.btn_done_date_picker);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View subview) {
                int year    = datePicker.getYear();
                int month   = datePicker.getMonth();
                int day     = datePicker.getDayOfMonth();
                EditText editTextDateOfBirth = getActivity().findViewById(R.id.edt_date_of_birth);
                editTextDateOfBirth.setText(year + "/" + (month + 1) + "/" + day);
                onDestroyView();
            }
        });
        imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View subview) {
                onDestroyView();
            }
        });
        return view;
    }
}
