package com.example.androidproject.systermKnowledge.json;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

    }

    public void jsonToObjc(View view) {
        String json = "[{\"id\":\"11\", \"name\":\"David\", \"age\":\"12\"}," +
                "{\"id\":\"12\", \"name\":\"Lucy\", \"age\":\"20\"}]";

        ArrayList<Person> arrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Person per = new Person();
                per.setId(jsonObject.getString("id"));
                per.setName(jsonObject.getString("name"));
                per.setAge(jsonObject.getString("age"));
                arrayList.add(per);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (Person person : arrayList) {
            Log.i("JsonActivity", person.toString());
        }


    }

    private class Person {
        String id;
        String name;
        String age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}