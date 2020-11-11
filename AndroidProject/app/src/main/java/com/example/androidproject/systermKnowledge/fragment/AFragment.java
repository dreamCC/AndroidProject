package com.example.androidproject.systermKnowledge.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidproject.R;

public class AFragment extends Fragment {

    private TextView textView;
    private String kLogTag = "AFragment";

    // 视图添加到activity后，调用该方法，只会调用一次。最先调用
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(kLogTag, "onAttach");



    }

    // 创建Fragment时候回调用。


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(kLogTag, "onCreate");
    }

    // 创建视图
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(kLogTag, "onCreateView");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    // 视图创建完成
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(kLogTag, "onViewCreated");

        textView = view.findViewById(R.id.tv_1);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(kLogTag, "onHiddenChanged:" + hidden);


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(kLogTag, "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(kLogTag, "onStop");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(kLogTag, "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(kLogTag, "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(kLogTag, "onDetach");

    }
}
