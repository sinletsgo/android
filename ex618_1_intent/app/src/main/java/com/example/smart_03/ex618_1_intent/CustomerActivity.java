package com.example.smart_03.ex618_1_intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Button btnBack;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        btnBack = (Button) findViewById(R.id.btnBack);

        //돌아가기
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
