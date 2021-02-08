package com.example.androidproject.java.String;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class StringActivity extends AppCompatActivity {

    private String TAG = "StringActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        // 构造方法
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String str = new String(chars);

        // 类方法，内部实现更多
        String str2 =  String.valueOf(12);

        // 获取
        char sChar = str.charAt(1);
        String subStr = str2.substring(1);

        // 转换
        String convertStr = subStr.toLowerCase();

        // 边角
        boolean isEq = convertStr.contains("he");
        boolean isEq2 = convertStr == subStr;
        boolean isEq3 = convertStr.isEmpty();

        // int转字符串，直接可以通过 xx + "" 就可以。因为 "" 就包含了转换功能。

        // 转换。如果没有被替换的字符串，则打印原来字符串。
        String replace = convertStr.replace('a', 'b');


    }


    void testStringBuffer() {

        // 线程安全。-
        StringBuffer buffer = new StringBuffer();

        // 常用方法。
        buffer.capacity(); // 容量
        buffer.length(); // 长度

        // 添加。一般不需要接受返回值
        buffer.append("hello, world");

        buffer.insert(1, "world");

        // 删除
        buffer.delete(1, 2);
        buffer.deleteCharAt(1);

        // 替换
        buffer.replace(1, 2, "");

        // 截取
        buffer.substring(1);

    }


    void testStringBuilder() {

        StringBuilder sb = new StringBuilder();

    }
}