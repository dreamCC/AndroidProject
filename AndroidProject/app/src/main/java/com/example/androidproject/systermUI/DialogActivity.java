package com.example.androidproject.systermUI;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity {


    private String kLogTag = "DialogActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    // 普通
    public void showNormalDialog(View view) {


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("删除记录");
        alertDialog.setMessage("是否确认删除");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "点击确认", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "点击取消", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }

    // 带列表的对话框
    public void showSingleChoiceDialog(View view) {

        final String[] colors = {"orange", "red", "black", "purple"};
        new AlertDialog.Builder(this)
                .setTitle("单选")
                .setCancelable(false)
                .setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,  colors[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    // 复选对话框
    public void showMChoiceDialog(View view) {

        String[] colors = {"orange", "red", "black", "purple"};
        boolean[] selected = {true, false, false, false};
        new AlertDialog.Builder(this)
                .setTitle("多选")
                .setMultiChoiceItems(colors, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        Log.i(kLogTag, "当前选中:" + which + "  是否选中:" + isChecked);
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    // 自定义对话框
    public void showCustomViewDialog(View view) {

        View dialogView = View.inflate(this, R.layout.dialog_view, null);
        final EditText account = dialogView.findViewById(R.id.et_account);
        final EditText pwd = dialogView.findViewById(R.id.et_pwd);
        new AlertDialog.Builder(this)
                .setTitle("自定义View")
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String a = account.getText().toString();
                        String p = pwd.getText().toString();
                        Toast.makeText(DialogActivity.this, a + p, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    // 进度条对话框
    public void showProgressDialog(View view) {

        // ProgressDialog 目前已废止。
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("进度条");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("加载中---");
        progressDialog.setButton(ProgressDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j = 20; i < j; i++) {

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int currentProgress = progressDialog.getProgress();
                    progressDialog.setProgress(currentProgress + 5);
                    if (progressDialog.getProgress() == 100) progressDialog.dismiss();
                }
            }
        }).start();
    }

    // 日期Dialog
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showDatePickerDialog(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.i(kLogTag, "当前选择的日期：" + year + month + dayOfMonth);
            }
        });
        datePickerDialog.show();

    }

    // 时间
    public void showTimePickerDialog(View view) {

        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.i(kLogTag, "当前选择的时间：" + hourOfDay + minute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);

        timePickerDialog.show();
    }



}