package com.mrhi2018.ex55recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datas= new ArrayList<>();

    RecyclerView rv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터들 추가
        datas.add( new String("aaa") );
        datas.add( new String("bbb") );
        datas.add( new String("ccc") );
        datas.add( new String("ddd") );
        datas.add( new String("eee") );
        datas.add( new String("aaa") );
        datas.add( new String("bbb") );
        datas.add( new String("ccc") );
        datas.add( new String("ddd") );
        datas.add( new String("eee") );
        datas.add( new String("aaa") );
        datas.add( new String("bbb") );
        datas.add( new String("ccc") );
        datas.add( new String("ddd") );
        datas.add( new String("eee") );

        rv= findViewById(R.id.recylcer);
        adapter= new MyAdapter(datas, getLayoutInflater());
        rv.setAdapter(adapter);

        //리사이클러뷰는 뷰(항목)들의 배치를 어떻게 할지 설정해주어야함.
//        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        rv.setLayoutManager(layoutManager);

    }
}
