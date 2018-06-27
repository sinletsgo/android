package com.example.smart_03.exam2_1820340060;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    //변수 선언
//    MainActivity.myDBHelper myHelper; // MainActivity에 안에 공유 class 만들었을 경우. myDBHelper class 만든것 불러온다
    myDBHelper myHelper;   //-> 별도의 class 파일로 만들었을 경우.

    EditText edtMajor, edtHackBun, edtName;
    SQLiteDatabase sqlDB; // 가져온 db에 접근하기 위한 변수

    EditText updateList1, updateList2, updateList3;

    EditText updateColumn, updateText, updateWhere;

    String sql, Column, Text, where;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
        setTitle("수정, 삭제");
        //id 찾기


        //DB 초기화
//        myHelper = new MainActivity.myDBHelper(this); //  MainActivity에 안에 공유 class 만들었을 경우
        myHelper = new myDBHelper(this); //별도로 class 따로 만들었을 경우.


        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // select 기능

        updateList1 = (EditText) findViewById(R.id.updateList1);
        updateList2 = (EditText) findViewById(R.id.updateList2);
        updateList3 = (EditText) findViewById(R.id.updateList3);

        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase(); // getReadableDatabase db생성 또는 오픈
                Cursor cursor;

                cursor = sqlDB.rawQuery("select * from groupSSW", null);

                // 기본 구조
                String major = "major" + "\r\n"  + " _______ " + "\r\n";
                String hackbun  = "hackbun" + "\r\n"  + " _______ " + "\r\n";
                String name  = "name" + "\r\n"  + " _______ " + "\r\n";

                while (cursor.moveToNext()){ // 커서를 다음행으로 이동. 끝까지 가야 끝나는것
                    major += cursor.getString(0) + "\r\n";
                    hackbun += cursor.getString(1) + "\r\n"; //  컬럼(열) 1번째를 가져와서 hackbun에 붙여넣는다
                    // 즉 edtName에 작성해서 입력된 것이 sql상에서 0번째 열로 쭉 아래로 쌓인다. 이를 다음행으로 이동하며 계속 조회 하는것같다
                    name += cursor.getString(2) + "\r\n";
                }

                //다음 레코드값이 있으면 해당 필드값 변수저장
                updateList1.setText(major); // while문으로 모두 조회해서 저장해놓은 변수 strNames를 edtNameResult Text 값으로 set 시킨다
                updateList2.setText(hackbun);
                updateList3.setText(name);

                //결과
                cursor.close();
                sqlDB.close(); //데이베이스 닫음
                Toast.makeText(getApplicationContext(), "모든 레코드 조회 완료", Toast.LENGTH_SHORT).show();

            }
        });

        // 수정하기

        updateColumn = (EditText) findViewById(R.id.updateColumn);
        updateText = (EditText) findViewById(R.id.updateText);
        updateWhere = (EditText) findViewById(R.id.updateWhere);

        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();


                // major update 완성
//                String sql = "update groupSSW set major='" + updateText.getText().toString() +
//                        "'  where major= '" + updateWhere.getText().toString()  + "';";
                Column = updateColumn.getText().toString();
                Text = updateText.getText().toString();
                where = updateWhere.getText().toString();

                if(Column.getBytes().length == 0){ //빈값이 넘어올때의  처리
                    Toast.makeText(getApplicationContext(), "값을 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    sql = "update groupSSW "  + "set " + Column + "= '" + Text +
                            "' where " + Column + "=  '" + where + "';";
                }

//                Toast.makeText(getApplicationContext(), "조건 없이 컬럼 모든 값에 update 합니다", Toast.LENGTH_SHORT).show();
//                sql = "update groupSSW "  + "set " + Column + "= '" + Text + "';";


                sqlDB.execSQL(sql);
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "수정완료", Toast.LENGTH_SHORT).show();

                updateColumn.setText("");
                updateText.setText("");
                updateWhere.setText("");


            }
        });
        //UPDATE Customers
        //SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
        //WHERE CustomerID = 1;

        // 삭제하기
        Button btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                sqlDB = myHelper.getWritableDatabase();
                Column = updateColumn.getText().toString();
                Text = updateText.getText().toString();


                if(Column.getBytes().length == 0) {
                    Toast.makeText(getApplicationContext(), "입력하세요", Toast.LENGTH_SHORT).show();
                } else{
                    // sql = "delete from  groupSSW where " + Column  +";";

                    sql = "delete from  groupSSW where " + Column + "= '" + Text +"';";

//                delete from KOPO_STUDENT_2018
//                where tel = 0000;

                    sqlDB.execSQL(sql);
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "삭제 완료", Toast.LENGTH_SHORT).show();
                    updateColumn.setText("");
                    updateText.setText("");
                    updateWhere.setText("");
                }




            }
        });

    }
}
