package com.example.androidproject.paint;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.androidproject.R;

public class PaintActivity extends AppCompatActivity {


    private ConstraintLayout contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentView = (ConstraintLayout) View.inflate(this, R.layout.activity_paint, null);
        setContentView(contentView);

        didInitializeSubViews();
    }

    private void didInitializeSubViews() {

        PaintView paintView = new PaintView(this);

        contentView.addView(paintView);
    }
}