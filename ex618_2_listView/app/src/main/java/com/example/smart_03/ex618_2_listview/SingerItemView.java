package com.example.smart_03.ex618_2_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

class SingerItemView extends LinearLayout{

    TextView textView1, textView2;
    ImageView imageView1;

    //생성자
    public SingerItemView(Context context){
        super(context);
        init(context);
    }
    public SingerItemView(Context context, Attributes attrs){
        super (context);
        init(context);
    }
    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView1 = (ImageView) findViewById(R.id.imageView);
    }

    //setter 메서드
    public void setName(String name) {
        textView1.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }

    public void setImage(int restId) {
        imageView1.setImageResource(restId);
    }
}
