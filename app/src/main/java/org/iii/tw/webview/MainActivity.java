package org.iii.tw.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //第一版
//        webView = new WebView(this);
//        webView.loadUrl("http://www.iii.org.tw");
//        setContentView(webView);

        setContentView(R.layout.activity_main);

        mesg = (TextView) findViewById(R.id.mesg);
        webView = (WebView) findViewById(R.id.webview);
        initWebVuew();
    }
    private void initWebVuew(){
        //第二版
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.loadUrl("http://www.iii.org.tw");
        //第三版
//        webView.loadUrl("file:///android_asset/brad.html");
        //第四版
//        String data = "<h1>Brad Big Company</h1>";
//        webView.loadData(data,"txt/html;charset=UTF-8",null);
    }
    public void test1(View v){
        doPrev();
    }
    public void test2(View v){
        doNext();
    }
    public void test3(View v){
        doReload();
    }
    private void doPrev(){
        webView.goBack();
    }
    private void doNext(){
        webView.goForward();
    }
    private void doReload(){
        webView.reload();
    }
}
