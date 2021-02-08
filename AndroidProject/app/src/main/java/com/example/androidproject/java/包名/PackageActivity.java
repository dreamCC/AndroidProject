package com.example.androidproject.java.包名;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;
import com.example.androidproject.java.基础数据类型.PackageClass;



public class PackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        PackageClass packageClass = new PackageClass();


    }
}