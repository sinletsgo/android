package com.example.smart_03.project1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 위젯 따라 사용할 변수 선언..
    // 전역으로 쓰기 위해 이곳에 선언!

    EditText edit1, edit2;

    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;

    TextView textResult;

    String num1, num2;
    Integer result;
    Double result2; // 또는 float 로 . double이 더 많이 표현가능



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단한 계산기 ★");

        // xml에 있는 id값 찾기!

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);

        // 기능 부여 --> 이벤트 --> onTouchListener

        // 클릭 vs 터치 제일 많이쓴다. 클릭은 눌렀다 뗄때 실행, 터치는 누르자 마자
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {  //리턴타입: boolean
                num1 = edit1.getText().toString(); //getText() : 입력된 값을 얻기, toString() : 문자열화 하기
                num2 = edit2.getText().toString(); // 입력받은건 string으로 입력되니까, int로 바꿔주어야.

                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산결과" + result.toString());


                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과" + result.toString());


                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과" + result.toString());


                return false;
            }
        });


        //button 으로 바꿔본것것
       btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result2 = Double.parseDouble(num1) / Double.parseDouble(num2);
                textResult.setText("계산결과" + result2.toString());
            }
        });

        // 나머지 값 구하기도 추가
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) % Integer.parseInt(num2);
                textResult.setText("계산결과" + result.toString());
            }
        });
    }
}
