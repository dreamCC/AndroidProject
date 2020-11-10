package com.example.androidproject.systermKnowledge.intent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class IntentExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_extra);

        final Intent intent = getIntent();
        String value = intent.getStringExtra("data");
        Log.i("extra", value);

        Button btn = findViewById(R.id.btn_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 反向传值
                Intent intent1 = new Intent();
                intent1.putExtra("result", "返回值");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}