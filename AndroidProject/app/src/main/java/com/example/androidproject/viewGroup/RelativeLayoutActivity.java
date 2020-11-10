package com.example.androidproject.viewGroup;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class RelativeLayoutActivity extends AppCompatActivity {

//    RelativeLayout，相对布局现在用的比较少。需要注意几个属性:
//    根据父容器：
//        layout_alignParent-xxx 相对于父容器上、下、左、右对齐。
//        layout_center-xxx 相对于父容器水平居中、垂直居中、整体居中。
//
//    根据兄弟组件：
//        layout_toLeftOf 参考左边
//        layout_toRightOf 参考右边
//        layout_above     上边
//        layout_below     下边
//        layout_align-xx  xx方向对齐

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        Log.i("tag",  "-" + this);
        Log.i("tag",  "-" + RelativeLayoutActivity.this);

    }
}