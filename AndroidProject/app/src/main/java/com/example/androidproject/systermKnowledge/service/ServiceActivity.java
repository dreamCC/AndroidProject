package com.example.androidproject.systermKnowledge.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

/**
*
* Service。属于四大组件：所以使用的使用需要在manifest里面注册。
 *    我们需要了解程序、进程、线程的区别。
 *    程序就是一堆静态代码。
 *    进程就是运行的程序。
 *    线程就是比进程更小的执行单元，每个进程可能有多个线程，线程需要放在进程中才能执行。
 *
 *    注意和线程的区别。
 *    android和ios的后台机制：
 *    ios：切换到后台后程序就会停止（一般有5s左右的缓冲事件，程序员可以进行延长）。当我们点击home键的时候，看到的其实是我们
 *    浏览程序的记录（这也是以前qq切换到后台不能收到消息的原因，当然现在ios采用通知的方式来解决这个问题）。所以哪怕我们是在循环遍历一些操作也会停止。
 *    android：应用在被切换到后台时，它其实已经被暂停了，并不会消耗cpu资源，只保留了运行状态。而且android运行需要虚拟机，这也是安卓程序更占内存的原因。
 *
 *    Service的生命周期，主要有三个方法：
 *    onCreate：
 *    onStartCommand:
 *    onDestroy:
 *
 *    Service两种启动方式startService和bindService两种的区别：
 *    startService如果不停止服务，那么服务会一直运行，不管父类是否销毁。
 *    bindService如果不停止服务，如果父类销毁，那么会报错。
*
* */



public class ServiceActivity extends AppCompatActivity {


    private static final String TAG = "ServiceActivity";
    private ServiceConnection serviceConnection;
    private ICommunication binder;
    private ServiceConnection bankWorkConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }


    // startService启动服务
    public void startServiceBtnClick(View view) {

        Intent serviceIntent = new Intent(this, MineService.class);
        startService(serviceIntent);
    }

    public void stopServiceBtnClick(View view) {

        Intent serviceIntent = new Intent(this, MineService.class);
        stopService(serviceIntent);
    }


    // bindService启动服务
    public void bindServiceBtnClick(View view) {
        Intent serviceIntent = new Intent();
        serviceIntent.setClass(this, MineService.class);
        serviceConnection = new ServiceConnection() {


            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (ICommunication) service;

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

                binder = null;
            }
        };

        bindService(serviceIntent, serviceConnection, BIND_AUTO_CREATE);
    }

    public void unBindServiceBtnClick(View view) {
        if(binder != null) {
            unbindService(serviceConnection);


        }
    }

    // 绑定银行
    public void bindBankServiceBtnClick(View view) {

        Intent intent = new Intent(this, BankService.class);
        intent.setAction("android.intent.action.BANK_WORKER");

        bankWorkConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                Log.i(TAG, service.toString());
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, bankWorkConnection, BIND_AUTO_CREATE);

    }

    public void unBindBankServiceBtnClick(View view) {
        if(binder != null) {
            unbindService(bankWorkConnection);
        }
    }



    public void callServiceMethodBtnClick(View view) {
        binder.callServiceInnerMethod();
    }
}