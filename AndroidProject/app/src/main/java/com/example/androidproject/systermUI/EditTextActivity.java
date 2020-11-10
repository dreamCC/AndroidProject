package com.example.androidproject.systermUI;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class EditTextActivity extends AppCompatActivity implements TextWatcher {

    private EditText phoneET, pwdET;
    private EditText focus1ET, focus2ET;
    private Button focusBtn, clearFocusBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);


        phoneET = findViewById(R.id.phone_et);
        pwdET   = findViewById(R.id.pwd_et);

        phoneET.addTextChangedListener(this);
        pwdET.addTextChangedListener(this);

        focus1ET = findViewById(R.id.et_3);
        focus2ET = findViewById(R.id.et_4);

        focusBtn = findViewById(R.id.btn_1);
        clearFocusBtn = findViewById(R.id.btn_2);

        final InputMethodManager inputMng = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        focusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                focus1ET.requestFocus();
            }
        });

        clearFocusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                focus1ET.clearFocus();
            }
        });

    }

    // EditText监听事件
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}