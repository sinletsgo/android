package com.example.smart_03.project1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText bmiKg, bmiHeight;

    Button bmiButton;

    TextView bmiResult, bmiResult2;


    String num1, num2;

    Float Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("BMI 지수 구하기!");

        bmiKg = (EditText) findViewById(R.id.bmiKg);
        bmiHeight = (EditText) findViewById(R.id.bmiHeight);
        bmiButton = (Button) findViewById(R.id.bmiButton);

        bmiResult = (TextView) findViewById(R.id.bmiResult);
        bmiResult2 = (TextView) findViewById(R.id.bmiResult2);



        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = bmiKg.getText().toString();
                num2 = bmiHeight.getText().toString();

                Result = (Float.parseFloat(num1) / ( Float.parseFloat(num2) * Float.parseFloat(num2) )) *10000 ;

                bmiResult.setText("bmi:" + Result.toString());


                if (Result >= 23){
                    bmiResult2.setText("비만");
               }
                else if (Result > 18.5  && Result < 22.9){
                    bmiResult2.setText("정상");
                }
                else {
                    bmiResult2.setText("저체중");
                }
        }});



    }
}
