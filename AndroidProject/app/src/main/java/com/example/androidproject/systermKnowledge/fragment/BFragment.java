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

public class BFragment extends Fragment {

    interface BFragmentListener {
        void onClick(String value);
    }

    private String kLogTag = "BFragment";
    private BFragmentListener listener;
    private TextView textView;

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
        try {
            listener = (BFragmentListener) context;
        }catch (ClassCastException e) {
            throw new ClassCastException("Activity 需要遵循BFragmentListener");
        }
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
        textView = view.findViewById(R.id.tv_1);
        textView.setText(bundle.getString("title"));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick("BFragment 点击");
            }
        });
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

