package com.example.androidproject.systermKnowledge.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.androidproject.R;

public class MFragmentActivity extends AppCompatActivity {


    private Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        AFragment aFragment = new AFragment();

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_1, aFragment).commitAllowingStateLoss();

        checkBtn = findViewById(R.id.btn_1);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BFragment bFragment =  BFragment.newInstance("我的内容checkBtn");
                fragmentTransaction.replace(R.id.fl_1, bFragment);
            }
        });
    }
}