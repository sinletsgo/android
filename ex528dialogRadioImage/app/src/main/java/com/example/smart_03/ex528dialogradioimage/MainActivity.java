package com.example.smart_03.ex528dialogradioimage;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    RadioGroup rdoGroup;

    RadioButton rdoDog, rdoCat, rdoRabbit, rdoHorse;

    Button imageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("직접해보자");

        rdoGroup =(RadioGroup) findViewById(R.id.rdoGroup);

        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
        rdoHorse = (RadioButton) findViewById(R.id.rdoHorse);

        imageBtn = (Button) findViewById(R.id.imageBtn);


        //ImageResource 배열로 만듬.
        final Integer [] petID = {R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse};

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dialog1.xml을 이 MainActivity 에서 inflate로 만들어서 dialogView 객체 생성!
                View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                // AlertDialog로 띄워준다!
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);


                // dialogView에 있는 diaImage 이미지 뷰어 id찾기
                ImageView ivPet = (ImageView) dialogView.findViewById(R.id.diaImage);

                // getCheckedRadioButtonId 체크되있는 라디오버튼 id값 가져온다
                switch (rdoGroup.getCheckedRadioButtonId()){
                    case R.id.rdoDog:
                        ivPet.setImageResource(petID[0]);
                        dlg.setTitle("강아지");
                        break;
                    case R.id.rdoCat:
                        ivPet.setImageResource(petID[1]);
                        dlg.setTitle("고양이");
                        break;
                    case R.id.rdoRabbit:
                        ivPet.setImageResource(petID[2]);
                        dlg.setTitle("토끼");
                        break;
                    case R.id.rdoHorse:
                        ivPet.setImageResource(petID[3]);
                        dlg.setTitle("말");
                        break;
                }
                dlg.setView(dialogView); // 직접 만든 dialogView로 set
                dlg.setNegativeButton("닫기", null); // 닫기 버튼. 이벤트 없음
                dlg.show(); // dlg 보여준다

            }
        });

    }




}
