package com.example.smart_03.a423exmiddletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    //변수 선언
    EditText text1, text2;
    Button btn2;
    Integer result;
    String sungjuk;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("성적계산");

        //id찾기
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        btn2 = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView3);

        //버튼ㄱ니능

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sungjuk = text2.getText().toString(); //사용자가 입력한 값
                result = Integer.parseInt(sungjuk);

                //조건비교
                if (result >=90){
                    textView.setText(text1.getText().toString() + "님의 성적은 A");
                } else if (result >= 80){
                    textView.setText(text1.getText().toString() + "님의 성적은 B");
                }else if (result >= 70){
                    textView.setText(text1.getText().toString() + "님의 성적은 C");
                }else if (result >= 60){
                    textView.setText(text1.getText().toString() + "님의 성적은 D");
                }else  {
                    textView.setText(text1.getText().toString() + "님의 성적은 F");
                }
            }
        });


    }
}
