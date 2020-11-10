package com.example.androidproject.systermKnowledge.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;


public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showIntentBtn, implicitIntentBtn, callBtn, sendBtn, settingBtn, intentExtraBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Log.i("-", this.getPackageName());

        showIntentBtn = findViewById(R.id.btn_1);
        showIntentBtn.setOnClickListener(this);

        implicitIntentBtn = findViewById(R.id.btn_2);
        implicitIntentBtn.setOnClickListener(this);

        callBtn = findViewById(R.id.btn_3);
        callBtn.setOnClickListener(this);

        sendBtn = findViewById(R.id.btn_4);
        sendBtn.setOnClickListener(this);

        settingBtn = findViewById(R.id.btn_5);
        settingBtn.setOnClickListener(this);

        intentExtraBtn = findViewById(R.id.btn_6);
        intentExtraBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == showIntentBtn) {
            showIntent();
        }else if(v == implicitIntentBtn) {
            implicitIntent();
        }else if(v == callBtn) {
            callIntent();
        }else if(v == sendBtn) {
            sendIntent();
        }else if(v == settingBtn) {
            settingIntent();
        }else if(v == intentExtraBtn) {
            intentExtra();
        }
    }

    // 显示Intent。 顾名思义直接指定需要打开的Activity对应的类。
    private void showIntent() {

//        Intent intent = new Intent(this, SystemKnowledgeActivity.class);
//        startActivity(intent);


//        Intent intent1 = new Intent();
//        intent1.setClass(this, SystemKnowledgeActivity.class);
//        startActivity(intent1);

        Intent intent2 = new Intent();
        intent2.setClassName(this,   "SystemKnowledgeActivity");
        startActivity(intent2);

    }

    // 隐式Intent。
    // 隐式顾名思义是不指定Activity，而是通过设置Action、Data、Category，让系统来筛选适合的Activity。
    // 筛选是根据所有的<intent-filter>来进行筛选。
    // 1、在manifest中对Activity进行intent-filter 进行配置。
    //      <action android:name="android.intent.action.Sy1"/>
    //      <category android:name="android.intent.category.DEFAULT"/>
    //
    //      注意必须设置action和category。
    //
    //      Intent有7大属性。Action（动作）、Category（类别）、Data（数据）、Type（数据类型）、
    //      Component（组件）、Extra（扩展信息）、Flag（标志位）。最常用的Action和Data。
    //
    //
    //      Action用来表示动作的意图。系统提供了很多action。
    private void implicitIntent() {

        // 1、
        Intent intent = new Intent();
        intent.setAction("android.intent.action.Sy1");
        startActivity(intent);

        // 2、
        //Intent intent1 = new Intent("android.intent.action.Sy1");
        //startActivity(intent1);

    }

    private void callIntent() {

        // 注意权限的配置。
        Intent intent = new Intent();
        //intent.setAction(Intent.ACTION_CALL);
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17720501596"));
        startActivity(intent);
    }

    private void sendIntent() {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:10010"));
        startActivity(intent);

    }

    private void settingIntent() {
        Intent intent = new Intent();
        intent.setAction("android.settings.SETTINGS");
        startActivity(intent);
    }

    private void intentExtra() {

//        Intent intent = new Intent(this, IntentExtraActivity.class);
//        intent.putExtra("data", "传入参数");
//        startActivity(intent);

        Intent intent = new Intent(this, IntentExtraActivity.class);
        intent.putExtra("data", "传入参数");
        startActivityForResult(intent, 1);
    }

    // 通过该方法进行返回值获取
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            Log.i("One", result);
        }
    }
}


