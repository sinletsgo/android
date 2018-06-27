package com.example.smart_03.exam2_1820340060;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


//        1> 별도의 클래스 파일로 만들기 (관리하기 쉬우니 선호된다)
//        2> MainActivity 클래스 바깥에 만들기  public은 빼야함 (자바파일특성)
//        -- MainActivity 파일명이랑 같다.  class myDBHelper
//        3> MainActivity클래스 안에 만드는 경우 공유 클래스로 만듬 --> public static class myDBHelper 으로

// db 활용해서. 틀만 바꿔서 관리프로그램, 자기소개 포트폴리오 만드는것도 좋다

// 수정, 삭제 등 넣어도 좋아보임.
// 새로 파일 만들때, 샘플 있다. 편하지만, code가 많이 붙음.
// 일부는 웹으로 만들고, 안드로이드에 끼우거나.

// 질문은 이메일로, 또는 카페에 질문 올려도 된다.

//옵션 메뉴 만들기
// 메뉴명: 제작
// 제작 메뉴를 클릭하면 대화상자를 띄워서
// 자기 소개하는 페이지 만들기


public class MainActivity extends AppCompatActivity {
    //변수 선언

    EditText edtNameResult, edtHackbunrResult, keyword;
    Button btnInsert, btnSelect, btnInit, btnUpdate;

    SQLiteDatabase sqlDB; // 가져온 db에 접근하기 위한 변수
    myDBHelper myHelper;

    int count = 0;

    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학생관리 프로그램");


        edtHackbunrResult = (EditText) findViewById(R.id.edtHackbunrResult);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);


        myHelper = new myDBHelper(this);

        keyword = (EditText)findViewById(R.id.keyword);


        //Insert 기능. intent 연결 .
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인스턴스화. 객체 만드는 과정!
                Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                startActivity(intent); //code값은 정수 아무값으로, 중복되지않게만 넣어주면 된다.

            }
        });


        // select 기능
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase(); // getReadableDatabase db생성 또는 오픈
                Cursor cursor;
                // Cursor 클래스 : 데이터 베이스 조회에 의한 데이터 셋을 읽고 쓰는 인터페이스 제공
                // rawQuery : 문자열로 작성된 조회문을 실행한 결과로 생긴 데이터셋에 대한 커서를 반환함

                cursor = sqlDB.rawQuery("select * from groupSSW where major = '"
                + keyword.getText().toString() +"'; ", null);

                //모두 조회
//                cursor = sqlDB.rawQuery("select * from groupSSW", null);

                // 기본 구조
                String hackbun  = "학번" + "\r\n"  + " _______ " + "\r\n";
                String name  = "이름" + "\r\n"  + " _______ " + "\r\n";

                while (cursor.moveToNext()){ // 커서를 다음행으로 이동. 끝까지 가야 끝나는것
                    hackbun += cursor.getString(1) + "\r\n"; //  컬럼(열) 1번째를 가져와서 hackbun에 붙여넣는다
                    // 즉 edtName에 작성해서 입력된 것이 sql상에서 0번째 열로 쭉 아래로 쌓인다. 이를 다음행으로 이동하며 계속 조회 하는것같다
                    name += cursor.getString(2) + "\r\n";
                    count++; //한번 돌때마다 count 올려서 전체 데이터 count 갯수 사용
                }

                //다음 레코드값이 있으면 해당 필드값 변수저장
                edtHackbunrResult.setText(hackbun); // while문으로 모두 조회해서 저장해놓은 변수 strNames를 edtNameResult Text 값으로 set 시킨다
                edtNameResult.setText(name);

                //결과
                cursor.close();
                sqlDB.close(); //데이베이스 닫음
                Toast.makeText(getApplicationContext(), count + "명의 학생이 검색됨", Toast.LENGTH_SHORT).show();
                count = 0; //count 누적되니, 또 검색하면 중복 count 세니까, 다시 초기화

            }
        });

        btnInit = (Button) findViewById(R.id.btnInit) ;
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase(); //쓰기 모드
                myHelper.onUpgrade(sqlDB, 1,2);
                sqlDB.close(); // db 닫기( 자원 반환)
                Toast.makeText(getApplicationContext(),  "초기화 되었습니다", Toast.LENGTH_SHORT).show();
            }
        });


        //Insert 기능. intent 연결 .
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인스턴스화. 객체 만드는 과정!
                Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(intent); //code값은 정수 아무값으로, 중복되지않게만 넣어주면 된다.

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // optionsmenu 우측 위 눌르면 나오는 메뉴
        // option 선택했을때 menu 매개변수 받고 id찾아서 switch 넣을것 셋팅
        menu.add(0, 1, 0, "소개");

        return true;
    }
    @Override
    // option item 클릭하면 해당 itemid를 가져와서 그에 맞게 변수에 지정한 값을 대입 시킨다
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1: dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                // LayoutInflater inflater = getInflater();
                // View diaLogView = inflater.inflate(..., , , );

                // 2> AlertDialog 생성하기
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                // 3> 창 조절하기
                dlg.setTitle("제작자 소개");

                // 4> setView로 연결하기 --> setMassage, setItems 대신에 내가만든 dialogView xml로
                dlg.setView(dialogView);

                // 확인 버튼 클릭시 dialogView 에서 아이디, 이메일 가져와서 메인 액티비티에서 보여주는 이벤트 처리
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //5> 보여주기
                dlg.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
        // 혹은 return false;
    }

//
//    // MainActivity 클래스 안에 만드는 경우 공유 클래스 static으로 만듬
//    public static class myDBHelper extends SQLiteOpenHelper { // alt + enter로 아래 생성자 만들기
//        public myDBHelper(Context context) {
//            // 생성자 --> db 만들기
//            super(context, "SWShin", null,1);
//        }
//
//        @Override
//        // 데이터베이스 처음 생성 될때
//        public void onCreate(SQLiteDatabase db) {
//            //table 생성
//            // execSQL: sql문 작성
//
//            db.execSQL("create table groupSSW (major TEXT, hackbun TEXT, name TEXT );");
//        }
//
//        @Override
//        // 데이터베이스의 업그레이드가 필요할때
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            // 초기화 --> 삭제하고 다시 테이블 생성
//            db.execSQL("DROP TABLE IF EXISTS groupSSW"); //테이블 삭제!
//            onCreate(db); //다시 db 생성! 호출
//        }
//    }



}




// MainActivity 클래스 바깥에 만들기. class 파일 만드는거랑 같은 거다. 파일로가 아닌 code만 있을뿐.
// 불러오는건 file 만들었을때랑 같다.
//class myDBHelper extends SQLiteOpenHelper { // alt + enter로 아래 생성자 만들기
//    public myDBHelper(Context context) {
//        // 생성자 --> db 만들기
//        super(context, "SWShin", null,1);
//    }
//
//    @Override
//    // 데이터베이스 처음 생성 될때
//    public void onCreate(SQLiteDatabase db) {
//        //table 생성
//        // execSQL: sql문 작성
//
//        db.execSQL("create table groupSSW (major TEXT, hackbun TEXT, name TEXT );");
//    }
//
//    @Override
//    // 데이터베이스의 업그레이드가 필요할때
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // 초기화 --> 삭제하고 다시 테이블 생성
//        db.execSQL("DROP TABLE IF EXISTS groupSSW"); //테이블 삭제!
//        onCreate(db); //다시 db 생성! 호출
//    }
//}
