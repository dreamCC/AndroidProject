package com.example.androidproject.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class PropertyAnimationActivity extends AppCompatActivity {

    private String TAG = "PropertyAnimationActivity";

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        textView = findViewById(R.id.tv_1);
    }

    public void valueAnimator(View view) {
        // ValueAnimator可以直接对任意数值进行平滑过渡。并且我们是可以获取其中的值的。
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 5, 10);
        valueAnimator.setDuration(3000);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, animation.getAnimatedValue().toString());
            }
        });
    }

    public void objectAnimator_alpha(View view) {

        // ObjectAnimator 是我们开发中使用最多的对象。
        // ObjectAnimator继承自ValueAnimator。底层也是通过ValueAnimator实现的。
        // 其核心原理就是找到textView的setPropertyName方法，进行赋值。
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 1, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        //objectAnimator.start();

        // 通过xml添加动画。创建文件夹animator，同时该文件有是那种标签<animator> <objectAnimator> <set>
        ObjectAnimator xmlAlpha = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator_alpha);
        xmlAlpha.setTarget(textView);
        xmlAlpha.start();

    }

    public void objectAnimator_rotation(View view) {

        // ObjectAnimator 是我们开发中使用最多的对象。
        // ObjectAnimator继承自ValueAnimator。底层也是通过ValueAnimator实现的。
        // 其核心原理就是找到textView的setPropertyName方法，进行赋值。
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "rotation", 0, 360);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.start();


    }

    public void objectAnimator_scale(View view) {

        // ObjectAnimator 是我们开发中使用最多的对象。
        // ObjectAnimator继承自ValueAnimator。底层也是通过ValueAnimator实现的。
        // 其核心原理就是找到textView的setPropertyName方法，进行赋值。
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "scaleX", 1, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.start();

    }

    public void objectAnimator_translateX(View view) {

        // ObjectAnimator 是我们开发中使用最多的对象。
        // ObjectAnimator继承自ValueAnimator。底层也是通过ValueAnimator实现的。
        // 其核心原理就是找到textView的setPropertyName方法，进行赋值。
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "translationX", 0, 200);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.start();

    }

    public void objectAnimator_set(View view) {

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(textView, "scaleX", 1,0);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(textView, "scaleY", 1, 0);
        ObjectAnimator alpha  = ObjectAnimator.ofFloat(textView, "alpha", 1,0);
        scaleX.setRepeatCount(-1);
        scaleY.setRepeatCount(-1);
        alpha.setRepeatCount(-1);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleX)
                .with(scaleY)
                .with(alpha);
        animatorSet.setDuration(2000);
        //animatorSet.start();

        AnimatorSet xmlAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.set);
        xmlAnimatorSet.setTarget(textView);
        xmlAnimatorSet.start();


    }
}