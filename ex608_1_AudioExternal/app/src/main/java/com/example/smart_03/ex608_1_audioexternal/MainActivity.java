package com.example.smart_03.ex608_1_audioexternal;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewMP3;
    Button btnPlay, btnStop, btnPause;
    TextView textViewMP3;

    ArrayList<String> mp3List; // 배열 --> ArrayAdapter 연결
    String selectedMP3; //선택한 음악 이름 표시 변수

    //외장 디바이스의 기본 경로 값을 찾아옴 -> sdcard, storage/emulator     그 경로를 아래 써줘야한다
    // Environment 환경
    // music 폴더에 mp3 3개 넣어두었다.
    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/music/";

    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("mp3플레이어");


        //외부 저장 장치 접근 권한 --> androidManifest.xml 에서 준게 인식이 안되서 여기도 추가.
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        // mp3 음악 명으로 구성할 ArrayList 생성!
        mp3List  = new ArrayList<String>();

        //file 클래스 다루기
        File[] listFiles = new File(mp3Path).listFiles();

        //listFiles() : 해당 경로 폴더안에 있는 모든 파일을 컬렉션 타입으로
        String fileName, extName; //파일이름, 확장자 저장 변수
        for (File file : listFiles){ // mp3Path 안에 있는 file들에 하나씩 접근
            fileName = file.getName(); //getName() : 파일 이름
            extName = fileName.substring(fileName.length()-3); //시작위치부터 끝까지 추출. 즉 확장자 .mp3만 가져오는것
            if (extName.equals( (String) "mp3")){
                mp3List.add(fileName); // ArrayList에 추가
            }
        }
        listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, mp3List);

        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // 1개만 선택할 수 있는 mode
        listViewMP3.setAdapter(adapter); // listView 와 arrayadapter 연결
        listViewMP3.setItemChecked(0, true); // 첫번째값 디폴트

        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedMP3= mp3List.get(position); // 선택한 위치에 list 명을 가져온다
            }
        });
        selectedMP3 = mp3List.get(0); //첫번째 노래로 Default. 즉 초기값 설정

        //재생 , 정지 기능
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause= (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        textViewMP3 = (TextView) findViewById(R.id.textViewMP3);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3); //경로 찾아서 재생할 음악 셋팅
                    mPlayer.prepare(); // 재생준비
                    mPlayer.start(); //재생
                    btnPlay.setClickable(false); // 클릭 비활성화
                    btnStop.setClickable(true); // 활성화
                    textViewMP3.setText("실행중인 음악: " + selectedMP3);

                } catch (IOException e){
                    e.printStackTrace(); //기본 exception print 로 설정
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mPlayer.stop();
                    mPlayer.reset();
                    btnStop.setClickable(false); // 클릭 활성화
                    btnPlay.setClickable(true); // 활성화

                    textViewMP3.setText("실행중인 음악: " + selectedMP3);

                    btnPause.setText("일시정지");

            }
        });
        btnStop.setClickable(false);
        
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer.isPlaying()){
                    mPlayer.pause();
                    btnPause.setText("이어듣기");
                } else {
                    btnPause.setText("일시정지");
                    mPlayer.start();

                }
            }
        });

    }
}
