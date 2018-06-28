
package com.example.smart_03.ex611_2_test;

        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arr; //배열 만들기
    myDBHelper myHelper; //DB연결
    SQLiteDatabase sqlDB; //sql 문 작성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("DB정보를 리스트로 보여주기");

        arr = new ArrayList<>();
        myHelper = new myDBHelper(this); //db 생성하고 접근
        sqlDB = myHelper.getWritableDatabase();
        Cursor cursor; // cursor 는 행을 참조한다.
        cursor = sqlDB.rawQuery("select * from db_user", null);
        cursor.moveToFirst();
        cursor.getCount();

        //ArrayList 에 값 추가
        for (int i = 0; i < cursor.getCount(); i ++){
            // select로 username만 조회하면 cursor는 username 만 들고 있다. 0번 열밖에 없다. 0번부터 계속 위치를 다음으로 넘어가면서 arr에 add시키는것
            arr.add(cursor.getString(2)); //DB에서 가져온  값을 ArrayList 추가
            cursor.moveToNext();
        }

        ListView list = (ListView) findViewById(R.id.list_Veiw);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1, arr);
        list.setAdapter(adapter); //리스트와 어댑터 연결
    }

    //해왔던 대로 alt+ enter 로  생성자와, 메서드 만든다
    public class myDBHelper extends SQLiteOpenHelper {
        //생성자
        public myDBHelper(Context context) {
            super(context, "myDB1", null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //테이블 작성
            db.execSQL( "create table db_user" +
                    "(uesrid text primary key, username text, usernumber text)");

            //레코드값 삽입
            db.execSQL("insert into db_user values ('user1', '홍길동1', 'u101'); ");
            db.execSQL("insert into db_user values ('user2', '홍길동2', 'u102'); ");
            db.execSQL("insert into db_user values ('user3', '홍길동3', 'u103'); ");
            db.execSQL("insert into db_user values ('user4', '홍길동4', 'u104'); ");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }





}
