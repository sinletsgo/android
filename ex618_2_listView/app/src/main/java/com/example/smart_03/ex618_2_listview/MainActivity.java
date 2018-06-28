package com.example.smart_03.ex618_2_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SingerAdapter adapter;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);



        adapter = new SingerAdapter();
        //SingerItem class 생성자 호출 하면서 값 넣기
        adapter.addItem(new SingerItem("태연", "010-000-000", R.drawable.girl1));
        adapter.addItem(new SingerItem("소녀시대2", "010-000-000", R.drawable.girl2));
        adapter.addItem(new SingerItem("소녀시대3", "010-000-000", R.drawable.girl3));

        listView.setAdapter(adapter); //연결!

        //listitem을 클릭할 때 마다 Toast 출력
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position); // 선택 position으로, SingerItem item 객체 생성
                Toast.makeText(getApplicationContext(), "선택: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //추가 버튼 눌렀을때, 추가되는 값. - >  실습내용중에 동적으로 추가했던 것.
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String mobile = editText2.getText().toString();
                SingerItem item = new SingerItem(name, mobile, R.drawable.girl1);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();
            }
        });
    }

    // alt + enter 눌러서 만들기
    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size(); //총 갯수
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//
//            final int pos = position;
//            final Context context = parent.getContext();
//
//            if (convertView  == null){
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//                convertView = inflater.inflate(R.layout.singer_item, parent, false);
//            }
//
//            SingerItem listItem = items.get(position);
//            // name.setText(ListItem.getName()); 교수님 하시다가 잘 안되서 취소한 코드

        SingerItemView view1 = new SingerItemView(getApplicationContext());
        SingerItem item = items.get(position);
        view1.setName(item.getName());
        view1.setMobile(item.getMobile());
        view1.setImage(item.getRestId());
        return view1;
        }

        //추가 메서드
        public void addItem (SingerItem item){
            items.add(item); // ArrayList에서 추가 add, remove(제거), size(크기) , get(값알아보기);
        }

    }

}
