package com.example.androidproject.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class KeyFrameAnimationActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dawable_animation);

        didInitialize();
    }

    private void didInitialize() {
        // 一般通过AnimationDrawable来实现。相应的标签，animation-list
        imageView = findViewById(R.id.iv_1);

        // 可以通过代码、或者xml创建
        //animationDrawable = (AnimationDrawable) getDrawable(R.drawable.animation_list);
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getDrawable(R.drawable.image0), 1000);
        animationDrawable.addFrame(getDrawable(R.drawable.image1), 1000);

        imageView.setImageDrawable(animationDrawable);
        //imageView.setBackground(animationDrawable);
    }

    public void startAnimation(View view) {

        animationDrawable.start();
    }

    public void stopAnimation(View view) {
        animationDrawable.stop();
    }
}