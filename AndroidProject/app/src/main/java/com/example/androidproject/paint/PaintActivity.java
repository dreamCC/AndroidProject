package com.example.androidproject.paint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.androidproject.R;

public class PaintActivity extends AppCompatActivity {

    private String TAG = "PaintActivity";
    private ConstraintLayout contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentView = (ConstraintLayout) View.inflate(this, R.layout.activity_paint, null);
        setContentView(contentView);

        View rootV =  getWindow().getDecorView().getRootView();
        Log.i(TAG, "" + rootV);
        didInitializeSubViews();

    }

    private void didInitializeSubViews() {

        PaintView paintView = new PaintView(this);

        contentView.addView(paintView);
    }
}