package com.example.smart_03.ex601customadapter;

import android.provider.FontRequest;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //리스트 뷰
    ListView listView;

    // adapter
    ListAdapter adapter;

    //배열 --> 정적 혹은 동적
    int[] img = {R.drawable.dog, R.drawable.rabbit, R.drawable.cat };
    String [] title = {"기엽강지", "토깽이", "냐옹이"};
    String [] context = {"넘 기여워어~", "당근줄까~?", "냐~옹"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 어댑터를 통한 리스트 뷰");


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
}
