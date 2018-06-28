package com.example.smart_03.ex525listalertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    View dialogView;
    TextView tvName, tvEmail;
    EditText dlgEdtName, dlgEdtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("사용자 정보 입력");
        button1 = (Button) findViewById(R.id.button1);


        //id 찾기
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);


        // 1> 인플레이트로 가져오기
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                // LayoutInflater inflater = getInflater();
                // View diaLogView = inflater.inflate(..., , , );

                // 2> AlertDialog 생성하기
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                // 3> 창 조절하기
                dlg.setTitle("사용자 정보 입력창");

                // 4> setView로 연결하기 --> setMassage, setItems 대신에 내가만든 dialogView xml로
                dlg.setView(dialogView);

                // 확인 버튼 클릭시 dialogView 에서 아이디, 이메일 가져와서 메인 액티비티에서 보여주는 이벤트 처리
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 여기서 dialogView id 찾아야 한다. 안그러면 사라진다고 함.
                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                        // dlgEdtName text 가져와서 메인 액티비티에 setText
                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());


                    }
                });

                //취소 버튼 동작
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"취소되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                //5> 보여주기
                dlg.show();

            }
        });




    }
}
