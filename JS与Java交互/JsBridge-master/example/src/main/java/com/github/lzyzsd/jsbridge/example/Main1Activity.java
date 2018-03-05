package com.github.lzyzsd.jsbridge.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * 原生 java与js交互，没有用jsbridge框架
 *
 * @author Administrator-shenbh
 * @time 2018/2/7 14:31
 * @path com.github.lzyzsd.jsbridge.example.Main1Activity.java
 */
public class Main1Activity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wv);
        webView = (WebView) findViewById(R.id.wv);
        setWebView();
    }

    private void setWebView() {
        //允许JavaScript执行
        webView.getSettings().setJavaScriptEnabled(true);
        //向js传递对象
//        webView.addJavascriptInterface(new ShowToast(), "toastandroid");
        webView.addJavascriptInterface(new CallMe(), "toastandroid");
        //不会node的小伙伴可以保存到assets
        webView.loadUrl("file:///android_asset/deal.html");
        //访问网页
//        webView.loadUrl("http://192.168.253.1:8000/");
    }

    public final class ShowToast {
        //Html调用此方法传递数据，注解一定要留着否则会出错
        @JavascriptInterface
        public void show() {
            Toast.makeText(Main1Activity.this, "调用", Toast.LENGTH_LONG).show();
        }
    }

    public final class CallMe{
        //Html调用此方法传递数据，注解一定要留着否则会出错
        @JavascriptInterface
        public void callme1(){
            Toast.makeText(Main1Activity.this, "调用1", Toast.LENGTH_LONG).show();
        }
        //Html调用此方法传递数据，注解一定要留着否则会出错
        @JavascriptInterface
        public void callme2(){
            Toast.makeText(Main1Activity.this, "调用2", Toast.LENGTH_LONG).show();
        }
        //Html调用此方法传递数据，注解一定要留着否则会出错
        @JavascriptInterface
        public void callme3(){
            Toast.makeText(Main1Activity.this, "调用3", Toast.LENGTH_LONG).show();
        }
    }

    public final class CallMe3{
        //Html调用此方法传递数据，注解一定要留着否则会出错
        @JavascriptInterface
        public void callme3(String str){
            Toast.makeText(Main1Activity.this, "调用33" + str, Toast.LENGTH_LONG).show();
        }
    }
}
