package com.example.androidproject.drawable;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class DrawableActivity extends AppCompatActivity {

    private View tView;
    private ImageView imageView;
    private String TAG = "DrawableActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        tView = findViewById(R.id.view);
        imageView = findViewById(R.id.imageV);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void colorDrawable(View view) {

        // 颜色。类似ios中，UIColor。
        // 但是。android中设置颜色的方式很多。不想ios只能通过UIColor进行设置。
        // 1、通过ColorDrawable。
        // 2、直接在xml中 backgroundColor = "#ffff2200"
        // 3、在values中，创建colors.xml。 其内容主要是<resources> <color> <color> <resources>。主要是resources标签添加color标签
        //   然后在xml中通过@color来进行引用。
        // 4、通过Color对象来创建。
        ColorDrawable colorDrawable = new ColorDrawable(0xffff2200);
        tView.setBackground(colorDrawable);

        // 使用系统颜色。
        // ios通过,UIColor.white获取。
        // android 麻烦一些。
        // 1、代码
        // 2、android:background="@android:color/black"
        int sysColorDrawable = Resources.getSystem().getColor(android.R.color.black, null);
        int sysC = getResources().getColor(android.R.color.holo_blue_bright, null);
        tView.setBackgroundColor(sysC);

        // 可以通过Color类来进行颜色赋值。
        // 支持 Color.parseColor("#123456")。其中可以是#123456 #ff123456
        // 也可以直接使用16进制。0xff123456
        // Color.rgb通过rgb来进行赋值。
        //tView.setBackgroundColor(Color.parseColor("#123456"));
        tView.setBackgroundColor(0xff123456);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void shapeDrawable(View  view) {
        // 可以通过编写drawable.xml来控制。
        // <shape> <shape> 标签来实现。
        // 2、编写代码。

        // 通过getResources().getDrawable来获取。
        Drawable shapeDrawable = getResources().getDrawable(R.drawable.shape, null);
        tView.setBackground(shapeDrawable);

        // 我们也可以直接构造ShapeDrawable。
        ShapeDrawable jShapeDrawable = new ShapeDrawable();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void bitmapDrawable(View view) {
        // 通过xml。<bitmap> 标签定义
        Drawable bitmapDrawable = getResources().getDrawable(R.drawable.bitmap, null);
        tView.setBackground(bitmapDrawable);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void insertDrawable(View view) {

        Drawable inset = getResources().getDrawable(R.drawable.inset, null);
        tView.setBackground(inset);

        InsetDrawable insetDrawable = new InsetDrawable(getDrawable(R.drawable.image0), 15);
        tView.setBackground(insetDrawable);

    }

    public void clipDrawable(View view) {

        // 其中setLevel的取值是0~10000
        ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();
        if (clipDrawable != null) {
            clipDrawable.setLevel(5000);
        }

    }

    public void rotationDrawable(View view) {

        // 其中setLevel的取值是0~10000
        RotateDrawable rotateDrawable = (RotateDrawable) imageView.getDrawable();
        if (rotateDrawable != null) {
            rotateDrawable.setLevel(500);
        }

    }

    public void scaleDrawable(View view) {
        ScaleDrawable scaleDrawable = (ScaleDrawable) imageView.getDrawable();
        if (scaleDrawable != null) {
            scaleDrawable.setLevel(5000);
        }
    }

    public void animationDrawable(View view) {

        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void layerDrawable(View view) {

        // 通过layer-list标签进行赋值
    }

    public void transitionDrawable(View view) {

        TransitionDrawable transitionDrawable = (TransitionDrawable) imageView.getDrawable();
        if (transitionDrawable != null) {
            transitionDrawable.startTransition(1000);
        }
    }

    public void levelListDrawable(View view) {

        LevelListDrawable levelListDrawable = (LevelListDrawable) imageView.getDrawable();
        if (levelListDrawable != null) {
            levelListDrawable.setLevel(4000);
        }
    }

    // stateList 主要是对应节点是<selector>标签的。
    public void stateListDrawable(View view) {

        StateListDrawable stateListDrawable = (StateListDrawable) imageView.getDrawable();

    }
}