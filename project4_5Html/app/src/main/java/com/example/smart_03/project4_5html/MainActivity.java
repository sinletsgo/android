package com.example.smart_03.project4_5html;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TabHost;

@SuppressWarnings("deprecation") // Warnings 막아주기.
public class MainActivity extends TabActivity {   //TabActivity 넣어주니 오레오에선 지양하니까 밑줄


    WebView web1, web2, web3, web4, web5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //탭 정보 가져오기
        TabHost tabHost = getTabHost();

        //탭 위젯에 들어갈 메뉴명
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1").setIndicator("html");
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2").setIndicator("css");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3").setIndicator("javaScript");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0); //첫페이지 설정

        //웹뷰에 연결된 내용
        web1 = (WebView) findViewById(R.id.mWeb1);
        web1.loadUrl("https://ko.wikipedia.org/wiki/HTML");


//        web1 = (WebView) findViewById(R.id.mWeb1);
//        web1.loadUrl("file:///android_asset/dm1.html");

        web2 = (WebView) findViewById(R.id.mWeb2);
        web2.loadUrl("file:///android_asset/css.html");

        web3 = (WebView) findViewById(R.id.mWeb3);
        web3.loadUrl("file:///android_asset/dm3.html");









    }
}
