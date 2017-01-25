package com.example.dfreeman.bettertodolist;

import android.support.annotation.NonNull;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static boolean isRemDate = false;
    public static boolean isStartDate = false;
    public static boolean isCompDate = false;

    @Override @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        if(MainActivity.isStartCal){
            MainActivity.tempStartCal.set(year, month, day);
        }
        if(MainActivity.isEndCal){
            MainActivity.tempEndCal.set(year, month, day);
        }
        if(MainActivity.isRemCal){
            MainActivity.tempRemCal.set(year, month, day);
        }
        //Reset for next Cal
        MainActivity.isStartCal=false;
        MainActivity.isEndCal=false;
        MainActivity.isRemCal=false;
    }

}
