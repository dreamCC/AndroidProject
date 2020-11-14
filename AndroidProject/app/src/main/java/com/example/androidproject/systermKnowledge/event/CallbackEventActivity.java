package com.example.androidproject.systermKnowledge.event;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.androidproject.R;

/*
* android 中实现事件回调的方式一般通过interface来实现。类似ios中protocol。
* 但是ios中也有别的回调方式，比如闭包、block。类似dart中的函数作为参数。 但是android中很遗憾 没有。
*
* */
public class CallbackEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callbak_event);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.i("CallbakEventActivity", "onTouchEvent");

        return super.onTouchEvent(event);
    }

    public static class MyButton extends AppCompatButton {


        public MyButton(Context context) {
            super(context);
        }

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        // 事件入口
        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            return super.dispatchTouchEvent(event);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i("MyButton", "onTouchEvent---");
                    break;
            }
            return true;
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            return super.onKeyDown(keyCode, event);
        }

    }
}


