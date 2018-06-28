package com.example.smart_03.ex618_1_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edtId, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = (EditText) findViewById(R.id.edtId);
        edtPass = (EditText) findViewById(R.id.edtPass);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtId.getText().toString();
                String password = edtPass.getText().toString();

                AppData.passsword = password; //공용데이터.

                //인스턴스화. 객체 만드는 과정!
                Intent intent = new Intent(getApplicationContext(), menuActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("password", password);
                startActivityForResult(intent, 101); //code값은 정수 아무값으로, 중복되지않게만 넣어주면 된다.
                // 보내기만 하고, response안받으면 startActivityForResult(intent) 만 해도 되는것!

            }
        });
    }

    // 보낸 request 에 대한 응답을 받는 부분
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            if (requestCode == 101){
                //받은 데이터 type 에 넣어서 Toast로 보여준다!
                String type = data.getStringExtra("type"); // type 이름으로 response 해준 data를 받는다
                Toast.makeText(this, "전달받은 데이터: " + type, Toast.LENGTH_LONG).show();
            }
        }
    }
}