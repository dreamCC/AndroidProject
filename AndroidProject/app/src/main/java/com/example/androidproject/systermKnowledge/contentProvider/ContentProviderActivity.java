package com.example.androidproject.systermKnowledge.contentProvider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class ContentProviderActivity extends AppCompatActivity {

    private final String TAG = "ContentProviderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        Button smsBtn = findViewById(R.id.btn_1);
        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSms();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContacts();
            }
        });
    }

    private void getSms() {
        Uri smsUri = Uri.parse("content://sms/");
        ContentResolver contentResolver = getContentResolver();
        String[] projection = new String[]{"address","date","type","body"};
        Cursor cursor = contentResolver.query(smsUri, projection, null, null, null);
        while (cursor.moveToNext()) {
            String address = cursor.getString(0);
            String date = cursor.getString(1);
            String type = cursor.getString(2);
            String body = cursor.getString(3);
            System.out.println("地址:" + address);
            System.out.println("时间:" + date);
            System.out.println("类型:" + type);
            System.out.println("内容:" + body);
            System.out.println("======================");
        }
        cursor.close();
    }

    private void getContacts() {

        ContentResolver resolver = getContentResolver();
        Uri contacts = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = resolver.query(contacts, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.i(TAG, "姓名：" + name);
            Log.i(TAG, "手机号：" + number);
            Log.i(TAG, "=================");
        }
        cursor.close();
    }
}