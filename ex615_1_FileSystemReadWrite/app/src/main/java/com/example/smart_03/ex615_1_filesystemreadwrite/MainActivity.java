package com.example.smart_03.ex615_1_filesystemreadwrite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnWrite, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("파일 처리");

        btnWrite = (Button) findViewById(R.id.btn_Write);
        btnRead = (Button) findViewById(R.id.btn_Read);


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //file을 여는 것이기에, 오류 처리 즉 try, catch 포함 시켜야 한다
                try {
                    // FileOutput 쓰기,
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_APPEND); //  MODE_APPEND 추가모드 있던 곳에서 계속 추가
                    String str = "하이!"; // 저장할 문자열
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),"file.txt가 생성됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // FileInput 읽기
                    FileInputStream inFs = openFileInput("file.txt");
                    byte [] txt = new byte[30]; //30byte 크기로 읽어온다
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                    inFs.close();


                } catch (IOException e){
                    Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
