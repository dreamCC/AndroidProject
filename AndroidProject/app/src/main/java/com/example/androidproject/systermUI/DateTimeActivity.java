package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {

    private Chronometer chronometer;
    private Button startBtn, pauseBtn, stopBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setFormat("当前时间为：%s");

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                Log.i("DateTimeActivity", "当前时间：" + chronometer.getText());
            }
        });
        startBtn = findViewById(R.id.btn_start);
        pauseBtn = findViewById(R.id.btn_pause);
        stopBtn  = findViewById(R.id.btn_stop);

        startBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                chronometer.start();
                break;
            case R.id.btn_pause:
                chronometer.stop();
                break;
            case R.id.btn_stop:
                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
        }
    }
}