package com.mrhi2018.ex03imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //xml에서 만든 View객체들 참조변수
    ImageView iv;
    Button btn01;
    Button btn02;
    Button btn03;
    Button btn04;

    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= findViewById(R.id.iv);
        btn01= findViewById(R.id.btn01);
        btn02= findViewById(R.id.btn02);
        btn03= findViewById(R.id.btn03);
        btn04= findViewById(R.id.btn04);

        btn01.setOnClickListener(listener);
        btn02.setOnClickListener(listener);
        btn03.setOnClickListener(listener);
        btn04.setOnClickListener(listener);

        //ImageView에 clickable="true"속성을 부여하면
        //클릭에 반응할 수 있음.
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                if(num>=7) num=0;
                //이미지뷰의 이미지를 변경..차례로..변경
                iv.setImageResource(R.drawable.australia+num);
            }
        });

    }//onCreate Method....

    //클릭을 듣는 리스너 객체 생성
    View.OnClickListener listener= new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            int id= v.getId();

            switch (id){
                case R.id.btn01:
                    iv.setImageResource(R.drawable.australia);
                    break;

                case R.id.btn02:
                    iv.setImageResource(R.drawable.belgium);
                    break;

                case R.id.btn03:
                    iv.setImageResource(R.drawable.canada);
                    break;

                case R.id.btn04:
                    iv.setImageResource(R.drawable.korea);
                    break;
            }

        }
    };

}//MainActivity...
