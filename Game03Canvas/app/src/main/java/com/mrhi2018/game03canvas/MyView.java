package com.mrhi2018.game03canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    //생성자 호출 후에 1회 자동 실행되는 메소드
    //이 메소드안에서 화면에 보일 내용을 그려내는 작업코딩
    @Override
    protected void onDraw(Canvas canvas) {
        //화가객체(canvas)에게 그려내는 작업 요청
        Paint paint= new Paint(); //그리는 도구 객체
        paint.setColor(Color.BLACK);

        canvas.drawRect(100, 100, 400, 200, paint);

        //Canvas의 변형
        canvas.save();
        
        canvas.rotate(30, 100, 150);
        canvas.drawRect(100, 100, 400, 200, paint);


        canvas.rotate(30, 100, 150);
        canvas.drawRect(100, 100, 400, 200, paint);

        //Canvas복원
        canvas.restore();

        paint.setColor(Color.BLUE);
        paint.setTextSize(100);
        canvas.drawText("aaa", 450, 200, paint);

        //원 그리기
        canvas.drawCircle(100, 700, 50, paint);


        canvas.scale(1.3f, 1.0f, 300, 700);
        canvas.drawCircle(300, 700, 50, paint);

        canvas.scale(1.0f, 1.3f, 500, 700);
        canvas.drawCircle(500, 700, 50, paint);



    }
}
