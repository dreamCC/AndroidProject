package com.example.androidproject.systermKnowledge.sharePreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import java.util.HashMap;

public class SharePreferencesActivity extends AppCompatActivity {

    private String TAG = "SharePreferencesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);


    }

    public void startSave(View view) {
        SharedPreferences sp = getSharedPreferences("mySp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName", "David");
        editor.putBoolean("Sex", true);
        editor.commit();
    }

    public void startRead(View view) {
        HashMap<String, Object> spValue = new HashMap<>();
        SharedPreferences sp = getSharedPreferences("mySp", Context.MODE_PRIVATE);
        spValue.put("userName", sp.getString("userName", ""));
        spValue.put("Sex", sp.getBoolean("Sex", false));
        Log.i(TAG, spValue.toString());
    }
}