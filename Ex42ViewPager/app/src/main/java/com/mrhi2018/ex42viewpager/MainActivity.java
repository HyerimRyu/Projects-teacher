package com.mrhi2018.ex42viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //대량의 Data
    int[] datas= new int[]{R.drawable.gametitle_01,
                           R.drawable.gametitle_02,
                           R.drawable.gametitle_03,
                           R.drawable.gametitle_04,
                           R.drawable.gametitle_05,
                           R.drawable.gametitle_06,
                           R.drawable.gametitle_07,
                           R.drawable.gametitle_08,
                           R.drawable.gametitle_09,
                           R.drawable.gametitle_10};

    //ViewPager참조변수(AdapterView)
    ViewPager pager;
    MyAdapter adapter;

    TextView tv;//페이지1번에 텍스트뷰참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        pager= findViewById(R.id.pager);
        adapter= new MyAdapter(getLayoutInflater(), datas);
        pager.setAdapter(adapter);

        //페이지전화시에 효과주기!!(필수아님)
        //페이지가 조금이라도 움직일때마다 자동으로
        //발동하는 메소드를 보유한 리스너 추가
        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View view, float position) {

                view.setRotationY(position*90);
                view.setScaleX((1- Math.abs(position))/2+0.5f);
                view.setScaleY((1- Math.abs(position))/2+0.5f);
                view.setAlpha(1- Math.abs(position) );

            }
        });


    }

    public void clickBtn(View view){
        int index=pager.getCurrentItem();

        switch (index){
            case 0:
                break;

            case 1:
        }

        Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show();
    }

    public void clickNext(View view) {
        //현재페이지번호 알아오기
        int index= pager.getCurrentItem();
        //특정 페이지 이동..
        pager.setCurrentItem(index+1, true);
    }

    public void clickPrev(View view) {
        //현재페이지번호 알아오기
        int index= pager.getCurrentItem();
        //특정 페이지 이동..
        pager.setCurrentItem(index-1, true);
    }
}
