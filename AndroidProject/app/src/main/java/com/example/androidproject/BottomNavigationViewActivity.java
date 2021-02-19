package com.example.androidproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.io.File;
import java.io.FileInputStream;

public class BottomNavigationViewActivity extends AppCompatActivity {


    private String TAG = "BottomNavigationViewActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);


        initBottomNav();




        File file = new File(getFilesDir() + "/itcast");

        try {

            file.mkdirs();

            file.renameTo(new File(getFilesDir() + "/itcast1"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(file);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }






    private void initBottomNav() {

        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_nav);

        String[] titles = {"首页", "政务", "服务", "我的"};
        int[] icons = {
                R.drawable.tab_home,
                R.drawable.tab_policy,
                R.drawable.tab_serv,
                R.drawable.tab_mine
        };
        // item
        for (int i = 0; i<titles.length; i++) {
            AHBottomNavigationItem item = new AHBottomNavigationItem(titles[i], icons[i]);
            bottomNavigation.addItem(item);
        }

        // 设置样式
        //bottomNavigation.setAccentColor(Color.TRANSPARENT);
        //bottomNavigation.setInactiveColor(Color.TRANSPARENT);

        //bottomNavigation.setColored(false);

        // 设置文字显示
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);



    }


    // 对象被回收时候调用。
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}


