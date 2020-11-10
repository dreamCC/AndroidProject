package com.example.androidproject.systermUI;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

public class MenuActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tv = findViewById(R.id.tv_1);
        // 如果是上下文菜单，必须使用该属性。
        registerForContextMenu(tv);

        // popUpMenu
        btn = findViewById(R.id.btn_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterForContextMenu(tv);
    }

    // OptionMenu。通过重写Activity方法实现。
    // 当然我们也可以通过xml来进行设置。
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        menu.add(1, 0, 0, "红色");
//        menu.add(1, 1, 1, "绿色");
//
//        menu.add(2, 0, 0, "苹果");
//        menu.add(2, 1, 1, "橘子");

//        menu.add("红色");
//        menu.add("绿色");

        // 可以通过该方法加载menu的xml文件。
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }

    // Option的item选择。
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    // ContextMenu。 上下文菜单。
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }
}