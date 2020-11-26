package com.example.androidproject.systermKnowledge.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.androidproject.systermKnowledge.service.imps.CBankBoss;
import com.example.androidproject.systermKnowledge.service.imps.CBankWorker;

public class BankService extends Service {

    private static final String TAG = "BankService";

    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        if (action == "android.intent.action.BANK_WORKER") {
            Log.i(TAG, "onBind=CBankWorker");
            return new CBankWorker();
        }else {
            Log.i(TAG, "onBind=CBankBoss");
            return new CBankBoss();
        }
    }



    // 生命周期

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
