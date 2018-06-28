package com.example.smart_03.ex504addview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    Button btn1, btn2;
    ImageView img1;

    //removeView 하기 위해 연습중

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = (LinearLayout) findViewById(R.id.layout);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        img1 = (ImageView) findViewById(R.id.Img_1);

        // TextView 추가
        // xml 상에서 만들어진것
        TextView name = new TextView(this);
        name.setText("hello");
        name.append("sung woo");
        name.setTextSize(20);
        name.setTextColor(Color.rgb(255,0,0));
        layout.addView(name);

        //button 추가
        Button button1 = new Button(this);
        button1.setText("동적으로 추가된 버튼");
        layout.addView(button1);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //하나만 제거
                layout.removeView(img1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //모두 제거
                layout.removeAllViews();
            }
        });





    }
}
