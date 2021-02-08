package com.example.androidproject.java.基础数据类型;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class BasicTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_type);

        int a = 123;

        // long类型一般使用L进行结尾，因为默认编译器会将赋值的视为int类型，所以如果数据过大就会报错。
        long longType = 123456789L;

        // float类型，默认后面需要加f，因为默认是double类型。
        float floatType = 12.3f;

        // 如果一个小数进行赋值，那么double类型肯定是可以的。 其实计算机是没有办法准确的表示一个小数的。
        // 后面的d是可以省略的。
        double doubleType = 12.3d;

        // 隐式转换。
        int i = 100;
        byte b = 90;
        // 该运行过程，会先将b转换成int类型，然后与i进行运算。
        i = i + b;

        // 这种就会报错，因为i + b，会将b转换成int类型，然后进行计算，其结果为int类型。 int类型转byte类型会报错。
        //b = i + b;

        double d1 = 12.3;
        int c1 = 12;
        // 同样会报错，因为double不能转int。
        //c1 = c1 + d1;
        // 可以使用强制转换符进行转换。
        c1 = (int)(c1 + d1);

        // byte、int、short、long。可以想上转换。
        // float、double。可以想上转换。

        // 高精度转低精度会损失精度。使用的是强制类型转换。
        // 低精度转高精度，会进行自动类型转换，也是隐式转换。

        byte b1, b2, b3;
        b1 = 3;
        b2 = 4;
        // 会报错的主要原因，b1和b2是变量，编译器无法判断具体类型，会将其转换为int类型。 然后int类型的数赋值到byte会报错。
        // b3 = b1 + b2;
        b3 = (byte) (b1 + b2);

        // 不会报错，因为java有常量优化机制， 直接将结果当成7赋值过去了。
        b3 = 3 + 4;

        // 关于 'a' + 1 = 98的原因，是因为char类型与int类型进行运算，会先将char类型转int类型，然后进行计算。

        // 字符串 "" + 任意数据都会产生新的字符串。

    }
}