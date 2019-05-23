package com.mrhi2018.ex83fonttest;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tvTitle;

    AutoCompleteTextView actv;
    ArrayAdapter adapter;
    ArrayList<String> datas= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //기본으로 표시되는 제목글씨 안보이도록!!
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv= findViewById(R.id.tv);
        tvTitle= findViewById(R.id.tv_title);

        //폰트변경
        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/aaa.ttf");
        tv.setTypeface(typeface);
        tvTitle.setTypeface(typeface);


        //자동완성 에디트텍스트
        actv= findViewById(R.id.actv);
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        actv.setAdapter(adapter);

        //AutoCompleteTextView에서 자동완성으로 보여줄 항목들..
        datas.add("aaa");
        datas.add("abc");
        datas.add("aab");
        datas.add("adb");
        datas.add("bbb");
        datas.add("bba");
        datas.add("bcc");
        datas.add("ccc");
        datas.add("bbq");
    }
}














