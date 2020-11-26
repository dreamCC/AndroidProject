package com.example.androidproject.systermKnowledge.InnerClass;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;


/*
* java内部类。
* 1、成员内部类。
*   成员内部类依附于外部类，只有创建将领外部类，才能创建内部类。
*   MemberInnerClass m = this.new MemberInnerClass();
*   和swift语言相比，swift中也有内部类，但是相当于java中的静态内部类。比如：
*   class Father {
*
*       class InnerClass {
*
*        }
*   }
*   let innerCls = Father.InnerClass() // 通过这种方式进行初始化。
*
*   swift中的内部类，其实就是成员内部类，是可以直接使用外部类中的成员属性和方法的。但是其初始化方式进行了优化。其构造方法确像静态内部类的方法。
*   而且其内部不能使用外部类的属性和方法。
*
* 2、静态内部类。
*   静态内部类和成员内部类。成员内部类在编译完成后有一个隐式引用，这个引用指向创建好的外部类。而静态内部类没有。这就意味着：
*   1、静态内部类的创建不需要依赖外部类可以直接创建。
*   2、静态内部类不可以直接使用外部类中非static的属性和方法。****这点很重要。
*   oc和dart是没有内部类的。
*
* 3、方法内部类，在方法内部创建类。不常用。
*
* 4、匿名内部类。一般配合interface使用。
*
* */
public class InnerClassActivity extends AppCompatActivity {

    private String value;

    // 成员内部类
    class MemberInnerClass {

        void func() {

            Log.i("MemberInnerClass", value);

        }
    }

    // 静态内部类
    static class StaticInnerClass {

        void func() {

            // 这种写法会报错。
           // Log.i("StaticInnerClass", value);

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_class);

    }
}