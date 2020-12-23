package com.example.androidproject.systermUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class SystemUIActivity extends AppCompatActivity implements View.OnClickListener {


    private Button toastBtn;
    private Button editText;
    private Button textView;
    private Button button;
    private Button imageView;
    private Button radioButton;
    private Button checkBox;
    private Button toggleButton;
    private Button switchBtn;
    private Button progressBar;
    private Button dateTime;
    private Button dateTime2;
    private Button alertDialog;
    private Button popUpWindow;
    private Button menu;
    private Button listView;
    private Button gridView;
    private Button webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_ui);

        toastBtn = findViewById(R.id.btn_1);
        toastBtn.setOnClickListener(new  NormalBtnClick());

        editText = findViewById(R.id.btn_2);
        editText.setOnClickListener(this);

        textView = findViewById(R.id.btn_3);
        textView.setOnClickListener(this);

        button = findViewById(R.id.btn_4);
        button.setOnClickListener(this);

        imageView = findViewById(R.id.btn_5);
        imageView.setOnClickListener(this);

        radioButton = findViewById(R.id.btn_6);
        radioButton.setOnClickListener(this);

        checkBox = findViewById(R.id.btn_7);
        checkBox.setOnClickListener(this);

        toggleButton = findViewById(R.id.btn_8);
        toggleButton.setOnClickListener(this);

        switchBtn = findViewById(R.id.btn_9);
        switchBtn.setOnClickListener(this);

        progressBar = findViewById(R.id.btn_10);
        progressBar.setOnClickListener(this);

        dateTime = findViewById(R.id.btn_11);
        dateTime.setOnClickListener(this);

        dateTime2 = findViewById(R.id.btn_12);
        dateTime2.setOnClickListener(this);

        alertDialog = findViewById(R.id.btn_13);
        alertDialog.setOnClickListener(this);

        popUpWindow = findViewById(R.id.btn_14);
        popUpWindow.setOnClickListener(this);

        menu = findViewById(R.id.btn_15);
        menu.setOnClickListener(this);

        listView = findViewById(R.id.btn_16);
        listView.setOnClickListener(this);

        gridView = findViewById(R.id.btn_17);
        gridView.setOnClickListener(this);

        webView = findViewById(R.id.btn_18);
        webView.setOnClickListener(this);
    }

    // 点击事件
    @Override
    public void onClick(View v) {

        if(v == toastBtn) {
            Intent intent = new Intent(this, ToastActivity.class);
            startActivity(intent);
        }else if(v == editText) {
            Intent intent = new Intent(this, EditTextActivity.class);
            startActivity(intent);
        }else if(v == textView) {
            Intent intent = new Intent(this, TextViewActivity.class);
            startActivity(intent);
        }else if(v == button) {
            Intent intent = new Intent(this, ButtonActivity.class);
            startActivity(intent);
        }else if(v == imageView) {
            Intent intent = new Intent(this, ImageViewActivity.class);
            startActivity(intent);
        }else if(v == radioButton) {
            Intent intent = new Intent(this, RadioButtonActivity.class);
            startActivity(intent);
        }else if(v == checkBox) {
            Intent intent = new Intent(this, CheckBoxActivity.class);
            startActivity(intent);
        }else if(v == toggleButton) {
            Intent intent = new Intent(this, ToggleButtonActivity.class);
            startActivity(intent);
        }else if(v == switchBtn) {
            Intent intent = new Intent(this, SwitchActivity.class);
            startActivity(intent);
        }else if(v == progressBar) {
            Intent intent = new Intent(this, ProgressBarActivity.class);
            startActivity(intent);
        }else if(v == dateTime) {
            Intent intent = new Intent(this, DateTimeActivity.class);
            startActivity(intent);
        }else if(v == dateTime2) {
            Intent intent = new Intent(this, DateTime2Activity.class);
            startActivity(intent);
        }else if(v == alertDialog) {
            Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        }else if(v == alertDialog) {
            Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        }else if(v == popUpWindow) {
            Intent intent = new Intent(this, PopUpWindowActivity.class);
            startActivity(intent);
        }else if(v == menu) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }else if(v == listView) {

        }else if(v == gridView) {

        }else if(v == webView) {
            Intent intent = new Intent(this, WebViewActivity.class);
            startActivity(intent);
        }

    }

    // 内部类
    private class NormalBtnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(SystemUIActivity.this, ToastActivity.class);
            startActivity(intent);
        }
    }
}