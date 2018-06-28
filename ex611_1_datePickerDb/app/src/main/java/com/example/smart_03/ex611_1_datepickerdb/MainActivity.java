package com.example.smart_03.ex611_1_datepickerdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp; // 선택 하는공간
    EditText edtDiary;
    Button btnWrite; //하나의 버튼으로 추가, 수정 등 이벤트 줄거다
    String fileName; // 날짜 정보
    myDBHelper myHelper; // DB접근
    SQLiteDatabase sqlDB; //sql 문 작성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일정관리");

        //id 찾기
        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.editDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        // 날짜 객체 선언 --> NEW Date 혹은 Calendar,.getInstance() class
        // 또한 new date로 할 수도 있다.
        Calendar cal = Calendar.getInstance();
        int cyear = cal.get(Calendar.YEAR); // 시스템의 년도값을 추출
        int cmonth = cal.get(Calendar.MONTH); //월 추출 -- +1 해야 정상적으로 월 가져온다.
        int cday = cal.get(Calendar.DAY_OF_MONTH); // 일 추출

        //데이터베이스 초기화
        myHelper = new myDBHelper(this); //myDBHelper class 생성자 불러와서 db 생성!
        sqlDB = myHelper.getWritableDatabase(); //쓰기 모드로 접근
        myHelper.onUpgrade(sqlDB, 1,2); //원래 1이였고, 2로 upgrade 했다! 구분위한것
        sqlDB.close();

        //날짜 정보 설정
        //처음 실행한 날짜(오늘)를 체크하기
        fileName = Integer.toString(cyear) + "-" +
                Integer.toString(cmonth + 1)
                +"_" + Integer.toString(cday);
        // fileName =  "2018-6_11"     이런식으로 저장된다
        String str = readDiary(fileName); //함수 호출 즉 diaryDate에 fileName 데이터를 read 한다
        edtDiary.setText(str);
        btnWrite.setEnabled(true);



        // datePicker 값 설정
        // 날짜 선택하면 바뀐걸 체크해주는것.
        // 날짜가 바뀔때마다 체크 및 매개변수 자동으로 들어온다
        dp.init(cyear, cmonth, cday, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //날짜 정보 설정
                fileName = Integer.toString(year) + "-" +
                        Integer.toString(monthOfYear + 1)
                        +"_" + Integer.toString(dayOfMonth);

                String str = readDiary(fileName); // select문 --> 메서드 정의
                edtDiary.setText(str);
                btnWrite.setEnabled(true);


            }
        });

        //삽입 기능
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnWrite.getText().toString() == "새로저장"){ //글자 문자값이 새로저장이면 insert
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("insert into myDiary values('" + fileName +  "', '"
                    + edtDiary.getText().toString() + "'); ");
                    //insert into mydiary ('2018-6-11' , '내용'); 이렇게 넣는것!
                    sqlDB.close();

                    Toast.makeText(getApplicationContext(), "입력되었습니다", Toast.LENGTH_SHORT).show();
                } else { //수정 일때
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("update myDiary set content=  '" + edtDiary.getText().toString() + "' where diaryDate = '"+fileName + "';  ");
                    //update mydiary set content = "내용" where diaryDate = "2018-6-11"
                }
            }
        });



    }


    //readDiary 메서드 정의
    public String readDiary(String fname){
        String diaryStr = null;
        sqlDB = myHelper.getReadableDatabase(); //select문을 이용하기 위한 준비
        Cursor cursor; //커서위치 체크
        cursor = sqlDB.rawQuery("select * from myDiary WHERE diaryDate='"
                + fname + "'; ", null);


        if (cursor == null){
            edtDiary.setHint("일기없음");
            btnWrite.setText("새로저장");
        } else {
            if (cursor.moveToFirst() == true){ //커서의 첫 행으로 이동. 이부분이 모르겠다. 왜 else 로 빠지는가?
                diaryStr = cursor.getString(1);
                btnWrite.setText("수정");
            } else{
                edtDiary.setHint("일기없음");
                btnWrite.setText("새로저장");
            }
        }
        cursor.close();
        sqlDB.close();
        return  diaryStr;
    }



    //SQLitepenHelper
    public class myDBHelper extends SQLiteOpenHelper{ //db 만들어야 접근 가능!
        //기본 생성자 있어야 한다
        public myDBHelper(Context context) {
            super(context, "myDB", null,1); //가상 임의의 값으로 준것. version 1이고, 기존과 구분하기 위해 넣은것. 앞으로 update 하면서 늘려간다
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //테이블 만들기
            db.execSQL("create table myDiary(" +
                    "diaryDate char(10)" + " primary key, " +
                    "content varchar(500)) ");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //테이블갱신 --> 테이블 삭제후 새롭게 다시 생성
            db.execSQL("drop table if exists myDiary");
            onCreate(db); // onCreate 호출하면서 지우고 다시 만들고!~
        }
    }

}
