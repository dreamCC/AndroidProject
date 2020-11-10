package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ProgressBarActivity extends AppCompatActivity {


    private SeekBar seekBar;
    private ProgressBar progressBar;

    private String kLogTag = "ProgressBarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressBar = findViewById(R.id.pb_3);
        seekBar = findViewById(R.id.sb_1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(kLogTag, "onProgressChanged:" + progress);
                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(kLogTag, "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i(kLogTag, "onStopTrackingTouch");
            }
        });
    }
}