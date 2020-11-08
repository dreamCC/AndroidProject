package com.example.androidproject.systermKnowledge.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidproject.R;

public class BFragment extends Fragment {


    private String kLogTag = "BFragment";
    public static BFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        BFragment fragment = new BFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(kLogTag, "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        TextView textView = view.findViewById(R.id.tv_1);
        textView.setText(bundle.getString("title"));

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

