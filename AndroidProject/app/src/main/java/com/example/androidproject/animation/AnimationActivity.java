package com.example.androidproject.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

    }

    // 视图动画
    public void viewAnimation(View view) {

        Intent intent = new Intent(this, ViewAnimationActivity.class);
        startActivity(intent);
    }

    // 帧动画
    public void drawableAnimation(View view) {

        Intent intent = new Intent(this, DrawableAnimationActivity.class);
        startActivity(intent);
    }

    // 属性动画
    public void propertyAnimation(View view) {

        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);
    }
}