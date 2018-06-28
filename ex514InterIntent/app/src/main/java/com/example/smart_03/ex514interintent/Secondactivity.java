package com.example.smart_03.ex514interintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Secondactivity extends AppCompatActivity {
    Button Backbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("Second activity");

        // MainActivity 에서 보내준 Num1,Num2 를 받아서 더하고 hapValue에 저장 한다!
        Intent intent = getIntent();
        final int hapValue = intent.getIntExtra("Num1",0)
                + intent.getIntExtra("Num2",0);

        Backbtn = (Button) findViewById(R.id.backButton);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity를 명시적 지정한 outIntent를 새롭게 생성
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", hapValue);

                //응답 메세지 보내기
                // activity로 intent 전달하고 싶을때 사용되는 메서드로 호출하는 형식
                setResult(RESULT_OK, outIntent);
                finish(); //Secondactivity 종료!
            }
        });


    }

}
