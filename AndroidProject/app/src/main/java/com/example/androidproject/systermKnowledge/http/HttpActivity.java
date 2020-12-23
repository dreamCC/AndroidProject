package com.example.androidproject.systermKnowledge.http;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class HttpActivity extends AppCompatActivity {

    private String TAG = "HttpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);


    }

    public void httpUrlConnectionGet(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                String urlStr = "https://www.baidu.com";
                try {
                    URL url = new URL(urlStr);
                    // 得到httpConnection对象
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    // 设置请求方式
                    urlConnection.setRequestMethod("GET");
                    // 超时时间
                    urlConnection.setConnectTimeout(10000);
                    // 设置请求头
                    urlConnection.setRequestProperty("Token", "xxxxx");

                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream inputStream = urlConnection.getInputStream();

                        String result = getStringFromStream(inputStream);

                        System.out.println(result);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void httpUrlConnectionPost(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String urlStr = "https://www.baidu.com";
                    URL url = new URL(urlStr);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("POST");
                    // 打开输出流
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    // 设置header
                    connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    // 设置body
                    String params = "userName=zhangsan&password=123456";
                    connection.getOutputStream().write(params.getBytes());

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream inputStream = connection.getInputStream();
                        String result = getStringFromStream(inputStream);
                        System.out.println(result);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void httpClientGet(View view) {


    }

    public void httpClientPost(View view) {

    }

    public void androidAsyncHttpGet(View view) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://www.baidu.com", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String result = new String(responseBody);
                    Log.i(TAG, result);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void androidAsyncHttpPost(View view) {


        AsyncHttpClient client = new AsyncHttpClient();

        Map<String, String> source = new HashMap<>();
        source.put("name", "David");
        source.put("age", "12");
        RequestParams requestParams = new RequestParams(source);
        client.post("", requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    @Nullable
    private String getStringFromStream(InputStream stream) {
        ByteArrayOutputStream baso = new ByteArrayOutputStream();
        try {

            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = stream.read(buffer)) != -1) {
                baso.write(buffer, 0, len);
            }
            stream.close();
            byte[] byteAry = baso.toByteArray();
            return  new String(byteAry);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}