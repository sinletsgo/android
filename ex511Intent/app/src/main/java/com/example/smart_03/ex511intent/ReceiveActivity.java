package com.example.smart_03.ex511intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    //activity_main1 sub에 textView 사용 변수 설정
    TextView re_name1, re_sex, re_sms;

    String str_name1, str_sex, str_sms;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        setTitle("전송된 데이터 결과화면");


        //activity_main1 sub에 textView 사용 변수 id값 찾기
        re_name1=(TextView)findViewById(R.id.re_name1);
        re_sex=(TextView)findViewById(R.id.re_sex);
        re_sms=(TextView)findViewById(R.id.re_sms);


        Intent it = getIntent();

        str_name1 = it.getStringExtra("it_name"); //메인에서 넘겨준 data를 string으로 받겠다!
        re_name1.setText(str_name1); //re_name1의  text를 str_name1 data로 !

        //java 2개 실행하기 위해
        // AndroidManifest 가서 작업 해줘야!

        str_sex = it.getStringExtra("it_sex");
        re_sex.setText(str_sex);


        str_sms = it.getStringExtra("it_sms");
        re_sms.setText(str_sms);
    }


}
