package com.example.androidproject.systermKnowledge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidproject.MainActivity;
import com.example.androidproject.R;

public class LaunchModeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);

        Log.i("LaunchModeActivity", "LaunchModeActivity 的 task id = " + getTaskId());
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LaunchModeActivity.this, LaunchModeActivity.class);
                startActivity(intent);
            }
        });
    }
}