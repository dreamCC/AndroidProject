package com.example.androidproject.systermKnowledge.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class BroadcastActivity extends AppCompatActivity {

    private String TAG = "BroadcastActivity";
    private BatteryBroadcastReciver reciver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        IntentFilter intentFilter =  new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        reciver = new BatteryBroadcastReciver();
        registerReceiver(reciver, intentFilter);

        Log.i(TAG, this.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 取消注册
        unregisterReceiver(reciver);
    }

    private static class BatteryBroadcastReciver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.i("BatteryBroadcastReciver", context.toString() + intent.toString());
        }
    }
}