
package com.example.androidproject.animation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

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
        // 默认pivotX = 0, pivotY = 0。而且表示的是绝对距离
        //RotateAnimation rotateAnimation = new RotateAnimation(0, 180);
        // 这种方式创建的pivotX和pivotY表示的轴距是绝对距离。 注意这里的绝对距离表示的是像素
        float scale = getResources().getDisplayMetrics().density;
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 50.f * scale, 50.f * scale);
        // 这种创建的方式是相对距离。Animation.ABSOLUTE 表示绝地轴距，其他的是相对轴距。
//        RotateAnimation rotateAnimation = new RotateAnimation(
//                0, 360,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);

        // 这两种写法是一样的效果
        rotateAnimation.setInterpolator(this, android.R.interpolator.linear);
        rotateAnimation.setInterpolator(new LinearInterpolator());

        Animation xmlRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        xmlRotateAnimation.setDuration(1000);
        xmlRotateAnimation.setRepeatCount(-1);
        animationV.startAnimation(rotateAnimation);

    }

    private void alphaBtnClick() {

        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(-1);

        Animation xmlAlphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        xmlAlphaAnimation.setDuration(1000);
        xmlAlphaAnimation.setRepeatCount(-1);
        xmlAlphaAnimation.setRepeatMode(Animation.REVERSE);
        animationV.startAnimation(xmlAlphaAnimation);
    }

    private void setBtnClick() {

        TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0f,
                Animation.RELATIVE_TO_PARENT,0.5f,
                Animation.RELATIVE_TO_PARENT,0f,
                Animation.RELATIVE_TO_PARENT,0f);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatCount(-1);

        RotateAnimation rotateAnimation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setDuration(3000);

        ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,0.5f,1.0f,0.5f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setRepeatCount(-1);

        final AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setDuration(3000);


        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(1000);

        Animation xmlSetAnimation = AnimationUtils.loadAnimation(this, R.anim.set);
        xmlSetAnimation.setRepeatCount(-1);
        animationV.startAnimation(xmlSetAnimation);

    }
}