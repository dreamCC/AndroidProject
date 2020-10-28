package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.androidproject.R;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button normalToast = findViewById(R.id.btn_1);
        normalToast.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "NormalToast", Toast.LENGTH_LONG).show();
            }
        });

    }
}