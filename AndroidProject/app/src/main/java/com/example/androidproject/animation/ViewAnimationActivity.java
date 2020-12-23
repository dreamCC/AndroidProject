
package com.example.androidproject.animation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "ViewAnimationActivity";
    private View animationV;
    private Button scale, translate, rotation, alpha, set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);


        animationV = findViewById(R.id.v_animation);
        scale = findViewById(R.id.btn_scale);
        translate = findViewById(R.id.btn_translate);
        rotation = findViewById(R.id.btn_rotation);
        alpha = findViewById(R.id.btn_alpha);
        set = findViewById(R.id.btn_set);

        scale.setOnClickListener(this);
        translate.setOnClickListener(this);
        rotation.setOnClickListener(this);
        alpha.setOnClickListener(this);
        set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_scale:
                scaleBtnClick();
                break;
            case R.id.btn_rotation:
                rotationBtnClick();
                break;
            case R.id.btn_alpha:
                alphaBtnClick();
                break;
            case R.id.btn_translate:
                transitionBtnClick();
                break;
            case R.id.btn_set:
                setBtnClick();
                break;
        }
    }

    private void scaleBtnClick() {

        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0, 1, 0);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatMode(Animation.REVERSE);

        Animation xmlScaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        xmlScaleAnimation.setDuration(1000);
        xmlScaleAnimation.setRepeatCount(-1);
        animationV.startAnimation(xmlScaleAnimation);
    }

    private void transitionBtnClick() {

        Log.i(TAG, "--transitionBtnClick");

        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,0);
        translateAnimation.setDuration(1000);
        // 如果传-1，就是默认Animation.INFINITE
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(Animation.REVERSE);

        TranslateAnimation xmlTranslateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this, R.anim.translate);
        xmlTranslateAnimation.setDuration(1000);
        xmlTranslateAnimation.setRepeatMode(1);
        xmlTranslateAnimation.setFillAfter(true);
        animationV.startAnimation(xmlTranslateAnimation);
        //animationV.startAnimation(translateAnimation);
    }

    private void rotationBtnClick() {

        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, 0.5f, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(this, android.R.interpolator.linear);

        Animation xmlRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        xmlRotateAnimation.setDuration(1000);
        xmlRotateAnimation.setRepeatCount(-1);
        animationV.startAnimation(rotateAnimation);

    }

    private void alphaBtnClick() {

    }

    private void setBtnClick() {

    }
}