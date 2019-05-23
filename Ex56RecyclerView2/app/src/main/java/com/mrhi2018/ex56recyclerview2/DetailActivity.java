package com.mrhi2018.ex56recyclerview2;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        iv= findViewById(R.id.iv);

        //인텐트 객체가 전달되어 왔을 것임.
        //이 객체가 데이터를 가지고 있을 것임.
        Intent intent= getIntent();
        String name= intent.getStringExtra("Name");
        int imgId= intent.getIntExtra("Img", -1);

        if(imgId != -1) iv.setImageResource(imgId);
        getSupportActionBar().setTitle(name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //이미지뷰에 Transition의 Pair를 위한 이름 부여
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv.setTransitionName("IMG");
        }


    }
}
