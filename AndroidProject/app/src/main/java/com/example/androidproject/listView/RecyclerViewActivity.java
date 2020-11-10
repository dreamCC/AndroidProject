package com.example.androidproject.listView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;

public class RecyclerViewActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.rv_1);
        // 添加布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutMngAdapter linearLayoutMngAdapter = new LinearLayoutMngAdapter(this);
        linearLayoutMngAdapter.clickListener = new LinearLayoutMngAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(RecyclerViewActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        };

        // 添加adapter
        recyclerView.setAdapter(linearLayoutMngAdapter);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);

                outRect.set(0, 0, 0, 10);
            }


        });

    }
}

class LinearLayoutMngAdapter extends RecyclerView.Adapter<LinearLayoutMngAdapter.LinearViewHolder> {

    private Context mContext;
    
    private LayoutInflater inflater;
    
    OnItemClickListener clickListener;
    
    public LinearLayoutMngAdapter(Context context) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public LinearLayoutMngAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cell = inflater.inflate(R.layout.list_view_cell, viewGroup, false);
        return new LinearViewHolder(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearLayoutMngAdapter.LinearViewHolder viewHolder, final int i) {
        viewHolder.nameTv.setText("这是第" + i + "个item");
        viewHolder.contentTv.setText("GridView(网格视图)，见名知义，ListView是列表， GridView就是显示网格！" +
                "他和ListView一样是AbsListView的子类！很多东西和ListView都是相通的， 本节我们就来学习他的基本用法~");
        
        viewHolder.nameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener != null) {
                    clickListener.onItemClick(i);
                }else {
                    Log.i("-", "clickListener 没有实现");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        private TextView contentTv;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            this.nameTv = itemView.findViewById(R.id.tv_name);
            this.contentTv = itemView.findViewById(R.id.tv_content);
        }
    }
    
    interface OnItemClickListener {
        
        void onItemClick(int position);
    }
}