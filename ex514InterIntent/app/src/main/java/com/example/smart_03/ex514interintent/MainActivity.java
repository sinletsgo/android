package com.example.smart_03.ex514interintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNewActiviry;
    EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메인 액티비티");

        btnNewActiviry = (Button) findViewById(R.id.plusButton);


        num1 = (EditText) findViewById(R.id.Num1);
        num2 = (EditText) findViewById(R.id.Num2);
        // 또는  EditText num1 = (EditText) findViewById(R.id.Num1);

        btnNewActiviry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 실행
                Intent intent = new Intent(getApplicationContext(), Secondactivity.class);
                intent.putExtra("Num1", Integer.parseInt(num1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(num2.getText().toString()));

                //달라지는 부분
                //requetCode 결과를 돌려받을 때 어떤 요청이 되돌아 왔는지 구분하기 위한 코드
                startActivityForResult(intent, 0);
            }
        });
    }
        //메인으로 돌아왔을때 메서드 오버라이딩
       //  onActivityResult 자동 호출된다
        // code -> override metthods --> onActivityResult
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data ){
            //성공여부 체크후 결과 출력
            if (resultCode == RESULT_OK){
                int hap = data.getIntExtra("Hap", 0); //응답받은 Hap data를 hap 에 대입!
                Toast.makeText(getApplicationContext(),"합계"+hap, Toast.LENGTH_SHORT).show();
            }
        }


    }

