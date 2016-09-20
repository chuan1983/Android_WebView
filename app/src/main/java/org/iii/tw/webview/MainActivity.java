package org.iii.tw.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webView;
    private EditText inputName;
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
        inputName = (EditText)findViewById(R.id.inputName);
        initWebView();
    }
    private void initWebView(){
        //第二版
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
//        webView.loadUrl("http://www.iii.org.tw");
        //第三版
        webView.loadUrl("file:///android_asset/brad.html");
        //第四版
//        String data = "<h1>Brad Big Company</h1>";
//        webView.loadData(data,"txt/html;charset=UTF-8",null);
    }
    public void b1task(View v){
//        doPrev();
        String name = inputName.getText().toString();
        webView.loadUrl("javascript:test2('" + name +"')");
    }
    public void b2task(View v){
//        doNext();
        int x = 3,  y = 4;
        webView.loadUrl("javascript:test3(" + x + "," + y +")");
    }
    public void b3task(View v){
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
