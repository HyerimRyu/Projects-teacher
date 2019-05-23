package com.mrhi2018.game02touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( new MyView(this) );

        //제목줄 제거
        getSupportActionBar().hide();

        //상태표시줄 제거(전체화면 모드)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN );
    }

    //액티비티를 터치하는 이벤트가 발생하면 자동으로 실행되는 메소드
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Toast.makeText(this, "activity touch", Toast.LENGTH_SHORT).show();

        return super.onTouchEvent(event);
    }
}
