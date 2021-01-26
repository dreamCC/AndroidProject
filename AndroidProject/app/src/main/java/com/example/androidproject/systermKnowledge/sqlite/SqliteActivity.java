package com.example.androidproject.systermKnowledge.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class SqliteActivity extends AppCompatActivity {


    private final String TAG = "SqliteActivity";
    private MineDBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbOpenHelper = new MineDBOpenHelper(this);
        db = dbOpenHelper.getReadableDatabase();
        index = 0;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dbOpenHelper.getReadableDatabase();
        return super.onTouchEvent(event);
    }

    public void add(View view) {


        ContentValues addValue = new ContentValues();
        addValue.put("name", "David " + index);
        // nullColumneHack 如果，insert into infor null values null。 是不行的，如果列明为null，那么将用什么替代null。
        db.insert("person", null, addValue);
        index++;


    }

    public void delete(View view) {

        db.delete("person", "psersonid = ?", new String[]{"3"});
    }

    public void update(View view) {

        ContentValues updateValue = new ContentValues();
        updateValue.put("name", "David update");
        // whereClause = 表示的where条件。
        db.update("person", updateValue, "name = ?", new String[]{"David 0"});
    }

    public void query(View view) {
        Cursor cursor = db.query("person", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int pid = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            Log.i(TAG, "pid = " + pid + "|| name = " + name);
        }
        cursor.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}