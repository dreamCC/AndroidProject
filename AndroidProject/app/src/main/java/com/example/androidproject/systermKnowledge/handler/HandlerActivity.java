package com.example.androidproject.systermKnowledge.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.androidproject.R;

public class HandlerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        handler();
    }

    void handler() {

       final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    // TODO some things
                    Toast.makeText(HandlerActivity.this, "捕捉到消息", Toast.LENGTH_LONG).show();
                }
            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {

                handler.sendEmptyMessage(1);
            }
        }).start();

    }
}