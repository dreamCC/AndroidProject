package com.example.androidproject.listView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.androidproject.R;

public class StaggerRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger_recycler_view);

        recyclerView = findViewById(R.id.rv_1);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setAdapter(new StaggerRecyclerViewAdapter(this));

        recyclerView.addItemDecoration(new StaggerItemDecoration());
    }

    class StaggerItemDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.set(10, 10, 10, 10);
        }
    }

}

class StaggerRecyclerViewAdapter extends RecyclerView.Adapter<StaggerRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    public StaggerRecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public StaggerRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = layoutInflater.inflate(R.layout.stagger_recycler_view_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StaggerRecyclerViewAdapter.ViewHolder viewHolder, int i) {

        String imageUrl;
        if(i % 2 == 0) {
            imageUrl = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1078861629,3747050294&fm=26&gp=0.jpg";
            viewHolder.textView.setHeight(50);

        }else {
            imageUrl = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3755741466,708703397&fm=26&gp=0.jpg";
            viewHolder.textView.setHeight(100);
        }

        Glide.with(context).load(imageUrl).into(viewHolder.imageView);
        viewHolder.textView.setText("当前是第：" + i + "个item");
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_1);
            textView  = itemView.findViewById(R.id.tv_1);
        }
    }
}