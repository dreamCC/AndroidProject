package com.example.androidproject.systermKnowledge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidproject.R;
import com.example.androidproject.systermKnowledge.fragment.MFragmentActivity;
import com.example.androidproject.systermKnowledge.intent.IntentActivity;
import com.example.androidproject.systermKnowledge.intent.LaunchModeActivity;
import com.example.androidproject.systermKnowledge.intent.LifeRecycleActivity;

public class SystemKnowledgeActivity extends AppCompatActivity implements View.OnClickListener {

    private String kLogTag = "SystemKnowledgeActivity";

    private Button intent, lifeRecycle, launchMode;
    private Button fragment;
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

        fragment = findViewById(R.id.btn_4);
        fragment.setOnClickListener(this);
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
        }else if( v == fragment) {
            Intent intent = new Intent(this, MFragmentActivity.class);
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