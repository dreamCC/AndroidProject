package com.example.androidproject.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


/*
* android 中自定义View，显得有点呆😳。
* */
public class PaintView extends View {

    // 需要一个画笔。
    private Paint mPaint;
    public PaintView(Context context) {
        super(context);
        didInitialize();

    }

    // 自定义View，需要重写该方法。
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置画布颜色
        canvas.drawColor(Color.LTGRAY);
        canvas.drawCircle(200, 200, 50, mPaint);
    }

    /// private method
    private void didInitialize() {

        // 对画笔进行一些操作。
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }



}
