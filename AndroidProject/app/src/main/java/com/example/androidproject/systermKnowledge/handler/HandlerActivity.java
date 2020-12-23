package com.example.androidproject.systermKnowledge.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class HandlerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //handlerSendMsg();
        handlerPost();
    }

//    1. Handler用法简单明了，可以将多个异步任务更新UI的代码放在一起，清晰明了
//    2. 处理单个异步任务代码略显多
    void handlerSendMsg() {

        final MineHandle handler = new MineHandle();

        new Thread(new Runnable() {
            @Override
            public void run() {

                handler.sendEmptyMessage(1);

            }
        }).start();

    }

    // 使用简单。
    void handlerPost() {

       final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 通过post来进行切换。post内部其实就是调用sendMsg方法。
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        // 更新ui线程。
                        Toast.makeText(HandlerActivity.this, "ui线程", Toast.LENGTH_SHORT).show();
                    }
                });

                // 直接通过runOnUiThread实现。
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO 更新主线程。

                    }
                });
            }
        }).start();
    }

    static class MineHandle extends Handler {

        private String TAG = "MineHandle";

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i(TAG, "捕捉到消息" + msg.what);

            switch (msg.what) {
                case 1:
                    break;
            }
        }
    }


}