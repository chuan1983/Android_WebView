package org.iii.tw.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
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
//        webView.loadUrl("http://www.iii.org.tw");
        //第三版
//        webView.loadUrl("file:///android_asset/brad.html");
        //第四版
//        String data = "<h1>Brad Big Company</h1>";
//        webView.loadData(data,"txt/html;charset=UTF-8",null);
    }
}
