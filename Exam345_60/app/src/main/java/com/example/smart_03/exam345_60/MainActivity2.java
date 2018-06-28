package com.example.smart_03.exam345_60;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity2 extends AppCompatActivity {


    Button btnStart, btnStop, btn_Pre, btn_Next;
    ViewFlipper vFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btnStart = (Button) findViewById(R.id.btn_Start);
        btnStop = (Button) findViewById(R.id.btn_Stop);
        btn_Pre = (Button) findViewById(R.id.btn_Pre);
        btn_Next = (Button) findViewById(R.id.btn_Next);

        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        vFlipper.setFlipInterval(1000);



        btn_Pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });



    }}


