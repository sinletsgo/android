package com.example.smart_03.ex604_3audio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // button 전역 변수 배열
    Button[] Buttons = new Button[8];

    // MediaPlayer 전역 변수 배열
    MediaPlayer[] mPlayesS = new MediaPlayer[8];
    int i; //아래 for  돌릴때, 인덱스 번호 체크할 변수. 없으면 err 난다..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("음악듣기");
        final MediaPlayer mPlayer1, mPlayer2, mPlayer3;
        Button btn1, btn2;

        //switch
        mPlayer1 = MediaPlayer.create(this,R.raw.song1);

        //button
        mPlayer2 = MediaPlayer.create(this, R.raw.song2);
        mPlayer2.setLooping(true); //끝까지 재생 한뒤에도 계속 자동재생

        //button
        mPlayer3 = MediaPlayer.create(this, R.raw.song3);
        mPlayer3.setLooping(false); //끝까지 재생 후 끝

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);


        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked() == true)

                    mPlayer1.start();
                else
                    mPlayer1.stop();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer2.isPlaying()) {
                    mPlayer2.pause();
                } else {
                    mPlayer2.start();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer3.isPlaying()) {
                    mPlayer3.pause();
                } else {
                    mPlayer3.start();
                }
            }
        });




//        Button button_do, button_re, button_mi, button_fa, button_sol, button_ra, button_si, button_doH;
//        button_do = (Button) findViewById(R.id.button_do);
//        button_re = (Button) findViewById(R.id.button_re);
//        button_mi = (Button) findViewById(R.id.button_mi);
//        button_fa = (Button) findViewById(R.id.button_fa);
//        button_sol = (Button) findViewById(R.id.button_sol);
//        button_ra = (Button) findViewById(R.id.button_la);
//        button_si = (Button) findViewById(R.id.button_si);
//        button_doH = (Button) findViewById(R.id.button_doH);

        //위와 같이 너무 반복되는 것 같아서, 짧게 줄여보았다.
        Integer[] BtnIDS  = {R.id.button_do, R.id.button_re, R.id.button_mi, R.id.button_fa, R.id.button_sol, R.id.button_la, R.id.button_si,R.id.button_doH };

        for (int i = 0; i< BtnIDS.length; i++){
            Buttons[i] = (Button) findViewById(BtnIDS[i]);
        }


//        final MediaPlayer mPlayer4, mPlayer5, mPlayer6, mPlayer7, mPlayer8, mPlayer9, mPlayer10, mPlayer11;
//        mPlayer4 = MediaPlayer.create(this, R.raw.do1);
//        mPlayer5 = MediaPlayer.create(this, R.raw.re2);
//        mPlayer6 = MediaPlayer.create(this, R.raw.mi3);
//        mPlayer7 = MediaPlayer.create(this, R.raw.fa4);
//        mPlayer8 = MediaPlayer.create(this, R.raw.sol5);
//        mPlayer9 = MediaPlayer.create(this, R.raw.ra6);
//        mPlayer10 = MediaPlayer.create(this, R.raw.si7);
//        mPlayer11 = MediaPlayer.create(this, R.raw.do8);

        // MediaPlayer 도 마찬가지로 짧게 줄여보았다
        Integer[] mplayerIDS = {R.raw.do1, R.raw.re2, R.raw.mi3, R.raw.fa4,R.raw.sol5,R.raw.ra6,R.raw.si7,R.raw.do8};

        for (int i = 0; i< mplayerIDS.length; i++){
            mPlayesS[i] = MediaPlayer.create(this, mplayerIDS[i]);
        }


        //        button_re.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mPlayer5.isPlaying()) {
//                    mPlayer5.pause();
//                } else {
//                    mPlayer5.start();
//                }
//            }
//        });.......... 너무 지저분하다.

        // for문으로 일일이 button 마다 이벤트 안줘도 편하게 끝낼 수 있다.
        for (i=0; i < BtnIDS.length; i++){
            final int index; //final 상수형
            index = i; //이렇게 해야 오류가 안난다
            //index 상수변수 로 접근해야 오류 안나고 잘 찾고, 이벤트 실행한다.
            Buttons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mPlayesS[index].isPlaying()) {
                        mPlayesS[index].pause();
                    } else {
                        mPlayesS[index].start();
                    }
                }
            });
        }




    }
}
