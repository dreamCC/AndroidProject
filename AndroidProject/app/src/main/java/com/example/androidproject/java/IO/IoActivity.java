package com.example.androidproject.java.IO;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;

public class IoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);


    }


    private void fileIo() {


    }

    // 字符流。
    private void strIo() {

        try {
            FileReader reader = new FileReader("");
            FileWriter writer = new FileWriter("");

            BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);


            br.close();
            bw.close();

            LineNumberReader lnr = new LineNumberReader(reader);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}