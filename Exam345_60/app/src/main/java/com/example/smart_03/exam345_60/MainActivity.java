package com.example.smart_03.exam345_60;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {






    EditText editTextName, editTextMorning, editTextLunch, editTextDinner; //이름 및 칼로리 입력

    TextView textViewRusult; // 결과값 보여줄 텍스트 뷰어



    String numMorning, numLunch, numDinner; // 칼로리 입력 값 가져올 변수

    Double resultSum; // 칼로리 입력 값 총 합 변수

    Double resultFinal; // 최종 값 변수



    // 시작함 버튼 클릭 이벤트 위한 체크박스 변수들
    CheckBox checkBox;

    LinearLayout L1, L2, L3, L4;

    RadioGroup rGroup1;

    RadioButton Rdo1, Rdo2, Rdo3;

    Button BtnOk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewRusult = (TextView) findViewById(R.id.textViewRusult);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextMorning = (EditText) findViewById(R.id.editTextMorning);
        editTextLunch = (EditText) findViewById(R.id.editTextLunch);
        editTextDinner = (EditText) findViewById(R.id.editTextDinner);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

        Rdo1 = (RadioButton) findViewById(R.id.Rdo1);
        Rdo2 = (RadioButton) findViewById(R.id.Rdo2);
        Rdo3 = (RadioButton) findViewById(R.id.Rdo3);

        BtnOk = (Button) findViewById(R.id.BtnOk);


        L1 = (LinearLayout) findViewById(R.id.L1);
        L2 = (LinearLayout) findViewById(R.id.L2);
        L3 = (LinearLayout) findViewById(R.id.L3);
        L4 = (LinearLayout) findViewById(R.id.L4);



        //checkbox의 선택 유무 체크할 이벤트!
        // 아래 여러개하면 힘드니까 LinearLayout 버티컬로 한번에 묶은 다음에 할 수도 있다!
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //선택을 변경할때 발생하는 이벤트 리스너 등록
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //이벤트 핸들러
                if (checkBox.isChecked() == true){
                    //isChecked : checked 속성값을 알아볼때 사용
                    //화면에 보여주기
                    L1.setVisibility(View.VISIBLE);
                    L2.setVisibility(View.VISIBLE);
                    L3.setVisibility(View.VISIBLE);
                    L4.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    BtnOk.setVisibility(View.VISIBLE);
                    textViewRusult.setVisibility(View.VISIBLE);

                }else {
                    L1.setVisibility(View.INVISIBLE);
                    L2.setVisibility(View.INVISIBLE);
                    L3.setVisibility(View.INVISIBLE);
                    L4.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    BtnOk.setVisibility(View.INVISIBLE);
                    textViewRusult.setVisibility(View.INVISIBLE);
                }
            }
        }); //CHECKBOX 영역에 대한 처리끝!






        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // total sum 계산
                numMorning = editTextMorning.getText().toString();
                numLunch = editTextLunch.getText().toString();
                numDinner = editTextDinner.getText().toString();
                resultSum = Double.parseDouble(numMorning) + Double.parseDouble(numLunch) +Double.parseDouble(numDinner); //int말고 double로 해야 나중에 *할 때 문제안생김

                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.Rdo1:
                        resultFinal =  resultSum * 1.2;
                        textViewRusult.setText(editTextName.getText().toString() + "님의 총 칼로리 섭취량은" + resultFinal.toString()  );
                        break;

                    case R.id.Rdo2:
                        resultFinal =  resultSum * 1.35;
                        textViewRusult.setText(editTextName.getText().toString() + "님의 총 칼로리 섭취량은" + resultFinal.toString()  );
                        break;

                    case R.id.Rdo3:
                        resultFinal =  resultSum * 1.4;
                        textViewRusult.setText(editTextName.getText().toString() + "님의 총 칼로리 섭취량은" + resultFinal.toString()  );
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "칼로리를 선택하세요", Toast.LENGTH_SHORT).show();

                }
            }
        });




    }
}
