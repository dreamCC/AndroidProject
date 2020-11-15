package com.example.androidproject.systermKnowledge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;
import com.example.androidproject.systermKnowledge.broadcast.BroadcastActivity;
import com.example.androidproject.systermKnowledge.fragment.DynamicFragmentActivity;
import com.example.androidproject.systermKnowledge.fragment.StaticFragmentActivity;
import com.example.androidproject.systermKnowledge.handler.HandlerActivity;
import com.example.androidproject.systermKnowledge.intent.IntentActivity;
import com.example.androidproject.systermKnowledge.intent.LaunchModeActivity;
import com.example.androidproject.systermKnowledge.intent.LifeRecycleActivity;
import com.example.androidproject.systermKnowledge.keyword.KeywordActivity;
import com.example.androidproject.systermKnowledge.thread.ThreadActivity;

public class SystemKnowledgeActivity extends AppCompatActivity implements View.OnClickListener {

    private String kLogTag = "SystemKnowledgeActivity";

    private Button intent, lifeRecycle, launchMode;
    private Button staticFragment, dynamicFragment;
    private Button broadcast;
    private Button keyword;
    private Button handler;
    private Button thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_knowledge);

        Log.i("SystemKnowledgeActivity", "SystemKnowledgeActivity 的 task id = " + getTaskId());

        intent = findViewById(R.id.btn_1);
        intent.setOnClickListener(this);

        lifeRecycle = findViewById(R.id.btn_2);
        lifeRecycle.setOnClickListener(this);

        launchMode  = findViewById(R.id.btn_3);
        launchMode.setOnClickListener(this);

        staticFragment = findViewById(R.id.btn_4);
        staticFragment.setOnClickListener(this);

        dynamicFragment = findViewById(R.id.btn_5);
        dynamicFragment.setOnClickListener(this);

        broadcast = findViewById(R.id.btn_6);
        broadcast.setOnClickListener(this);

        keyword = findViewById(R.id.btn_7);
        keyword.setOnClickListener(this);

        handler = findViewById(R.id.btn_8);
        handler.setOnClickListener(this);

        thread = findViewById(R.id.btn_9);
        thread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == intent) {
            Intent intent = new Intent(this, IntentActivity.class);
            startActivity(intent);
        }else if(v == lifeRecycle) {
            Intent intent = new Intent(this, LifeRecycleActivity.class);
            startActivity(intent);
        }else if(v == launchMode) {
            Intent intent = new Intent(this, LaunchModeActivity.class);
            startActivity(intent);
        }else if( v == staticFragment) {
            Intent intent = new Intent(this, StaticFragmentActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_5) {
            Intent intent = new Intent(this, DynamicFragmentActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_6) {
            Intent intent = new Intent(this, BroadcastActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_7) {
            Intent intent = new Intent(this, KeywordActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_8) {
            Intent intent = new Intent(this, HandlerActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_9) {
            Intent intent = new Intent(this, ThreadActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(kLogTag, "onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(kLogTag, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(kLogTag, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(kLogTag, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(kLogTag, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(kLogTag, "onDestroy");
    }
}