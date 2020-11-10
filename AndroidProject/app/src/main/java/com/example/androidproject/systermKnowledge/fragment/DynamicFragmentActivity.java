package com.example.androidproject.systermKnowledge.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidproject.R;

public class DynamicFragmentActivity extends AppCompatActivity implements BFragment.BFragmentListener{


    private Button changeBtn;
    private AFragment aFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        aFragment = new AFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_1, aFragment);

        // 如果将其添加到回退栈中，那么我们点击返回按钮就不是activity销毁，而是Fragment销毁。
        //fragmentTransaction.addToBackStack("a");
        // fragmentManager.popBackStack(); 进行返回栈。

        fragmentTransaction.commitAllowingStateLoss();
        changeBtn = findViewById(R.id.btn_1);
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                BFragment bFragment =  BFragment.newInstance("我的内容checkBtn");

                // a.remove(); //视图销毁
                // fragmentTransaction.remove(aFragment);

                // aFragment.remove(); bFragment.add();
                fragmentTransaction.replace(R.id.fl_1, bFragment);

                // 隐藏、显示。 调用aFragment onHiddenChanged方法。视图并不会销毁。
//                if (aFragment.isHidden()) {
//                    fragmentTransaction.show(aFragment);
//                }else {
//                    fragmentTransaction.hide(aFragment);
//                }

//                if (aFragment.isAdded()) {
//                    // detach会调用，onPause、onStop、OnDestroyView方法。
//                    fragmentTransaction.detach(aFragment);
//                }else  {
//                    // attach 调用，onCreatView和onViewCreated方法。
//                    fragmentTransaction.attach(aFragment);
//                }

                fragmentTransaction.commitAllowingStateLoss();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("--", "是否隐藏" + aFragment.isHidden());
        return super.onTouchEvent(event);
    }


    @Override
    public void onClick(String value) {
        Log.i("--", "接受到值" + value);
    }
}