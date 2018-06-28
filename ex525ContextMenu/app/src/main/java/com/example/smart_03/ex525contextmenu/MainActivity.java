package com.example.smart_03.ex525contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    LinearLayout baseLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("conText Menu");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);// 컨텍스트 메뉴를 나오게 할 대상
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);

    }
    @Override
     // XML 읽어서 컨텍스트 메뉴 초기화
    // onCreateContextMenu( ) 메소드에는
    // 위젯별로 컨텍스트 메뉴가 나타나야 하므로, 위젯별 컨텍스트 메뉴를 if문으로 등록
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        //메뉴 인플레이트 등록
        MenuInflater mInflater = getMenuInflater();

        if (v == button1){
            mInflater.inflate(R.menu.menu1, menu);  //button1 에 menu1.xml 연결
        }
        if (v == button2){
            mInflater.inflate(R.menu.menu2, menu);
        }
    };


    // 메뉴 선택시 동작할 내용 코딩
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.subRotate:
                button2.setRotation(45);
                return true;
            case R.id.subSize:
                button2.setScaleX(2);
                return true;
        }
        return false;
    }




}
