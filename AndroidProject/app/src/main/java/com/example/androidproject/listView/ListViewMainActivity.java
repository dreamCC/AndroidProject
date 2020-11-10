package com.example.androidproject.listView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ListViewMainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button listView;
    private Button gridView;
    private Button recycleView;
    private Button horizonRecycleView;
    private Button gridRecycleView;
    private Button staggerRecycleView;
    private Button materialRecycleView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);

        listView = findViewById(R.id.btn_1);
        listView.setOnClickListener(this);

        gridView = findViewById(R.id.btn_2);
        gridView.setOnClickListener(this);

        recycleView = findViewById(R.id.btn_3);
        recycleView.setOnClickListener(this);

        horizonRecycleView = findViewById(R.id.btn_4);
        horizonRecycleView.setOnClickListener(this);

        gridRecycleView = findViewById(R.id.btn_5);
        gridRecycleView.setOnClickListener(this);

        staggerRecycleView = findViewById(R.id.btn_6);
        staggerRecycleView.setOnClickListener(this);

        materialRecycleView = findViewById(R.id.btn_7);
        materialRecycleView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == listView) {
            Intent intent = new Intent(this, ListViewActivity.class);
            startActivity(intent);
        }else if(v == gridView) {

            Intent intent = new Intent();
            intent.setClass(this, GridViewActivity.class);
            startActivity(intent);
        }else if(v == recycleView) {

            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        }else if(v == horizonRecycleView) {

            Intent intent = new Intent(this, HorizonRecyclerViewActivity.class);
            startActivity(intent);
        }else if(v == gridRecycleView) {

            Intent intent = new Intent(this, GridRecyclerViewActivity.class);
            startActivity(intent);
        }else if(v == staggerRecycleView) {

            Intent intent = new Intent(this, StaggerRecyclerViewActivity.class);
            startActivity(intent);
        }else if(v == materialRecycleView) {

            Intent intent = new Intent(this, MaterialRecyclerViewActivity.class);
            startActivity(intent);
        }
    }


}