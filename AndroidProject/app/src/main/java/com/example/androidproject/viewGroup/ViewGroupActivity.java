package com.example.androidproject.viewGroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ViewGroupActivity extends AppCompatActivity implements View.OnClickListener {

    private Button lineLayout, tableLayout, gridLayout, frameLayout, absoluteLayout, relativeLayout;
    private Button percentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);

        lineLayout = findViewById(R.id.btn_1);
        tableLayout = findViewById(R.id.btn_2);
        frameLayout = findViewById(R.id.btn_3);
        gridLayout  = findViewById(R.id.btn_4);
        absoluteLayout = findViewById(R.id.btn_5);
        relativeLayout = findViewById(R.id.btn_6);
        percentLayout  = findViewById(R.id.btn_7);

        lineLayout.setOnClickListener(this);
        tableLayout.setOnClickListener(this);
        frameLayout.setOnClickListener(this);
        gridLayout.setOnClickListener(this);
        absoluteLayout.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
        percentLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == lineLayout) {
            Intent intent = new Intent(this, LineLayoutActivity.class);
            startActivity(intent);
        }else if (v == tableLayout) {
            Intent intent = new Intent(this, TableLayoutActivity.class);
            startActivity(intent);
        }else if (v == frameLayout) {
            Intent intent = new Intent(this, FrameLayoutActivity.class);
            startActivity(intent);
        }else if (v == gridLayout) {
            Intent intent = new Intent(this, GridLayoutActivity.class);
            startActivity(intent);
        }else if (v == absoluteLayout) {
            Intent intent = new Intent(this, AbsoluteLayoutActivity.class);
            startActivity(intent);
        }else  if(v == relativeLayout) {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            startActivity(intent);
        }else  if(v == percentLayout) {
            Intent intent = new Intent(this, PercentLayoutActivity.class);
            startActivity(intent);
        }
    }
}