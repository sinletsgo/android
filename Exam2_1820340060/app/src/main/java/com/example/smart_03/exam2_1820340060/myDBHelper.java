package com.example.smart_03.exam2_1820340060;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDBHelper extends SQLiteOpenHelper { // alt + enter로 아래 생성자 만들기
    public myDBHelper(Context context) {
        // 생성자 --> db 만들기
        super(context, "SWShin", null,1);
    }

    @Override
    // 데이터베이스 처음 생성 될때
    public void onCreate(SQLiteDatabase db) {
        //table 생성
        // execSQL: sql문 작성

        db.execSQL("create table groupSSW (major TEXT, hackbun TEXT, name TEXT );");
    }

    @Override
    // 데이터베이스의 업그레이드가 필요할때
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 초기화 --> 삭제하고 다시 테이블 생성
        db.execSQL("DROP TABLE IF EXISTS groupSSW"); //테이블 삭제!
        onCreate(db); //다시 db 생성! 호출
    }
}
