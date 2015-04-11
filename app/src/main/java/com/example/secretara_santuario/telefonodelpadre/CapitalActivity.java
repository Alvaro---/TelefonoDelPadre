package com.example.secretara_santuario.telefonodelpadre;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import clases.Capital;

/**
 * Created by HP on 11/04/2015.
 */
public class CapitalActivity extends Activity {


    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_capital);
        initializeCalendar();
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendarView);
        // sets whether to show the week number.
        calendar.setShowWeekNumber(false);

        // sets the first day of week according to Calendar.
        // here we set Monday as the first day of the Calendar
        calendar.setFirstDayOfWeek(2);
        //The background color for the selected week.
        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));
        //sets the color for the dates of an unfocused month.
        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));
        //sets the color for the separator line between weeks.
        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.transparent));
        //sets the color for the vertical bar shown at the beginning and at the end of the selected date.
        calendar.setSelectedDateVerticalBar(R.color.darkgreen);
        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                String fechaOb=day + "/" + month + "/" + year;
                Log.v("FECHA: ",fechaOb);
                Capital cap=new Capital("","");
                cap.cargarFecha(fechaOb);
                Toast.makeText(getApplicationContext(), cap.getFrase(), Toast.LENGTH_LONG).show();
                Log.v("fecha base: ",cap.getFecha());
            }
        });
    }

}
