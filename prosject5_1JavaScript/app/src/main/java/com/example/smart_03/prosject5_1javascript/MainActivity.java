package com.example.smart_03.prosject5_1javascript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {


    WebView web1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //web id 찾기
        web1 = (WebView) findViewById(R.id.webView1);

        //web뷰에 자바 스크립트를 사용하기 위한 환경 설정
        WebSettings webSettings = web1.getSettings();
        webSettings.setJavaScriptEnabled(true); //웹뷰에 자바스크립트 사용 허용


        //자바스크립트와 연결 클래스 추가(클래스이름, 접근할이름)
        // webAppInterface class에 생성자 호출해서 초기화
        web1.addJavascriptInterface(new webAppInterface(this), "Android");
        web1.loadUrl("file:///android_asset/test.html");

    }
}
