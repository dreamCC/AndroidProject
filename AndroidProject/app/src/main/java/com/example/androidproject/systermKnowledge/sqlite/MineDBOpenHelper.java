package com.example.androidproject.systermKnowledge.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MineDBOpenHelper extends SQLiteOpenHelper {

    public MineDBOpenHelper(@Nullable Context context) {
        super(context, "itheima.db", null, 1);
    }

    // 当数据库文件第一次创建的时候，会调用该方法。
    // sqlite中习惯用_id 表示primary key。
    // sqlite数据库都是字符串。
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table person(_id integer primary key autoincrement, name varchar(20))");
        System.out.println("db=========onCreate");
    }

    // 当数据库升级的时候调用，也就是版本号改变的时候调用。
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table person add phone VARCHAR(12)");
    }
}
