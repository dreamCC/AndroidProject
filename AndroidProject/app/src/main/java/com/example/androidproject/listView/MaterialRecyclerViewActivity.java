package com.example.androidproject.listView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidproject.R;

public class MaterialRecyclerViewActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_recycler_view);

        recyclerView = findViewById(R.id.rv_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MaterialAdapter(this, new MaterialAdapter.MaterialRecyclerViewItemClickListener() {
            @Override
            public void onClick(int position) {
                System.out.println("点击" +  position);
            }
        }));
    }

}

class MaterialAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;
    private MaterialRecyclerViewItemClickListener itemClickListener;

    public MaterialAdapter(Context context, MaterialRecyclerViewItemClickListener itemClickListener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i % 2 == 0) {
            Log.i("=", "当前偶数" + i);
            View itemV = inflater.inflate(R.layout.stagger_recycler_view_item, viewGroup, false);
            return new EvenViewHolder(itemV);
        }else  {
            Log.i("=", "当前奇数" + i);
            View itemV = inflater.inflate(R.layout.list_view_cell, viewGroup, false);
            return new OddViewHolder(itemV);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return 0;
        }else  {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        if (i % 2 == 0 ) {
            EvenViewHolder evenViewHolder = (EvenViewHolder) viewHolder;
            evenViewHolder.textView.setText("这是偶数" + i);
            Glide.with(context).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3245371152,3456791010&fm=26&gp=0.jpg").into(evenViewHolder.imageView);
        }else  {
            ((OddViewHolder)viewHolder).nameTv.setText("这是奇数" + i);
            ((OddViewHolder) viewHolder).contentTv.setText("这是奇数内容，毋庸置疑");
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    /*
    * 接口*/
    interface MaterialRecyclerViewItemClickListener {

        void onClick(int position);
    }


    /*
    * ViewHolder*/
    class OddViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        TextView contentTv;
        public OddViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tv_name);
            contentTv = itemView.findViewById(R.id.tv_content);
        }
    }

    class EvenViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        public EvenViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_1);
            imageView = itemView.findViewById(R.id.iv_1);
        }
    }
}