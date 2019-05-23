package com.mrhi2018.ex10scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        ScrollView sv= findViewById(R.id.sv);
        //스크롤뷰의 스크롤바를 가장 아래로...
        sv.fullScroll(ScrollView.FOCUS_DOWN);
    }
}
