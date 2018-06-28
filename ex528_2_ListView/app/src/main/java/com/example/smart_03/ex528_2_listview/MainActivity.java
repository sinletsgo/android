package com.example.smart_03.ex528_2_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //정적 리스트뷰!!

        setTitle("리스트뷰 테스트");

        //1> 리스트뷰에 나열된 내용을 string 배열로

        final String[] listView = {"목록1", "목록2","목록3","목록4","목록5","목록6","목록7","목록8","목록9","목록10","목록11","목록12","목록13"
                ,"목록14","목록15","목록16","목록17","목록18","목록19","목록20"};

        //2> 리스트뷰 찾기
        ListView list = (ListView) findViewById(R.id.listView1);

        //3> ArrayAdopter : 리스트뷰로 작성된 값과 배열 연결

        //this 액티비티에 ArrayAdapter 객체를 넘긴다
        //리스트 모양 바꿀수 있다.   simple_list_item_1,simple_list_item_single_choice , simple_list_item_multiple_choice 등
        // item 연결 -> listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_list_item_single_choice, listView);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //이걸 해야 선택 되었는지 화면에 색깔로 표시해준다
        //즉 ArrayAdapter () 안에 파라미터 3가지는 아래와 같은것
        //1) arrayAdopter 의 값을 보여줄 객체
        //2) 모양
        //3) 배열

        //4> 리스트뷰에 arrayAdopter 연결
        list.setAdapter(adapter);


        //5> 리스트뷰에 기능 연결
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), listView[position], Toast.LENGTH_SHORT).show();

            }
        });


    }
}
