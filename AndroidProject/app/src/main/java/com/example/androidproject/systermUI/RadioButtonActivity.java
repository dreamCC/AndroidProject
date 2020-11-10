package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class RadioButtonActivity extends AppCompatActivity {


    private RadioButton radioButton1;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioButton1 = findViewById(R.id.rb_1);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RadioButtonActivity.this, "是否check = " + radioButton1.isChecked(), Toast.LENGTH_SHORT ).show();
            }
        });


        radioGroup = findViewById(R.id.rg_1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int count = group.getChildCount();
                RadioButton button = (RadioButton) group.findViewById(checkedId);
                Toast.makeText(RadioButtonActivity.this,
                        "有" + count + "个RadioButton。当前选择的是：" + button.getText() + checkedId,
                        Toast.LENGTH_SHORT ).show();

            }
        });
    }
}