package com.example.androidproject.systermKnowledge.xml;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * xml解析的方式一般有三种。sax、dom、pull。 我们这里主要学习pull
 *
 * */
public class XmlActivity extends AppCompatActivity {

    private String TAG = "XmlActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        AssetManager assetManager = getAssets();
        try {
            String[] paths = assetManager.list("");
            for (String path : paths) {
                Log.i(TAG, path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void xmlPullParser(View view) {

        ArrayList<Person> personArrayList = null;
        Person person = null;

        try {
            InputStream xmlInputStream = getAssets().open("person3.xml");

            XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser pullParser = pullParserFactory.newPullParser();
            pullParser.setInput(xmlInputStream, "utf-8");
            int eventType = pullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        personArrayList = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        String tagName = pullParser.getName();
                        if ("person".equals(tagName)) {
                            person = new Person();
                            String id = pullParser.getAttributeValue(0);
                            person.setId(id);
                        }else if ("name".equals(tagName)) {
                            String name = pullParser.nextText();
                            person.setName(name);
                        }else if ("age".equals(tagName)) {
                            String age = pullParser.nextText();
                            person.setAge(age);
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        if ("person".equals(pullParser.getName())) {
                            personArrayList.add(person);
                            person = null;
                        }
                        break;
                }

                eventType = pullParser.next();
            }

            for (Person person1 : personArrayList) {
                Log.i(TAG, person1.id + person1.name + person1.age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void xmlSerializer(View view) {

        ArrayList<Person> personArrayList = new ArrayList<>();
        Person per1 = new Person();
        per1.setId("11");
        per1.setName("David");
        per1.setAge("19");

        Person per2 = new Person();
        per2.setId("12");
        per2.setName("Lucy");
        per2.setAge("20");
        personArrayList.add(per1);
        personArrayList.add(per2);

        try {
            File file = getFileStreamPath("person.xml");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            XmlSerializer xmlSerializer = Xml.newSerializer();
            xmlSerializer.setOutput(fileOutputStream, "utf-8");
            xmlSerializer.startDocument("utf-8", true);
            xmlSerializer.startTag(null, "persons");
            for (Person per: personArrayList) {
                xmlSerializer.startTag(null, "person");
                xmlSerializer.attribute(null, "id", per.getId());

                xmlSerializer.startTag(null, "name");
                xmlSerializer.text(per.getName());
                xmlSerializer.endTag(null, "name");

                xmlSerializer.startTag(null, "age");
                xmlSerializer.text(per.getAge());
                xmlSerializer.endTag(null, "age");

                xmlSerializer.endTag(null, "person");
            }
            xmlSerializer.endTag(null, "persons");
            xmlSerializer.endDocument();

            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
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
    }
}

