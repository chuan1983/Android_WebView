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
        setContentView(R.layout.activity_main);

        mesg = (TextView) findViewById(R.id.mesg);
        webView = (WebView) findViewById(R.id.webview);
        initWebVuew();
    }
    private void initWebVuew(){

    }
}
