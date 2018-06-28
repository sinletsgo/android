package com.example.smart_03.ex525alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("대화상자 다루기");

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //목록 창에 보여줄 텍스트 변수
                final String[] versionArray = {"마시멜로", "누가", " 오레오"};

                // MultiChoice 가능하게 하는 Array
                final boolean[] checkArray = new boolean[] {true, false, false};


                // 1> 클래스 생성 (dlg는 dialog 약자)
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                // 2> 모양
                dlg.setTitle("창 제목"); //제목 설정


                // 2_1 메세지만
                dlg.setMessage("Hello world!"); // 내용 입력


                //2_2 목록으로
//                목록으로 보여지는 창. setMessage 대신에 setItems로 변경

                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // which --> 몇번째 값인지 위치
                        // 함수 자체 내부에서 자동으로 versionArray 0, 1, 2번 째 텍스트와 번호를 매겨서 클릭한 버튼이 몇번인지 가져온다
                        button1.setText(versionArray[which]);

                    }
                });

                ///2_3 setItems 대신에 setSingleChoiceItems 라디오버튼 형태

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ){
                        button1.setText(versionArray[which]);
                    }
                });


                //2_4 setSingleChoiceItems 대신에 setMultiChoiceItems 여러개 동시 선택 체크박스 형태
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // 체크박스가 복수로 체크될 수 있는데.. 1개만 setText가 바뀌니까
                        // 제대로된 code는  아니다. 제대로 하려면 for문을 돌리던지 다른것이 필요함.
                        button1.setText(versionArray[which]);
                    }
                });

                //2 > 모양 이어서
                dlg.setIcon(R.mipmap.icon2); // 아이콘 설정. mipmap 폴더에 다른 이미지 넣으면 바뀜.
                // 창 아래 버튼 3개. 3개가 MAX
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() { //Click 이벤트 넣기
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "확인 눌렀음", Toast.LENGTH_SHORT).show();
                    }
                }); // <OK> 버튼
                dlg.setNegativeButton("취소",null); // <Cancel> 버튼, null 아무동작 안함.
                dlg.setNeutralButton("중간기능",null); // 중립 버튼


                // 3> 보여주기
                dlg.show();
            }
        });
    }
}
