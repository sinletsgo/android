package com.example.smart_03.project1_2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {


    EditText edit1, edit2;

    Button btnAdd, btnSub, btnMul, btnDiv, btnRem, btnClear, btnNum, btnColor;

    TextView textResult;

    String num1, num2, num3, num4;
    Integer result;
    Double result2;

    //추가한 10개의 버튼을 사용하기 위한 배열 선언
    //배열선언 : 타입 [] 배열명 = new 타입[크기]

    Button[] numButtons = new Button[10];

    Integer[] numBtnIDS = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};

    int i ; //인덱스 번호 체크할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);   //참조할 layout 값 activity_main1로 바꾼다

        setTitle("★ 간단한 계산기 ★");

        // xml에 있는 id값 찾기!
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);
        btnClear = (Button) findViewById(R.id.BtnClear) ;
        btnNum = (Button) findViewById(R.id.BtnNum) ;
        btnColor = (Button) findViewById(R.id.BtnColor) ;


        textResult = (TextView) findViewById(R.id.TextResult);


        // 배열에 있는 id값 찾기 --> for문 이용  , 10번 써주던지..
        for (int i = 0; i< numBtnIDS.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIDS[i]);

        }
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

        // new    0-9각 버튼에 기능 부여 . for문으로 한번에 !
        for (i=0; i < numBtnIDS.length; i++){
            final int index; //final 상수형
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused()==true){
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();   // edit1에 현재 입력된 것에 +로 연결. 클릭한 버튼의 text 값을 계속 추가해서 보여주기. (append 할 수도.)
                        edit1.setText(num1); // setText : 새롭게 값 설정. setText 이용해서 클리어 같이 활용할수도.
                    } else if (edit2.isFocused() == true){
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디트에 값 입력", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        // 마지막으로 manifests 가서 <activity android:name=".MainActivity1"> 로 바꿔줘야!
        // Clear 버튼
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText("");
                edit2.setText("");
            }
        });
        // 마지막 1자리 값만 지우는 기능
        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit1.isFocused()==true ){
                    num3 = edit1.getText().toString().substring(0 ,edit1.getText().toString().length()-1);
                    edit1.setText(num3);
                } else if (edit2.isFocused() == true){
                    num4 = edit2.getText().toString().substring(0 ,edit2.getText().toString().length()-1);
                    edit2.setText(num4);
                }
            }
        });
        //button 클릭 시 결과 배경색 바꿔주기
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setBackgroundColor(Color.rgb(60, 24, 153));
            }
        });
    }
}
