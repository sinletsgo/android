package com.example.smart_03.ex430infla;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    Button btn1, btn2;
    CheckBox checkBox1, checkBox2;
    LayoutInflater inflater;
    LinearLayout container1, container2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //주메인화면


        container1 = (LinearLayout) findViewById(R.id.container_1);
        container2 = (LinearLayout) findViewById(R.id.container_2);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);


        //버튼에 기능 부여
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container1.removeAllViews();
                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //getSystemService(): 전체화면중에 일부분을 사용


                inflater.inflate(R.layout.sub1, container1, true);

                //부분화면에 역할
                checkBox1 = (CheckBox) container1.findViewById(R.id.checkBox1);
                checkBox1.setText("로딩되었습니다");

            }
        });
//
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                container1.removeAllViews();
                inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                inflater.inflate(R.layout.sub2, container1, true);




//                checkBox2 = (CheckBox) container2.findViewById(R.id.checkBox2);
//                checkBox2.setText("로딩되었습니다");
            }
        });


    }
}
