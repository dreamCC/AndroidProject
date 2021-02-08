package com.example.androidproject.java.内部类;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

interface Inter {

    void interMethod();
}

public class InnerClassActivity extends AppCompatActivity {

    // 有名内部类
    class HasNameInner implements Inter {

        @Override
        public void interMethod() {

        }
    }

    int age = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_class2);



        final int jAge = 20;
        // 局部内部类
        class MethodClass {

            void method() {
                int b = age;
                int c = jAge;
            }
        }

        // 有名内部类的使用。
        HasNameInner hasNameInner = new HasNameInner();
        hasNameInner.interMethod();

        // 匿名内部类。
        /*
        * new 接口或者类名() {
        *   需要重写方法。
        * }
        *
        * */
        new Inter(){
            @Override
            public void interMethod() {

            }
        }.interMethod();

        // 这种写法也是匿名内部类。
        new ICls(){

            @Override
            void method() {
                super.method();

            }
        }.method();
    }

    // 静态内部类
   static class InnerCls {

        void method() {

            // 内部类访问外部类。
            // 静态内部类要访问外部类，需要先获取外部类对象，然后进行调用。

            // 所以swift中的内部类，很像java中的静态内部类，但是不能添加static关键字。
            // 在swift的内部类，是有明显的界限的。

        }
    }

    // 成员内部类
    class ICls {

        void method() {

        }
    }
}