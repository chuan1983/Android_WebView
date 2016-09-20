package org.iii.tw.webview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webview;
    private EditText inputName;
    private UIHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            //第一版
//        webView = new WebView(this);
//        webView.loadUrl("http://www.iii.org.tw");
//        setContentView(webView);

        setContentView(R.layout.activity_main);

        handler = new UIHandler();


        mesg = (TextView) findViewById(R.id.mesg);
        webview = (WebView) findViewById(R.id.webview);
        inputName = (EditText)findViewById(R.id.inputName);
        initWebView();
    }
    private void initWebView(){
        //第二版
        WebViewClient client = new WebViewClient();
        webview.setWebViewClient(client);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);           //打開功能

        webview.addJavascriptInterface(new BradJS(), "brad");

//        webView.loadUrl("http://www.iii.org.tw");
        //第三版
        webview.loadUrl("file:///android_asset/brad.html");
//        webview.loadUrl("file:///android_asset/imgs/android.gif");
        //第四版
//        String data = "<h1>Brad Big Company</h1>";
//        webView.loadData(data,"txt/html;charset=UTF-8",null);
    }

    public class BradJS {
        @JavascriptInterface
        public void showMesg(String webmesg){
            Log.d("brad", webmesg);
            Toast.makeText(MainActivity.this, webmesg, Toast.LENGTH_SHORT).show();

            Message msg = new Message();
            Bundle data = new Bundle();
            data.putString("mesg", webmesg);
            msg.setData(data);
            handler.sendMessage(msg);
        }
    }
    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mesg.setText(msg.getData().getString("mesg"));
        }
    }

    public void b1task(View v){
//        doPrev();
        String name = inputName.getText().toString();
        webview.loadUrl("javascript:test2('" + name +"')");
    }
    public void b2task(View v){
//        doNext();
        int x = 3,  y = 4;
        webview.loadUrl("javascript:test3(" + x + "," + y +")");
    }
    public void b3task(View v){
        doReload();
    }
    private void doPrev(){
        webview.goBack();
    }
    private void doNext(){
        webview.goForward();
    }
    private void doReload(){
        webview.reload();
    }
}
