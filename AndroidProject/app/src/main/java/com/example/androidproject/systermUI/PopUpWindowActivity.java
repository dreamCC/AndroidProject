package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class PopUpWindowActivity extends AppCompatActivity {

    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

        btn1 = findViewById(R.id.btn_1);

    }


    public void showPopUpWindow(View view) {

        View contentV = View.inflate(this, R.layout.pop_up_window, null);
        Button btn1 = contentV.findViewById(R.id.btn_1);
        Button btn2 = contentV.findViewById(R.id.btn_2);

        final PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(contentV);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.showAsDropDown(view);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopUpWindowActivity.this, "第一个按钮点击", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);
    }
}