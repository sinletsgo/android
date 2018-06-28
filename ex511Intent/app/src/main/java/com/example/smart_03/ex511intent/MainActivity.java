package com.example.smart_03.ex511intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    Button btn1;
    String Str_name;
    String Str_sex = "";
    String Str_sms = "";
    RadioButton r1, r2;
    CheckBox checkBox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("고객정보입력화면");

        editText1 = (EditText) findViewById(R.id.editText1);
        btn1 = (Button) findViewById(R.id.btn1);

        r1 = (RadioButton) findViewById(R.id.radioButton1);
        r2 = (RadioButton) findViewById(R.id.radioButton2);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력된 name 가져오기
                Str_name = editText1.getText().toString();


                // radio button 성별 판별
                if (r1.isChecked() == true){
                    Str_sex ="남";
                }
                if (r2.isChecked() == true){
                    Str_sex ="여";
                }

                //sms checkbox 판별
                if (checkBox1.isChecked() == true){
                    Str_sms ="수신함";

                }else {
                    Str_sms ="수신안함";
                }

                // 명시적 인텐트 예시!  다른 액티비티(ReceiveActivity)의 이름을 명확히 지정해서 데이터 전달하겠다!
                // 보내고 받고를 명시적으로 code로 넣어주고 하는것! 이게 아닌 그냥 sms처럼 보내기만 하고 애뮬에서 알아서 처리하도록 받는 code갖은것 안넣는게 암묵적!
                // 즉 메인 에서 intent에 data를 실어서 넘기고, 세컨드 에서 받은 데이터를 처리하는것!
                Intent it = new Intent(getApplicationContext(), ReceiveActivity.class);

                it.putExtra("it_name", Str_name); //인텐트 객체를 생성하고 변수에 부가 데이터를 넣기, it_name 임의로 지정 한 이름으로 서브에서 받는다.
                it.putExtra("it_sex", Str_sex);
                it.putExtra("it_sms", Str_sms);

                startActivity(it); //단순히 activity를 띄워서 화면에 보이도록 하는것!
//                finish();// 실행 후 끝낸다!, 다시 보려면 재실행 해야함. 그러니 보여주고 돌아가고 싶으면 삭제.




            }
        });


    }
}
