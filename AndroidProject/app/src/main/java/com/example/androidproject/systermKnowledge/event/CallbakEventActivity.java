package com.example.androidproject.systermKnowledge.event;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.androidproject.R;

public class CallbakEventActivity extends AppCompatActivity {

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

    public class MyButton extends AppCompatButton {

        public MyButton(Context context) {
            super(context);
        }

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
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
    }
}

