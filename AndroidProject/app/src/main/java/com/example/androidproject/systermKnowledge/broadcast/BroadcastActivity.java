package com.example.androidproject.systermKnowledge.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class BroadcastActivity extends AppCompatActivity {

    private String TAG = "BroadcastActivity";
    private BatteryBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 取消注册
        unregisterReceiver(receiver);

    }

    // 静态注册
    public void static_systemReceiver(View view) {
        // 静态注册是通过manifest进行配置注册。
    }

    // 动态注册
    public void dynamic_systemReceiver(View view) {

        IntentFilter intentFilter =  new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        // 当然我们可以在这个地方添加多个 action。
        receiver = new BatteryBroadcastReceiver();

        // 通过调用register进行注册。
        registerReceiver(receiver, intentFilter);
    }

    public void customReceiverRegister(View view) {

        IntentFilter customFilter = new IntentFilter();
        customFilter.addAction("com.example.androidproject.ACTION_CUTOM");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String value = intent.getStringExtra("key");
                Log.i("customReceiverRegister", value);
            }
        }, customFilter);
    }

    public void customReceiverSend(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.androidproject.ACTION_CUTOM");
        intent.putExtra("key", "发送的通知");
        sendBroadcast(intent);
    }

    // 电池监听
    private static class BatteryBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);

            Log.i("BatteryBroadcastReceive", "当前电量：" + level);
        }
    }

    // usb监听
    public static class UsbBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("UsbBroadcastReceiver", "usb监听。");

        }
    }

}