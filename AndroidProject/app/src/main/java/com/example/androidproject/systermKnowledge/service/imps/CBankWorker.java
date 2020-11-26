package com.example.androidproject.systermKnowledge.service.imps;

import android.os.Binder;
import android.util.Log;

import com.example.androidproject.systermKnowledge.service.interfaces.IBankWork;

public class CBankWorker extends Binder implements IBankWork {

    private static final String TAG = "CBankWorker";
    @Override
    public void saveMoney() {
        Log.i(TAG, "saveMoney");
    }
}
