package com.example.androidproject.listView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataSources();

        setContentView(R.layout.activity_list_view);

        ListView listview = findViewById(R.id.listView);
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this);
        listview.setAdapter(animalAdapter);
    }


    private void initDataSources() {


        animals = new ArrayList<>();
        animals.add(new Animal("狗", "这是一条狗吧"));
        animals.add(new Animal("猫", "小猫最可爱"));
        animals.add(new Animal("鸭", "中国国家统计局19日公布，初步核算，" +
                "前三季度中国国内生产总值(GDP)722786亿元(人民币，下同)，按可比价格计算，同比增长0.7%。" +
                "分季度看，一季度同比下降6.8%，二季度增长3.2%，三季度增长4.9%。从环比看，三季度国内生产总值增长2.7%。"));
        animals.add(new Animal("熊猫", "熊猫一般指大熊猫。大熊猫（学名：Ailuropoda melanoleuca）：属于食肉目、熊科、大熊猫亚科和大熊猫属唯一的哺乳动物。仅有二个亚种。雄性个体稍大于雌性。"));
        animals.add(new Animal("老虎🐅", "老虎一般指虎。虎（学名：Panthera tigris ；英文名：Tiger）：是哺乳纲的大型猫科动物；毛色浅黄或棕黄色，满身黑色横纹；头圆、耳短，耳背面黑色，中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。"));


    }

    private class AnimalAdapter extends BaseAdapter {

        ArrayList<Animal> animals;
        Context context;

        public AnimalAdapter(ArrayList<Animal> animals, Context context) {
            this.animals = animals;
            this.context = context;
        }

        @Override
        public int getCount() {
            return animals.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {

            ViewHook viewHook;
            if(convertView == null) {
                viewHook = new ViewHook();
                convertView = LayoutInflater.from(context).inflate(R.layout.list_view_cell, parent,false);
                viewHook.nameTv = convertView.findViewById(R.id.tv_name);
                viewHook.contentTv = convertView.findViewById(R.id.tv_content);
                convertView.setTag(viewHook);
            }else  {
                viewHook = (ViewHook) convertView.getTag();
            }

            Animal animal = animals.get(position);
            viewHook.nameTv.setText(animal.name);
            viewHook.contentTv.setText(animal.content);
            return convertView;
        }
    }

    private class ViewHook {

        TextView nameTv;
        TextView contentTv;
    }

}

class Animal {
    String name;
    String content;

    public Animal(String name, String content) {
        this.name = name;
        this.content = content;
    }


    // setter && getter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
