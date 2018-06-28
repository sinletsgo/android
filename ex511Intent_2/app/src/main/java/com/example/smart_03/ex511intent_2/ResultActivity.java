package com.example.smart_03.ex511intent_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("결과화면");


        //intent 받은 값, 배열이니 배열로 변수선언
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");


        //결과 표시하기위한 준비
        TextView tv[] = new TextView[imageName.length]; //length 길이 만큼의 TextView 배열방을 만들겠다! (여기선 3개)
        RatingBar rbar[] = new RatingBar[imageName.length];

        //id찾기위한 준비
        Integer tvid[] = {R.id.textView1, R.id.textView2, R.id.textView3 };
        Integer rbarId[] = {R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3 };

        //for문을 통해 id 찾기
        for(int i = 0; i < voteResult.length; i++){ //voteResult 길이만큼 id값 찾아서 배열에 차례대로 넣어서 결과를 찍기위해 준비!
            tv[i] = (TextView) findViewById(tvid[i]);
            rbar[i] = (RatingBar) findViewById(rbarId[i]);

        }

        //결과찍기
        for (int i = 0; i < voteResult.length; i++){
            tv[i].setText(imageName[i]); //그림 이름 찍기
//            rbar[i].setRating( (float) voteResult[i]);
            rbar[i].setRating( voteResult[i]); //Rating 을  voteResult대로 늘린다!
        }


        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // androidmanifest.xml -> 두번째꺼 코드 추가하기





    }

}
