package com.example.androidproject.java.条件语句;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ConditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);


        // switch（） 里面的表示可以是： byte、short、char、int，只要能自动转换成int 类型的都可以。
        // enmu 和 String。这几种。


        // 数组的初始化有两种方式，动态创建和静态创建。数组的一个特点就长度固定，当我们声明完一个数组后，其长度就已经确定了。
        int[] ary = new int[5];
        ary[0] = 1;


        int[]  ary2 = {2, 3};
        ary2[0] = 10;
    }
}