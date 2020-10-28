package com.example.androidproject;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

    private String kLogTag = "kLogTag";
    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        String packageName = getPackageName();
        Log.i(kLogTag, "------------" + packageName);

    }
}
