package com.example.androidproject.java.多线程;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MulitiThreadActivity extends AppCompatActivity {


    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muliti_thread);

        // 创建计时器对象。
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, new Date());



    }

    private void startThread() {
        CustomThread ct = new CustomThread();
        ct.start(); // 注意一定是start方法才是开启。 直接调用run方法，相当于平时调用run方法，并不会执行多线程。

        new Thread() {
            @Override
            public void run() {


            }
        }.start();

    }

    private void startThreadUseRunnable() {

        CustomRunnable cr = new CustomRunnable();
        Thread t = new Thread(cr);
        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }

    private void setDamn() {
        Thread t1 = new Thread(){
            @Override
            public void run() {

                synchronized (this) {
                    for (int i = 0; i < 50; i++ ){
                        System.out.println("------b");

                    }
                }
            }
        };

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (this) {
                    for (int i = 0; i < 2; i++ ){
                        System.out.println("------a");

                    }
                }
            }
        });

        t1.setDaemon(true); // 设置守护线程，就是为了守护其他线程，如果其他线程执行完成，该线程直接退出。

        t1.start();
        t2.start();

        ThreadGroup tg1 = t1.getThreadGroup();
        ThreadGroup tg2 = t2.getThreadGroup();

        String name1 = tg1.getName();
        String name2 = tg2.getName();


    }


}

class CustomThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000;  i++) {
            // 子线程
        }
    }
}

class CustomRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000;  i++) {
            // 子线程

        }
    }
}