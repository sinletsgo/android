package com.example.smart_03.a504intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity main 안바꿔도 왔다갔다 할수 있다!
                // 화면 자체가 왔다 갔다 하는것

                // 두번째 화면 불러오기
                Intent intent = new Intent (getApplicationContext(), SecondActivity.class);

                //불러온 두번째 화면 보여주기
                startActivity(intent);

            }
        });



    }
}
