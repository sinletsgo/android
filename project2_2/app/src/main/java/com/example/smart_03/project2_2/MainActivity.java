package com.example.smart_03.project2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;

    Switch switch2;

    RadioGroup rGroup1;
    RadioButton radioButton, radioButton2, radioButton3;

    Button endButton, StartButton;
    ImageView imageView;


    // onCreate() 함수가 이미 super 부모 클래스에 있다. 이걸 불러와서 재정의하는것.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    text1 = (TextView) findViewById(R.id.text1);
    text2 = (TextView) findViewById(R.id.text2);
    switch2 = (Switch) findViewById(R.id.switch2);


    rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

    radioButton = (RadioButton) findViewById(R.id.radioButton);
    radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
    radioButton3 = (RadioButton) findViewById(R.id.radioButton3);



    StartButton = (Button) findViewById(R.id.StartButton);
    endButton = (Button) findViewById(R.id.endButton);

    imageView = (ImageView) findViewById(R.id.imageView);


    switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (switch2.isChecked() == true){
                //isChecked : checked 속성값을 알아볼때 사용
                //화면에 보여주기
                text2.setVisibility(View.VISIBLE);
                rGroup1.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                StartButton.setVisibility(View.VISIBLE);
                endButton.setVisibility(View.VISIBLE);
            }else {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                StartButton.setVisibility(View.INVISIBLE);
                endButton.setVisibility(View.INVISIBLE);
            }
        }
    });

    //클릭하면 이미지를 보여줘라!
    radioButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView.setImageResource(R.drawable.dog);
        }
    });

    radioButton2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView.setImageResource(R.drawable.cat);
        }
    });
    radioButton3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView.setImageResource(R.drawable.rabbit);
        }
    });


    endButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); // 프로그램 실행을 종료하겠다!
        }
    });

    StartButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text2.setVisibility(View.INVISIBLE);
            rGroup1.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.INVISIBLE);
            StartButton.setVisibility(View.INVISIBLE);
            endButton.setVisibility(View.INVISIBLE);
            switch2.setChecked(false); //switch 버튼 체크를 해제한다!

        }
    });







    }




}
