package com.example.smart_03.ex608_2_dbsqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //변수 선언
    myDBHelper myHelper; // db정보 가져오려고 선언
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqlDB; // 가져온 db에 접근하기 위한 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그룹 관리");

        //id 찾기
        edtName = (EditText) findViewById(R.id.editName);
        edtNumber = (EditText) findViewById(R.id.editNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        //DB 초기화
        myHelper = new myDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); //쓰기 모드
                myHelper.onUpgrade(sqlDB, 1,2); //아래 onUpgrade method 호출, ?? 1, 2 번호는 뭐냐?
                sqlDB.close(); // db 닫기( 자원 반환)
            }
        });

        //Insert 기능
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); //쓰기 모드
                //insert into groupTBl values ('문자', '문자')
                sqlDB.execSQL("insert into groupTBL values(' " + edtName.getText().toString() +
                        " ',  "+ edtNumber.getText().toString() + ");  ");  //edtName은 문자형식도 들어가야 하니까,  '' 붙여야 오류안난다

                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력완료", Toast.LENGTH_SHORT).show();

            }
        });

        // select 기능
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase(); // getReadableDatabase db생성 또는 오픈
                Cursor cursor;
                // Cursor 클래스 : 데이터 베이스 조회에 의한 데이터 셋을 읽고 쓰는 인터페이스 제공
                // rawQuery : 문자열로 작성된 조회문을 실행한 결과로 생긴 데이터셋에 대한 커서를 반환함
                cursor = sqlDB.rawQuery("select * from groupTBL;", null);

                // 기본 구조
                String strNames  = "그룹이름" + "\r\n"  + " _______ " + "\r\n";
                String strNumbers  = "인원" + "\r\n"  + " _______ " + "\r\n";

                while (cursor.moveToNext()){ // 커서를 다음행으로 이동. 즉 데이터
                    strNames += cursor.getString(0) + "\r\n"; //  select 컬럼(열) 0번째를 가져와서 strNames에 붙여넣는다
                    // 즉 edtName에 작성해서 입력된 것이 sql상에서 0번째 열로 쭉 아래로 쌓인다. 이를 다음행으로 이동하며 계속 조회 하는것같다
                    strNumbers += cursor.getString(1) + "\r\n";

                }
                //다음 레코드값이 있으면 해당 필드값 변수저장
                edtNameResult.setText(strNames); // while문으로 모두 조회해서 저장해놓은 변수 strNames를 edtNameResult Text 값으로 set 시킨다
                edtNumberResult.setText(strNumbers);

                //결과
                cursor.close();
                sqlDB.close(); //데이베이스 닫음

            }
        });

    }


    // SQLiteOpenHelper 상속받아서 sqlite 사용할 수 있게 해주는 역할하는 class 생성
    // SQLiteOpenHelper: 데이터 베이스 생성과 버전을 관리하는 클래스
    public class myDBHelper extends SQLiteOpenHelper { // alt + enter로 아래 생성자 만들기
        public myDBHelper(Context context) {
            // 생성자 --> db 만들기
            super(context, "groupDB", null,1);
        }

        @Override
        // 데이터베이스 처음 생성 될때
        public void onCreate(SQLiteDatabase db) {
            //table 생성
            // execSQL: sql문 작성
//            db.execSQL("create table groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER)");
            db.execSQL("create table groupTBL (gName CHAR(20), gNumber INTEGER);");
        }

        @Override
        // 데이터베이스의 업그레이드가 필요할때
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 초기화 --> 삭제하고 다시 테이블 생성
            db.execSQL("DROP TABLE IF EXISTS groupTBL"); //테이블 삭제!
            onCreate(db); //다시 db 생성! 호출
        }
    }



}
