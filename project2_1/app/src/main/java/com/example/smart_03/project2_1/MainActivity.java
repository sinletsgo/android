package com.example.smart_03.project2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView text1, text2;

    CheckBox ChkAgree;

    RadioGroup rGroup1;
    RadioButton RdoDog, RdoCat, RdoRabbit;

    Button BtnOk;
    ImageView ImgPet;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        ChkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

        RdoDog = (RadioButton) findViewById(R.id.RdoDog);
        RdoCat = (RadioButton) findViewById(R.id.RdoCat);
        RdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);

        BtnOk = (Button) findViewById(R.id.BtnOk);
        ImgPet = (ImageView) findViewById(R.id.ImgPat);


        //checkbox의 선택 유무 체크할 이벤트!
        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //선택을 변경할때 발생하는 이벤트 리스너 등록
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //이벤트 핸들러
                if (ChkAgree.isChecked() == true){
                    //isChecked : checked 속성값을 알아볼때 사용
                    //화면에 보여주기
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    BtnOk.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                }else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    BtnOk.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);
                }
            }
        }); //CHECKBOX 영역에 대한 처리끝!


        //선택완료 버튼에 클릭 이벤트 부여!
        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:
                        ImgPet.setImageResource(R.drawable.dog);
                        //setImageResource --> android : src 동일 기능 --> 이미지불러오기
                        break;
                    case R.id.RdoCat:
                        ImgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        ImgPet.setImageResource(R.drawable.rabbit);
                        break;
                     default:
                         Toast.makeText(getApplicationContext(), "동물을 선택하세요", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
