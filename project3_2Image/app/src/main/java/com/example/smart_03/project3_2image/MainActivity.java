package com.example.smart_03.project3_2image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Btn_Change;

    ImageView View1, View2;

    int imageIndex ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("이미지를 바꿔보자");
        Btn_Change = (Button) findViewById(R.id.btn_Change) ;
        View1 = (ImageView) findViewById(R.id.imageView1) ;
        View2 = (ImageView) findViewById(R.id.imageView2) ;

        // 1. ID 값 가져와서 occlick 메소드 기능 추가!
//        Btn_Change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (imageIndex == 0) {
//                    View1.setVisibility(View.VISIBLE);
//                    View2.setVisibility(View.INVISIBLE);
//                    imageIndex = 1;
//                }else if (imageIndex == 1){
//                    View1.setVisibility(View.INVISIBLE);
//                    View2.setVisibility(View.VISIBLE);
//                    imageIndex = 0;
//                }
//            }
//        });
    }
    // 2. 직접 ONCLICK 함수 넣어서 호출

    public void changeImage(View v){
        if (imageIndex == 0) {
            View1.setVisibility(View.VISIBLE);
            View2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        }else if (imageIndex == 1){
            View1.setVisibility(View.INVISIBLE);
            View2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}

//    public void changeImage(View v){
//        Toast.makeText(getApplicationContext(),"버튼 눌렀어!", Toast.LENGTH_SHORT).show();
//    }