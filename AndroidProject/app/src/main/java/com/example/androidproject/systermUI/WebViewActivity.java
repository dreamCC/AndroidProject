package com.example.androidproject.systermUI;

import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class WebViewActivity extends AppCompatActivity {


    private String TAG = "WebViewActivity";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_web_view);


        AssetManager assetManager = getAssets();
        try {
            String[] paths = assetManager.list("");
            for (String path : paths) {
                Log.i(TAG, "路径：=" + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        webView = new WebView(this);
        //webView.loadUrl("https://www.baidu.com");
        webView.loadUrl("file:///android_asset/webview.html");

        // WebSettings。webView的设置
        // 类似WKWebView的，WKWebViewConfig。
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);

        // 通过该方法实现，webView和js的互调。
        webView.addJavascriptInterface(new MyObject(), "myObj");

        // WebViewClient控制客户端，用于处理各种通知和请求事件。
        // 类似iOS中，WKWebView的navigationDelegate
        webView.setWebViewClient(new WebViewClient(){

            // Denied starting an intent without a user gesture
            // 需要重写该方法，返回false。主要原因是chrome内核问题。
            // 控制对新加载的Url的处理,返回true,说明主程序处理WebView不做处理,返回false意味着WebView会对其进行处理
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i(TAG, "shouldOverrideUrlLoading");
                return false;
            }

            // 页面开始加载。
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG, "onPageStarted");
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                Log.i(TAG, "onLoadResource");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "onPageFinished");
            }
        });

        // WebChromeClient。 浏览器客户端，用于处理网站图标、网站标题、网站弹窗等。
        // 类似ios中，WKWebView的WKUIDelegate
        webView.setWebChromeClient(new WebChromeClient(){

            // 获取网站的图标
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i(TAG, "onReceivedTitle ||==" + title);
            }

            // 三种弹窗。
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {

                new AlertDialog.Builder(WebViewActivity.this)
                        .setTitle("alter对话窗")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();
                return true;
            }

            // 系统默认的样式
            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }


        });
        setContentView(webView);
    }



}

class MyObject extends Object {
    private String TAG = "MyObject";

    @JavascriptInterface
    public void showDialog() {
        Log.i(TAG, "js 方法调用 showDialog");
    }

    @JavascriptInterface
    public  void showWithPara(String par) {
        Log.i(TAG, "js 方法调用 showWithPara" + par);

    }
}