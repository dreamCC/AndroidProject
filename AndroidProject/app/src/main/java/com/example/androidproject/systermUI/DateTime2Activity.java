package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class DateTime2Activity extends AppCompatActivity {


    private DatePicker datePicker;
    private TimePicker timePicker;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time2);

        calendarView = findViewById(R.id.calendarV);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                Log.i("DateTime2Activity", "当前选择的事件" + year + month + dayOfMonth);
            }
        });


    }
}