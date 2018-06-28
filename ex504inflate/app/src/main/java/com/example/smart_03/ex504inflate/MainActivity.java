package com.example.smart_03.ex504inflate;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


//    //Button 클릭하면 inflater 화면 바꾸기
//    Button btn1, btn2;
//    LinearLayout layout;
//    LayoutInflater inflater; // inflater통해서 외부 xml 불러와서 추가, 제거
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main1);
//
//
//        btn1 = (Button) findViewById(R.id.btn1);
//        btn2 = (Button) findViewById(R.id.btn2);
//        layout = (LinearLayout) findViewById(R.id.layout);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                layout.removeAllViews(); //지우고 새롭게 불러줘야 하니 넣어준다
//                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.sub1, layout, true);
//                //layout.addView(R.layout.sub1); 같은것
//                //true: 자동으로 불러옴 --> addView를 사용하지 않아도 된다.
//                // false : 자동으로 불러오지 않음 --> addView를 이용해서 동적으로 추가해야한다
//
//
//            }
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                layout.removeAllViews();
//                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.sub2, layout, true);
//
//            }
//        });
//    }





   //  Radio Button 으로 선택항목에 따라 입력내용 다르게 나타내기 inflater
    // addView 이용 동적으로 View 추가!
    RadioGroup radioGroup;
    LinearLayout layout;
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sub1, null);
        layout.addView(view);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View view = null; //view null 설정
                if (i == R.id.radioButton1){ //radioButton1을 선택하면
                    Toast.makeText(getApplicationContext(), "교수화면", Toast.LENGTH_SHORT).show();
                    view = inflater.inflate(R.layout.sub1,  null); //view에 sub1 대입


                }else if (i ==R.id.radioButton2){
                    Toast.makeText(getApplicationContext(), "학생화면", Toast.LENGTH_SHORT).show();
                    view = inflater.inflate(R.layout.sub2, null);
                }
                layout.removeAllViews(); //기존 view 지우고
                layout.addView(view);  // 대입한 view를 넣는다!
            }
        });

    }





}
