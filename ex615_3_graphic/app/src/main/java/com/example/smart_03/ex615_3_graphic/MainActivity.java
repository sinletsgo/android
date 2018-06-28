package com.example.smart_03.ex615_3_graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static int LINE=1, CIRCLE=2, RECTANGLE=3, PATH=4; // 도형을 상수로 지정, 맨 밑에 switch 문에서 사용
    static int curshape=LINE; // 기본 선택한 도형
    static int curColor = Color.BLACK; // 기본색
    static int StrokeWidth = 5; // 기본 굵기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this)); // 내가만든 MyGraphicView 로 설정!
        setTitle("간단 그림판");
    }

    //메뉴 만들기
    //메뉴가 주. option menu 만드는걸 연습하라고 한것!
    // code - override methods 에서 상속받아서 사용
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // optionsmenu 우측 위 눌르면 나오는 메뉴
        // option 선택했을때 menu 매개변수 받고 id찾아서 switch 넣을것 셋팅
        menu.add(0, 1, 0, "선"); //itemId는 반드시 순서대로, 겹치면 뭘 불러오는지 모른다.
        menu.add(0, 2, 0, "원");
        menu.add(0,3,0,"사각형");

        //subMenu
        SubMenu sMenu = menu.addSubMenu("색상변경");
        sMenu.add(0,4,0,"빨강");
        sMenu.add(0,5,0,"파랑");
        sMenu.add(0,6,0,"초록");


        SubMenu sMenu2 = menu.addSubMenu("굵기변경");
        sMenu2.add(0,7,0,"10");
        sMenu2.add(0,8,0,"15");

        menu.add(0,9,0,"Path");

        return true;
    }

    // code - override methods 에서 상속받아서 사용
    @Override
    // option item 클릭하면 해당 itemid를 가져와서 그에 맞게 변수에 지정한 값을 대입 시킨다
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1: curshape=LINE; //선
                return true;
            case 2: curshape=CIRCLE; //원
                return true;
            case 3: curshape=RECTANGLE; // 사각형
                return true;
            case 4: curColor=Color.RED; //
                return true;
            case 5: curColor=Color.BLUE; //
                return true;
            case 6: curColor=Color.GREEN; //
                return true;

            case 7: StrokeWidth=10; //
                return true;
            case 8: StrokeWidth=15; //
                return true;

            case 9: curshape=PATH;   // PATH
                return true;

        }
        return super.onOptionsItemSelected(item);
        // 혹은 return false;
    }


    //커스텀 뷰 생성 --> 캔버스 공간 만들기
    private static class MyGraphicView extends View {
        //전역변수
        int startX =-1, startY= -1, stopX= -1, stopY = -1;
        public MyGraphicView(Context context){
            super(context);
        }

        //이벤트에 따라 좌표 계산
        // code - override methods 에서 상속받아서 사용
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN : //눌렀을때
                    startX = (int) event.getX(); //X 좌표
                    startY = (int) event.getY(); //y 좌표 --> 시작 지점
                    break;
                case MotionEvent.ACTION_MOVE: // 움직일때
                case MotionEvent.ACTION_UP:    // 뗐을때
                    stopX = (int) event.getX(); //X 좌표
                    stopY = (int) event.getY(); //y 좌표 --> 끝나는 지점
                    this.invalidate(); // 움직임 취소 --> 좌표 체크 기능 취소
                    break;
            }
            return true;
        }
        //그래픽 출력시 주로  onDraw () 메서드를 오버라이딩해서 사용
        //화면에 그려질 내용을 코딩
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true); // 이미지 외곽 부드럽게
            paint.setStrokeWidth(StrokeWidth); // 선굵기
            paint.setStyle(Paint.Style.STROKE); // 선그리기
            paint.setColor(curColor); // curColor 변수값 따라 색깔 변경
//            paint.setStyle(Paint.Style.FILL);  //채워진 원, 사각형

            switch (curshape){ // curshape = LINE 이면 전역변수에 LINE =1 이라고 지정해놓았기에, 밑에 1이 들어가서 해당 switch 문이 실행된다
                case LINE: canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX = startX, 2) + Math.pow(stopY-startY, 2) );
                    // Math.pow(x,2) -> x의 2승
                    // Math.sqrt : 루트
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(startX, startY, stopX, stopY);
                    canvas.drawRect(rect, paint);
                    // canvas.drawRoundRect()  모서리가 둥근 사각형
                    break;
                case PATH:
                    Path path1 =new Path();
                    path1.moveTo(startX, startY); //시작지점
                    path1.lineTo(startX+50, startY +50); //끝지점
                    path1.lineTo(startX+100, startY);
                    path1.lineTo(startX+150, startY +50);
                    path1.lineTo(startX+200, startY);
                    canvas.drawPath(path1, paint);

            }
        }
    }
}
