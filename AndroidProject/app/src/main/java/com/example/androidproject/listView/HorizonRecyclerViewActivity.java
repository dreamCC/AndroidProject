package com.example.androidproject.listView;

import android.content.Context;
import android.graphics.Rect;
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

public class HorizonRecyclerViewActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizon_recycler_view);

        recyclerView = findViewById(R.id.rv_1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new HorizonRecyclerViewAdapter(this, new HorizonRecyclerViewAdapter.ItemClick() {
            @Override
            public void onClick(int position) {

            }
        }));

        recyclerView.addItemDecoration(new ItemDecoration());

    }

    class ItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 10, 0);
        }
    }


}

class HorizonRecyclerViewAdapter extends RecyclerView.Adapter<HorizonRecyclerViewAdapter.MViewHolder> {

    private String kLog = "HorizonRecyclerViewAdapter";

    private LayoutInflater layoutInflater;
    private Context context;
    private ItemClick click;
    HorizonRecyclerViewAdapter(Context context, ItemClick click){
        this.context = context;
        this.click = click;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HorizonRecyclerViewAdapter.MViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.grid_view_item, viewGroup, false);
        MViewHolder viewHolder = new MViewHolder(itemView);
        Log.i(kLog, "onCreateViewHolder:-" + i);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizonRecyclerViewAdapter.MViewHolder viewHolder, final int i) {
        Log.i(kLog, "onBindViewHolder" + i);

        viewHolder.textView.setText("onBindViewHolder：-" + i);
        Glide.with(context).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3245371152,3456791010&fm=26&gp=0.jpg").into(viewHolder.imageView);
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click != null) {
                    click.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i(kLog, "getItemCount");

        return 20;
    }


    class MViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_1);
            textView = itemView.findViewById(R.id.tv_1);
        }
    }

    interface ItemClick {

        void onClick(int position);
    }
}