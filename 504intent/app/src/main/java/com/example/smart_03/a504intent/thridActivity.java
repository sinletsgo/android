package com.example.smart_03.a504intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class thridActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        Button btn4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thrid);

        btn4 = (Button) findViewById(R.id.btn4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


    }
}