package com.example.androidproject.systermKnowledge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;
import com.example.androidproject.systermKnowledge.broadcast.BroadcastActivity;
import com.example.androidproject.systermKnowledge.configuration.ConfigurationActivity;
import com.example.androidproject.systermKnowledge.contentProvider.ContentProviderActivity;
import com.example.androidproject.systermKnowledge.fileSave.FileActivity;
import com.example.androidproject.systermKnowledge.fragment.DynamicFragmentActivity;
import com.example.androidproject.systermKnowledge.fragment.StaticFragmentActivity;
import com.example.androidproject.systermKnowledge.gesture.GestureActivity;
import com.example.androidproject.systermKnowledge.handler.HandlerActivity;
import com.example.androidproject.systermKnowledge.http.HttpActivity;
import com.example.androidproject.systermKnowledge.intent.IntentActivity;
import com.example.androidproject.systermKnowledge.intent.LaunchModeActivity;
import com.example.androidproject.systermKnowledge.intent.LifeRecycleActivity;
import com.example.androidproject.systermKnowledge.json.JsonActivity;
import com.example.androidproject.systermKnowledge.keyword.KeywordActivity;
import com.example.androidproject.systermKnowledge.service.ServiceActivity;
import com.example.androidproject.systermKnowledge.sharePreferences.SharePreferencesActivity;
import com.example.androidproject.systermKnowledge.sqlite.SqliteActivity;
import com.example.androidproject.systermKnowledge.thread.ThreadActivity;
import com.example.androidproject.systermKnowledge.xml.XmlActivity;

public class SystemKnowledgeActivity extends AppCompatActivity implements View.OnClickListener {

    private String kLogTag = "SystemKnowledgeActivity";

    private Button intent, lifeRecycle, launchMode;
    private Button staticFragment, dynamicFragment;
    private Button broadcast;
    private Button keyword;
    private Button handler;
    private Button thread;
    private Button gesture;
    private Button configuration;
    private Button service;
    private Button contentProvider;
    private Button file;
    private Button sharePreferences;
    private Button sqlite;
    private Button http;
    private Button xml;
    private Button json;


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

        gesture = findViewById(R.id.btn_10);
        gesture.setOnClickListener(this);

        configuration = findViewById(R.id.btn_11);
        configuration.setOnClickListener(this);

        service = findViewById(R.id.btn_12);
        service.setOnClickListener(this);

        contentProvider = findViewById(R.id.btn_13);
        contentProvider.setOnClickListener(this);

        file = findViewById(R.id.btn_14);
        file.setOnClickListener(this);

        sharePreferences = findViewById(R.id.btn_15);
        sharePreferences.setOnClickListener(this);

        sqlite = findViewById(R.id.btn_16);
        sqlite.setOnClickListener(this);

        http = findViewById(R.id.btn_17);
        http.setOnClickListener(this);

        xml = findViewById(R.id.btn_18);
        xml.setOnClickListener(this);

        json = findViewById(R.id.btn_19);
        json.setOnClickListener(this);
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
        }else if(v.getId() == R.id.btn_10) {
            Intent intent = new Intent(this, GestureActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_11) {
            Intent intent = new Intent(this, ConfigurationActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_12) {
            Intent intent = new Intent(this, ServiceActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_13) {
            Intent intent = new Intent(this, ContentProviderActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_14) {
            Intent intent = new Intent(this, FileActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_15) {
            Intent intent = new Intent(this, SharePreferencesActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_16) {
            Intent intent = new Intent(this, SqliteActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_17) {
            Intent intent = new Intent(this, HttpActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_18) {
            Intent intent = new Intent(this, XmlActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_19) {
            Intent intent = new Intent(this, JsonActivity.class);
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