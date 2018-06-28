package com.example.smart_03.ex601gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    MyGridAdapter gAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드");

        //activity_main 에 GridView id찾아서, GridView 객체 생성
        GridView gv = (GridView)findViewById(R.id.gridView1);
        // 직접 만든 MyGridAdapter 를  gAdapter 이름으로 객체 생성
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter); //GridView 와 내가 만든 adapter와 연결
    }
}
