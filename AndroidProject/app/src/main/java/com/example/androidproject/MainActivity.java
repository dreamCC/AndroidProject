package com.example.androidproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import com.example.androidproject.module.HomeFragment;
import com.example.androidproject.module.MineFragment;
import com.example.androidproject.module.PolicyFragment;
import com.example.androidproject.module.ServiceFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {


    private String TAG = "MainActivity";
    private List<TabItem> tabItemList;
    private FragmentTabHost tabHost;
    private TabItem previousItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTabData();
        initTabHost();
    }

    private void initTabData() {

        String[] titles = {"首页", "政务", "服务", "我的"};
        int[] imageNormals = {
                R.drawable.tab_home_normal,
                R.drawable.tab_policy_normal,
                R.drawable.tab_serv_normal,
                R.drawable.tab_mine_normal};
        int[] imageSelected = {
                R.drawable.tab_home_selected,
                R.drawable.tab_policy_selected,
                R.drawable.tab_serv_selected,
                R.drawable.tab_mine_selected
        };
        Class[] fragments = {
                HomeFragment.class,
                PolicyFragment.class,
                ServiceFragment.class,
                MineFragment.class
        };

        tabItemList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            TabItem item = new TabItem(imageNormals[i], imageSelected[i], titles[i], fragments[i]);
            item.setTabIndicator( getLayoutInflater().inflate(R.layout.main_tab_indicator, null));
            tabItemList.add(item);
            if (i == 0) {
                previousItem = item;
            }
            item.setSelected(i == 0);
        }

    }

    private void initTabHost() {

        tabHost = findViewById(android.R.id.tabhost);

        // 绑定 tabContent。
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        // 去掉分割线
        //tabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            TabHost.TabSpec spec = tabHost.newTabSpec(tabItem.getTitleString()).setIndicator(tabItem.getTabIndicator());
            tabHost.addTab(spec, tabItem.getFragment(), null);
        }

        tabHost.setOnTabChangedListener(this);

    }


    @Override
    public void onTabChanged(String tabId) {
        Log.i(TAG, "点击===：" + tabId);
        int current = tabHost.getCurrentTab();
        TabItem item = tabItemList.get(current);
        item.setSelected(true);
        previousItem.setSelected(false);
        previousItem = item;
    }

    class TabItem {

        private int imageNormal;

        private int imageSelected;

        private String titleString;

        private Class fragment;

        private View tabIndicator;

        public TabItem(int imageNormal, int imageSelected, String titleString, Class fragment) {
            this.imageNormal = imageNormal;
            this.imageSelected = imageSelected;
            this.titleString = titleString;
            this.fragment = fragment;
        }

        public void setSelected(boolean selected) {
            View view = getTabIndicator();
            ImageView imageView = view.findViewById(R.id.tab_icon);
            TextView textView = view.findViewById(R.id.tab_text);
            if(selected) {
                imageView.setImageResource(getImageSelected());
                //textView.setTextColor();
            }else {
                imageView.setImageResource(getImageNormal());
            }
            textView.setText(getTitleString());
        }


        public int getImageNormal() {
            return imageNormal;
        }

        public int getImageSelected() {
            return imageSelected;
        }

        public String getTitleString() {
            return titleString;
        }

        public Class getFragment() {
            return fragment;
        }


        public void setTabIndicator(View tabIndicator) {
            this.tabIndicator = tabIndicator;
        }

        public View getTabIndicator() {
            return  this.tabIndicator;
        }
    }
}