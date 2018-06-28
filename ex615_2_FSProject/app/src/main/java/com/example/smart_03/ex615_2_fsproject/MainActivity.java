package com.example.smart_03.ex615_2_fsproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.editDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        //날짜 함수
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        // datepicker가 변경이 일어나면 자동으로 해당하는 년 월 일이  매개변수로 들어간다
        // 들어간 매개변수로 선택한 날짜를 fileName 저장해서 해당 file을 readDiary 함수 통해 읽어서 보여주는것!
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear +1) + "_" +
                        Integer.toString(dayOfMonth) + ".txt"; //파일명 만들기
                String str = readDiary(fileName);
                edtDiary.setText(str); // 파일명대로 읽어온 txt 내용을 edtDiary에 보여준다
                btnWrite.setEnabled(true); // true  -> button 객체 활성화
            }
        });


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE); // MODE_PRIVATE : 내부 캐쉬에 저장하겠다.
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "파일생성", Toast.LENGTH_SHORT).show();

                }catch (IOException e){

                }
            }
        });

    }
    String readDiary(String fname){
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fname); // 매개변수로 받은 파일명으로 읽기 모드!
            byte[] txt = new byte[500]; //500 btye 크기로 읽겠다!
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim(); // trim 앞 뒤 공백 제거, 안넣어도 된다.. 띄어쓰기를 많이 해놓으면 지저분하니까.
            // trim 뺴니까, 수정하면 업데이트가  안되던데.. ? 넣어야 하는듯..
            btnWrite.setText("수정하기");

        } catch (IOException e){
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }
}
