package com.mrhi2018.game06bubbletouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.util.ArrayList;

public class GameView extends View {

    int width, height; //화면 사이즈

    Bitmap imgBack;
    Bitmap[] imgBubble=new Bitmap[6];

    ArrayList<Bubble> bubbles= new ArrayList<>();

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        WindowManager wm= (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display= wm.getDefaultDisplay();
        width= display.getWidth();
        height= display.getHeight();

        Resources res= context.getResources();

        imgBack= BitmapFactory.decodeResource(res, R.drawable.sky);
        imgBack= Bitmap.createScaledBitmap(imgBack, width, height, true);

        for(int i=0; i<imgBubble.length; i++){
            imgBubble[i]= BitmapFactory.decodeResource(res, R.drawable.b0+i);
        }

        //행운의 편지 발송 시작!
        handler.sendEmptyMessageDelayed(0, 20);

    }//constructor...

    //버블들 움직이는 작업 메소드
    void moveBubbles(){

        for(int i= bubbles.size()-1; i>=0; i--){
            Bubble t= bubbles.get(i);

            t.move();
            if(t.isDead) bubbles.remove(i);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {

        //버블들의 좌표이동(움직이기)
        moveBubbles();

        //배경 그리기
        canvas.drawBitmap(imgBack, 0,0, null);

        //버블들 그리기
        for(Bubble t : bubbles){
            canvas.drawBitmap(t.img, t.x-t.rad, t.y-t.rad, null);
        }

    }//onDraw Method...

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action= event.getAction();

        switch ( action ){
            case MotionEvent.ACTION_DOWN:

                //터치다운한 좌표 얻어오기
                int x= (int)event.getX();
                int y= (int)event.getY();

                //터치다운한 지점(x,y)에 Bubble이 있는지 판별
                //있다면 제거!!!
                for(Bubble t: bubbles){
                    if( Math.pow(x-t.x, 2)+ Math.pow(y-t.y, 2)
                            <= Math.pow(t.rad, 2) ){
                        //있다면...제거!!
                        t.isDead=true;

                        //이 메소드를 종료
                        return true;
                    }
                }


                //터치다운한 지점에 Bubble객체 생성하기!

                for(int i=0; i<20; i++){
                    Bubble bubble= new Bubble(width, height, imgBubble, x, y);
                    bubbles.add(bubble);
                }



                break;
        }

        return true;
    }

    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            invalidate();//화면을 지우고 onDraw()메소드가 다시 호출
            handler.sendEmptyMessageDelayed(0, 20);
        }
    };


}//GameView class..
