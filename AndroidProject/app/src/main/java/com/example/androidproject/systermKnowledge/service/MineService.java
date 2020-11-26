package com.example.androidproject.systermKnowledge.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MineService extends Service {


    private String TAG = this.getClass().getName();


    // 私有防范
    private void privateMethod() {
        Toast.makeText(this, "内部方法调用", Toast.LENGTH_SHORT).show();
    }


    // 如果binder是私有类
    private class MineBinder extends Binder implements ICommunication{
        @Override
        public void callServiceInnerMethod() {
            privateMethod();
        }
    }

    // system recycle
    @Override
    public IBinder onBind(Intent intent) {

        Log.i(TAG, "onBind");
        return new MineBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

    }
}
