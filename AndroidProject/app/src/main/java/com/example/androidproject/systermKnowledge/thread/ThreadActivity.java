package com.example.androidproject.systermKnowledge.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import static java.lang.Thread.sleep;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);


        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadDefineRunnable();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadAnonymityRunnable();
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                threadAnonymity();
            }
        });

        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MineTask task = new MineTask();
                task.execute(1000);
            }
        });
    }

    // 通过。创建runnable来实现。
    void threadDefineRunnable() {

        MineRunnable runnable = new MineRunnable();
        Thread thread  = new Thread(runnable);
        thread.start();
    }

    void threadAnonymityRunnable() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0, j=10; i<j; i++) {
                    try {
                        sleep(1000);
                        Log.i("匿名Runnable", Thread.currentThread().toString() + i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }

    void threadAnonymity() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j=10; i<j; i++) {
                    try {
                        sleep(1000);
                        Log.i("匿名Thread", Thread.currentThread().toString() + i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }


    // 通过
    static class MineRunnable implements Runnable {

        @Override
        public void run() {

            for (int i = 0, j=10; i<j; i++) {
                try {
                    sleep(1000);
                    Log.i("自定义Runnable", Thread.currentThread().toString() + i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    // AsyncTask<Params, Progress, Result>
    static class MineTask extends AsyncTask<Integer, Integer, String> {

        // 最先开始执行
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // 线程开始执行
            Log.i("AsyncTask", Thread.currentThread().toString() + "开始执行");

        }

        // 该方法是在子线程运行。integers就是输入的参数。
        @Override
        protected String doInBackground(Integer... integers) {

            for (int i = 0, j=10; i<j; i++) {
                try {
                    sleep(1000);
                    Log.i("AsyncTask", Thread.currentThread().toString() + i);

                    // 更新进度
                    publishProgress(i*10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return "执行完毕";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            Log.i("AsyncTask", Thread.currentThread().toString() + "执行进度:" + values[0]);

        }
    }
}