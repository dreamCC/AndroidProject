package com.example.androidproject;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.animation.AnimationActivity;
import com.example.androidproject.drawable.DrawableActivity;
import com.example.androidproject.listView.ListViewMainActivity;
import com.example.androidproject.paint.PaintActivity;
import com.example.androidproject.systermKnowledge.SystemKnowledgeActivity;
import com.example.androidproject.systermUI.SystemUIActivity;
import com.example.androidproject.viewGroup.ViewGroupActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private String kLogTag = "kLogTag";
    private Button systemUi, viewGroup, systemKnowledge;
    private Button listView;
    private Button drawable;
    private Button animation;
    private Button paint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Application application = getApplication();
        Log.i(kLogTag, "application == " + application);
        Context applicationCtx = getApplicationContext();
        Log.i(kLogTag, "applicationCtx == " + applicationCtx);
        Context baseCtx = getBaseContext();
        Log.i(kLogTag, "baseCtx == " + baseCtx);


        systemUi = findViewById(R.id.system_ui);
        systemUi.setOnClickListener(this);

        viewGroup = findViewById(R.id.view_group);
        viewGroup.setOnClickListener(this);

        systemKnowledge = findViewById(R.id.system_knowledge);
        systemKnowledge.setOnClickListener(this);

        listView = findViewById(R.id.list_view);
        listView.setOnClickListener(this);

        drawable = findViewById(R.id.drawable);
        drawable.setOnClickListener(this);

        animation = findViewById(R.id.animation);
        animation.setOnClickListener(this);

        paint = findViewById(R.id.paint);
        paint.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == systemUi) {
            Intent intent = new Intent(HomeActivity.this, SystemUIActivity.class);
            startActivity(intent);
        } else if (v == viewGroup) {
            Intent intent = new Intent(this, ViewGroupActivity.class);
            startActivity(intent);
        } else if (v == systemKnowledge) {
            Intent intent = new Intent(this, SystemKnowledgeActivity.class);
            startActivity(intent);
        } else if (v == listView) {
            Intent intent = new Intent(this, ListViewMainActivity.class);
            startActivity(intent);
        } else if (v == drawable) {
            Intent intent = new Intent(this, DrawableActivity.class);
            startActivity(intent);
        } else if (v == animation) {
            Intent intent = new Intent(this, AnimationActivity.class);
            startActivity(intent);
        } else if (v == paint) {
            Intent intent = new Intent(this, PaintActivity.class);
            startActivity(intent);
        }
    }
}

