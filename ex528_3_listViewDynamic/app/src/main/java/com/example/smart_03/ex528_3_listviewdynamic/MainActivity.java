package com.example.smart_03.ex528_3_listviewdynamic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("리스트 이용2 동적!");


        //ArrayList TestList로 상수 선언
        final ArrayList<String> TestList = new ArrayList<String>();

        // listView1 id값 찾아서 list 객체 생성
        ListView list = (ListView) findViewById(R.id.listView1);

        //Adapter 연결
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TestList);
        list.setAdapter(adapter);

        //입력창, 버튼 id 값 찾기
        final EditText editItem = (EditText) findViewById(R.id.editItem);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add 추가
                TestList.add(editItem.getText().toString());
                // add 추가 했으니까, 데이터가 바뀌었다고 알려준다! 쓰레드에게.. 갱신한다고 생각?
                adapter.notifyDataSetChanged();
            }
        });

        // LongClick 하면 해당 list가 삭제되도록 이벤트 추가
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //삭제되면서 삭제된 list Toast 띄우기
                Toast.makeText(getApplicationContext(), TestList.get(position), Toast.LENGTH_SHORT).show();

                TestList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}
