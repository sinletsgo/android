package com.example.smart_03.ex511intent_2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("선호도 투표");

        //배열선언. final = 상수
        final int voteCount[] = new int[3];

        //배열에 값 초기화
        for (int i = 0; i < 3; i++){
            voteCount[i] = 0;
        }
        //이미지 뷰 관련 배열 선언
        ImageView image[] = new ImageView[3];

        //이미지 뷰 ID를 관리하기 위한 배열 --> id찾기
        Integer ImageId[] = { R.id.imageView1, R.id.imageView2,
                R.id.imageView3 };

        //이미지 이름 관리하기 위한 배열
        final String imgName[] = {"독서하는 소녀", "꽃장식모자소녀", "부채를 든 소녀"};

        //각 이미지 뷰를 클릭했을때 처리하는 부분
        //i가 아닌 index로 넣었기에, 계속 Click 이벤트가 발생하는게 아니다
        //for문 돌며 계속 image id값을 찾아서 onclick 대기하고 있으면서, 클릭했을때, 그때서야 반응하는것!
        //
        for (int i = 0; i < ImageId.length; i++){
            final int index;
            index = i; //index
            //id찾기
            image[index] = (ImageView) findViewById(ImageId[index]);
            //기능 부여
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++; //클릭할때마다 값 증가
                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총" +
                            voteCount[index] + " 표", Toast.LENGTH_SHORT).show();

                }
            });
        }


        //투표 종료 버튼 --> 기능 부여
        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount",voteCount);
                intent.putExtra("ImageName",imgName);

                startActivity(intent);

            }
        });


    }
}
