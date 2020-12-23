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

    // 补间动画
    public void tweenAnimation(View view) {

        Intent intent = new Intent(this, TweenAnimationActivity.class);
        startActivity(intent);
    }

    // 帧动画
    public void keyFrameAnimation(View view) {

        Intent intent = new Intent(this, KeyFrameAnimationActivity.class);
        startActivity(intent);
    }

    // 属性动画
    public void propertyAnimation(View view) {

        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);
    }
}