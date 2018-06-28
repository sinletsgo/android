package com.example.smart_03.ex601gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridAdapter extends BaseAdapter {

    //변수 선언
    //Context 인스턴스를 통해서 android는 api를 관리하고 처리하고 한다. 그냥 쓰이는 패턴.
    Context context;

    //배열 선언
    //image 배열
    Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08};
    //title 배열
    String[] posterTitle = {"써니", "완득이","괴물", "라디오스타","비열한 거리", "왕의남자", "아일랜드", "웰컴투동막골"};

    // context 가 있는 생성자
    public MyGridAdapter(Context context){
        this.context=context;
    }

    @Override
    // 그리드뷰에 보여질 이미지의 개수를 반환하도록 수정
    public int getCount() { //전체 갯수
        return posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1> 이미지 뷰를 생성한 후 값 직접 보여줌.
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(300, 400)); //값 넘길 때 같이 넘겨서 이미지 뷰어 크기 설정
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);


        // 2> 기능 부여
        // click 하면 dialog 창을 띄워서 img
        final int pos = position;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (View) View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster); // dialog.xml에 ivPoster id찾고 ImageView 객체생성
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle(posterTitle[pos]);
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });

        // 3> 결과값 리턴
        // View type 이니까, view로 return
        return imageView;
    }
}
