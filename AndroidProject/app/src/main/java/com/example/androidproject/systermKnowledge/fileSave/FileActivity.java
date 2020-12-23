package com.example.androidproject.systermKnowledge.fileSave;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class FileActivity extends AppCompatActivity implements View.OnClickListener {


    private String TAG = "FileActivity";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        findViewById(R.id.btn_normal_save).setOnClickListener(this);
        findViewById(R.id.btn_normal_write).setOnClickListener(this);
        findViewById(R.id.btn_ctx_read).setOnClickListener(this);
        findViewById(R.id.btn_ctx_write).setOnClickListener(this);


        File dataFile = getDataDir();
        Log.i(TAG, "内存" + dataFile.getPath() + dataFile.getParent());

        File cacheFile = getCacheDir();
        Log.i(TAG, "内存" + cacheFile.getPath() + cacheFile.getParent());

        File fFile = getFilesDir();
        Log.i(TAG, "内存" + fFile.getPath() + fFile.getParent());

        Log.i(TAG, Arrays.toString("normalSave".getBytes()));

        String sdState = Environment.getExternalStorageState();
        Log.i(TAG, "sd卡状态：" + sdState);

        File exCacheFile = getExternalCacheDir();
        Log.i(TAG, "sd卡" + exCacheFile.getPath() + exCacheFile.getParent());

        File environmentCacheFile = Environment.getExternalStorageDirectory();
        Log.i(TAG, "sd卡environmentCacheFile:" + exCacheFile.getPath() + "||" + exCacheFile.getParent());

        Log.i(TAG, Arrays.toString("normalSave".getBytes()));

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_normal_save) {
            normalWrite();
        }else if(id == R.id.btn_normal_write) {
            normalRead();
        }else if(id == R.id.btn_ctx_read) {
            ctxRead();
        }else if(id == R.id.btn_ctx_write) {
            ctxWrite();
        }
    }

    private void normalWrite() {
        String normalString = "normalSave";
        File file = new File("data/data/com.example.androidproject/normalSave.txt");
        try {
            byte[] bytes = normalString.getBytes();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(normalString.getBytes());
            outputStream.close();
            Log.i(TAG, Arrays.toString(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void normalRead() {
        File file = new File("data/data/com.example.androidproject/normalSave.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);

            int[] bytes = {};
            int readByte = 0;
            while (readByte != -1) {
               readByte = inputStream.read();
               Log.i(TAG, "读取的数据" + readByte);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ctxRead() {
        String fileString = getFilesDir().getAbsolutePath() + "/ctx.txt";
        File file = new File(fileString);
        try {
            StringBuffer readBuffer = new StringBuffer();

            FileInputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[1];
            while (inputStream.read(buffer) > 0) {
                String readStr = new String(buffer);
                readBuffer.append(readStr);
                Log.i(TAG, "读取：" + readStr);
            }
            inputStream.close();

            Log.i(TAG, "读取的结果:" + readBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ctxWrite() {

        File filePath = getExternalCacheDir();
        File ctxFile = new File(filePath, "ctx.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(ctxFile);
            outputStream.write("ctx row".getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ctxReadUserFileReader() {
        String fileString = getFilesDir().getAbsolutePath() + "/ctx.txt";
        File file = new File(fileString);
        try {
            StringBuffer readStringBuffer = new StringBuffer();
            FileReader reader = new FileReader(file);
            char[] readBuffer = new char[1];
            while (reader.read(readBuffer) > 0) {
                String readS = new String(readBuffer);
                readStringBuffer.append(readS);
                Log.i(TAG, "读取的结果:" + readS);

            }
            reader.close();
            Log.i(TAG, "读取的结果:" + readStringBuffer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void ctxWriterUserFileWriter() {
        String fileString = getFilesDir().getAbsolutePath() + "/ctx.txt";
        File file = new File(fileString);
        try {

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("File writer");
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}