package com.example.androidproject.systermKnowledge.event;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ListenEventActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button;
    private String kLogTag = "ListenEventActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_event);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(kLogTag, "匿名内部类--点击");
            }
        });

        // 也可以使用外部类、内部类等方式。
    }

    @Override
    public void onClick(View v) {
        Log.i(kLogTag, "遵循interface--点击");
    }

}