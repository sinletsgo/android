package com.example.smart_03.ex604_2gallerysp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // spinner 목록 보여줄 movie 배열
    final String[] movie = {"나홀로집에", "파이란", "더록", "로마의휴일", "매트릭스", "가위손", "slience of the lambs", "Ai"};
    Spinner spinner;

    Integer[] posterID = {R.drawable.mov35, R.drawable.mov36, R.drawable.mov37, R.drawable.mov38, R.drawable.mov39, R.drawable.mov40,
            R.drawable.mov41, R.drawable.mov42};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("스피너 사용");

        //id찾기;
        spinner = (Spinner) findViewById(R.id.spinner1);

        //arrayadapter 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);

        //기능 부여

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast 넣어주기  목록 누른것 메세지 띄운다
                // 목록에서 item 선택하면 그 위치가 position에 자동으로 매개변수 들어온다.
                Toast.makeText(getApplicationContext(), movie[position], Toast.LENGTH_SHORT).show();
                ImageView ivPoster = (ImageView) findViewById(R.id.imageView1);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}
