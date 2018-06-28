package com.example.smart_03.ex604_1_gallery;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {
    Context context;
    Integer[] posterID = {R.drawable.mov35, R.drawable.mov36, R.drawable.mov37, R.drawable.mov38, R.drawable.mov39, R.drawable.mov40,
            R.drawable.mov41, R.drawable.mov42};

    //생성자

    public MyGalleryAdapter(Context c){
        context = c;

    }

    @Override
    public int getCount() {
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
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(200,300)); // Gallery 이미지 가로, 세로 크기

        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        //기능 부여
        final int pos = position;
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 분리하다 보니까, 좀 오류가 난다
                // MainActivity에 있는걸 찾아야 한다.
                // context는 class다.!
                // class 를 MainActivity로 형변환!

                ImageView ivPoster = ((MainActivity)context).findViewById (R.id.ivPoster);
                // ImageView ivposter ((appCompatActuvuty)context).finViewByid(R.id.ivPoster); 이렇게 해도 된다.
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[pos]);
                return false;
            }
        });


        return imageView;
    }
}
