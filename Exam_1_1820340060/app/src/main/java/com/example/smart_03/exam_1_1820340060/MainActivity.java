package com.example.smart_03.exam_1_1820340060;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //리스트 뷰
    ListView listView;


    // 상단 텍스트 뷰
    TextView topTextView;

    //대화상자 뷰어
    View dialogView;

    String date; // 날짜 정보

    //대화상자 입력받는 변수
    EditText dlgEdtNum;


    // adapter
    ListAdapter adapter;



    //배열 --> 정적 혹은 동적
    int[] img = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5 };
    String [] title = {"신성우", "이효재", "정효재", "김강용", "노영우"};
    String [] context = {"안드로이드 is good", "안드로이드 is good", "안드로이드 is good", "안드로이드 is good", "안드로이드 is good"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 어댑터를 통한 리스트 뷰");


        topTextView = (TextView) findViewById(R.id.topTextView);

        //내가 만든 어댑터 (ListAdapter class)로 수정
        adapter = new ListAdapter();
        listView = (ListView) findViewById(R.id.List_View);
        listView.setAdapter(adapter); //listView에 ListAdapter class adapter와 연결!

        //리스트의 모양
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //값 전달
        for (int i = 0; i < img.length; i++){
            // ListAdapter class 에 있는 addVO method 호출하며 값 전달
            adapter.addVO(ContextCompat.getDrawable(this, img[i]), title[i], context[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // optionsmenu 우측 위 눌르면 나오는 메뉴
        // option 선택했을때 menu 매개변수 받고 id찾아서 switch 넣을것 셋팅
        menu.add(0, 1, 0, "로그인"); //itemId는 반드시 순서대로, 겹치면 뭘 불러오는지 모른다.
        menu.add(0, 2, 0, "소개");

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
                dlg.setTitle("사용자 정보 입력");

                // 4> setView로 연결하기 --> setMassage, setItems 대신에 내가만든 dialogView xml로
                dlg.setView(dialogView);

                // 확인 버튼 클릭시 dialogView 에서 아이디, 이메일 가져와서 메인 액티비티에서 보여주는 이벤트 처리
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 여기서 dialogView id 찾아야 한다. 안그러면 사라진다고 함.
                        dlgEdtNum = (EditText) dialogView.findViewById(R.id.dlgEdtNum);

                        //  text 가져와서 메인 액티비티에 setText
                        topTextView.setText(dlgEdtNum.getText().toString());
                    }
                });

                //5> 보여주기
                dlg.show();

                return true;
            case 2:
                Toast.makeText(this, "(2018/6/22 제작: 신성우)" , Toast.LENGTH_LONG).show();


                return true;
        }
        return super.onOptionsItemSelected(item);
        // 혹은 return false;
    }



}
