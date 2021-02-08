package com.example.androidproject.java.常见类;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        this.hashCode();
    }
}