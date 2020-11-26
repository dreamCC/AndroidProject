package com.example.androidproject.systermKnowledge.service.imps;

import android.os.Binder;
import android.util.Log;

import com.example.androidproject.systermKnowledge.service.interfaces.IBankBoss;

public class CBankBoss extends Binder implements IBankBoss {


    private static final String TAG = "CBankBoss";
    @Override
    public void modifyMoney() {
        Log.i(TAG, "modifyMoney");
    }

    @Override
    public void saveMoney() {
        Log.i(TAG, "saveMoney");
    }
}
