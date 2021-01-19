package com.example.androidproject.paint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;
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

        ContentFrameLayout sub = getWindow().getDecorView().findViewById(android.R.id.content);
        Log.i(TAG, contentView.toString());
        Log.i(TAG, sub.toString());



    }

    private void didInitializeSubViews() {

        int di = (int) getResources().getDisplayMetrics().density;
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(
                200*di,
                200*di);
        lp.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        lp.topMargin = 100;
        lp.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        lp.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        PaintView paintView = new PaintView(this);
        paintView.setLayoutParams(lp);
        contentView.addView(paintView);

    }
}