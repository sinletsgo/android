package com.example.smart_03.exam2_1820340060;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    //변수 선언
//    MainActivity.myDBHelper myHelper; // MainActivity에 안에 공유 class 만들었을 경우. myDBHelper class 만든것 불러온다
    myDBHelper myHelper;   //-> 별도의 class 파일로 만들었을 경우.

    EditText edtMajor, edtHackBun, edtName;
    SQLiteDatabase sqlDB; // 가져온 db에 접근하기 위한 변수

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        setTitle("입력");
        //id 찾기
        edtMajor = (EditText) findViewById(R.id.edtMajor);
        edtHackBun = (EditText) findViewById(R.id.edtHackBun);
        edtName = (EditText) findViewById(R.id.edtName);

        //DB 초기화
//        myHelper = new MainActivity.myDBHelper(this); //  MainActivity에 안에 공유 class 만들었을 경우
        myHelper = new myDBHelper(this); //별도로 class 따로 만들었을 경우.

        Button btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sqlDB = myHelper.getWritableDatabase(); //쓰기 모드

                //insert into groupTBl values ('문자', '문자')

                sqlDB.execSQL("insert into groupSSW values('"
                        + edtMajor.getText().toString() + "' , '"
                        + edtHackBun.getText().toString() + "' , '"
                        + edtName.getText().toString() + "');");

                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력완료", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}