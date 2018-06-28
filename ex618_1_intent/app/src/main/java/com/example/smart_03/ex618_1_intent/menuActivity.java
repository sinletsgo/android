package com.example.smart_03.ex618_1_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class menuActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView) findViewById(R.id.textView);

        Button btnBack = (Button) findViewById(R.id.btnBack);

        Intent intent = getIntent(); //보내온 인텐트를 받는다.
        processCommand(intent); // 받은 intent로 함수 호출 받은 id 출력!

        Toast.makeText(getApplicationContext(), "비번" + AppData.passsword, Toast.LENGTH_LONG).show();

        //돌아가기
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("type", "menu"); // type 이름으로 menu라는. 문자값 넘기기
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        //CustomerActivity 로 이동
        Button btnCustomer = (Button) findViewById(R.id.btnCustomer);
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (getApplicationContext(), CustomerActivity.class);
                //불러온 두번째 화면 보여주기
                startActivity(intent2);

            }
        });


        //ProductActivity 로 이동
        Button btnProduct = (Button) findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent (getApplicationContext(), ProductActivity.class);
                //불러온 두번째 화면 보여주기
                startActivity(intent3);

            }
        });

    }

    // 받은 intent data 중 id 값을 textView에 set해주는 method
    public void processCommand(Intent intent){
        if (intent != null){ //intent 데이터가 있으면!
            String id = intent.getStringExtra("id");
            textView.setText("사용자 : " + id + "님 환영합니다");
        }
    }

}