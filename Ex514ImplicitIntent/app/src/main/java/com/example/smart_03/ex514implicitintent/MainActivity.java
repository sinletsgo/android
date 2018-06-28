package com.example.smart_03.ex514implicitintent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button btnDial, btnWeb, btnMap, btnSearch, btnSms;
    Intent intent;
    EditText editText1;
    String test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("암시적 인텐트 예제");

        btnDial = (Button) findViewById(R.id.btnDial);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSms = (Button) findViewById(R.id.btnSms);

        editText1 = (EditText) findViewById(R.id.editText1);

        //전화걸기
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test =  editText1.getText().toString(); // 입력받은 번호로 !
                Uri uri = Uri.parse("tel:" +test ); //전화걸기 하면 이번호가 뜬다
                intent = new Intent(Intent.ACTION_DIAL, uri); //ACTION_DIAL 전화걸기 화면
                startActivity(intent);

            }
        });

        //웹
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.naver.com");
                intent = new Intent(intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //구글지도
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.co.kr/maps?q="+ 37.549859 +"," + 126.842268);
                intent = new Intent(intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //구글 검색
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        //문자 보내기
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-1234")));
                startActivity(intent);
            }
        });




    }
}
