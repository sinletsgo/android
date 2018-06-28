package com.example.smart_03.ex601customadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    //동적 배열
    //들어오는 값에 따라 순서대로 들어가는것

    // ListVO class를 ArrayList로 하는 listVo 라는 객체 생성
    // listVo 객체에 3개가 들어간다. img, title, context
    private ArrayList<ListVO> listVo = new ArrayList<>();

    //생성자
    public  ListAdapter(){

    }
    //매개변수 있는 생성자
    public ListAdapter(ArrayList<ListVO> listVo){
        this.listVo = listVo;
    }

    //추가 메서드 --> 데이터값 넣어주기
    public  void addVO(Drawable icon, String title, String desc){
        ListVO item =  new ListVO();
        // 매개변수 데이터를 ListVO class의 setter를 호출해서 set 한다!
        item.setImg(icon);
        item.setTitle((title));
        item.setContext(desc);
        listVo.add(item);

    }


    @Override
    public int getCount() { //데아터 전체 갯수
        return listVo.size(); //listVo에 총 갯수를 return. size(): 배열의 총 갯수 length랑 같은데 배열은 size() 사용
    }

    @Override
    public Object getItem(int position) { //위치에 해당하는 데이터 값 리턴
        return listVo.get(position); //get(위치)  get은 listVo 내장 method, 위치를 알려준다.
    }

    @Override
    public long getItemId(int position) { //위치에 해당하는 데이터 식별자 리턴
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position; //위치 체크할 변수

        //Context? 자신이 어떤 어플리케이션을 나타내고 있는지 알려주는 ID 역할
        //결국, 안드로이드 Context 는 여러가지 이유로 기존 플랫폼과는 다른 방식으로 어플리케이션을 관리하고 있고,
        // 때문에 기존 플랫폼들에서는 단순하게 시스템 API 를 통해 할 수 있는 일들을, Context 인스턴스라는 조금은 귀찮지만
        // 강력한 녀석을 통해 대행 처리하고 있다
        final Context context = parent.getContext();


        // 1> convertView 가 있는지 없는지 체크 null이면 새로 뷰를 만듬.
        if (convertView == null){ //보여주는 view가 없으면
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.custom_listview, parent, false); //내가 만든 listView로 끼워넣음.
        }

        //2> 위치에 해당하는 뷰 보여주기
        ImageView image = (ImageView) convertView.findViewById(R.id.img);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView context1 = (TextView) convertView.findViewById(R.id.context);




        // image, title, context1 셋팅!
        //즉 getter 메서드를 이용해서  해당 xml 문서 영역에 보여주기
        ListVO listViewitem = listVo.get(pos);
        image.setImageDrawable(listViewitem.getImg());
        title.setText(listViewitem.getTitle());
        context1.setText(listViewitem.getContext());


        //3> 보여지는 뷰의 값의 기능 부여
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 누르면 pos 통해 위치값을 찾고 화면에 몇 번째 위치인지 띄워준다.
                Toast.makeText(context, (pos + 1) + "번째 항목입니다", Toast.LENGTH_SHORT).show(); //pos가 0번부터이니까, +1더한다
            }
        });

        //4> 다 작성한 뷰를 리턴
        return convertView;


    }
}
