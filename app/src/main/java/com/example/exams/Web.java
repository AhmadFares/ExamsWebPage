package com.example.exams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        Intent x = getIntent();
        String URRL = x.getStringExtra("GameUrl");

        WebView view = (WebView) findViewById(R.id.webv);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient( new WebViewClient());
        view.loadUrl(URRL);
    }
}