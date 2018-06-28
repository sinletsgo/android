package com.example.smart_03.ex528_4_listviewxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> mData = new ArrayList<>();
    ListView mList1, mList2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("리스트 3");
        //동적 배열로 add메서드 이용해서 목록 추가
        mData.add("수성");
        mData.add("금성");
        mData.add("지구");
        mData.add("화성");
        mData.add("목성");
        mData.add("토성");
        mData.add("천왕성");
        mData.add("혜왕성");

        // 리스트뷰 초기화
        mList1 = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter1  = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, mData);

        mList1.setAdapter(adapter1);

        //클릭 이벤트 처리
        mList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        // xml을 이용한 문자열 배열
        //즉  array xml 에서 만든 planet 배열 가져와서 liestView에 보여주기
        mList2 = (ListView) findViewById(R.id.listView2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.planet, android.R.layout.simple_list_item_1);
        mList2.setAdapter(adapter2);

        mList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] arrData = getResources().getStringArray(R.array.planet); //array.xml의 planet 배열로 가져와서
                Toast.makeText(MainActivity.this, arrData[position], Toast.LENGTH_SHORT).show(); // 선택한 것 텍스트창으로 띄운다
            }
        });



    }
}
