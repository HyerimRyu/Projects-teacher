package com.mrhi2018.onet25;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //xml에서 만든 View객체들의 참조변수
    TextView tv; //현재 눌러야될 버튼의 번호
    Button btnRetry; //재시작 버튼

    //Button참조변수가 25개짜리 배열객체 1개 생성
    Button[] btns= new Button[25];

    int num= 1; //현재 눌러야될 번호

    Drawable btnBack;//버튼의 기본 배경이미지 참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        btnRetry= findViewById(R.id.btn_retry);

        //버튼의 기본배경이미지를 얻어오기
        btnBack= btnRetry.getBackground();

        Random rnd= new Random();
        int[] arr= new int[25];
        for(int i=0; i<arr.length; i++){
            arr[i]= rnd.nextInt(25)+1;//1~25
            for(int k=0; k<i; k++){
                if(arr[i]==arr[k]){
                    i--;
                    break;
                }
            }
        }

        for(int i=0; i<btns.length; i++){
            btns[i]= findViewById(R.id.btn01+i);
            btns[i].setText(arr[i]+"");
            btns[i].setTag(arr[i]);
        }

    }//onCreate method..

    //onClick속성이 부여된 View가 클릭되면 자동으로 실행되는 콜백메소드
    public void clickBtn(View v){

        //다운캐스팅
        Button btn= (Button)v;

        //클릭된 View(버튼 v)에 써있는 Text를 얻어와서
//        String s= btn.getText().toString();
//        int n= Integer.parseInt(s);

        //저장된 tag를 읽어오기
        String s= btn.getTag().toString();
        int n= Integer.parseInt(s);

        //현재 눌러야될 번호(num)의 값과 같은지 비교!!
        if( n == num){
            //같으면 현재번째가 맞으므로..버튼의 글씨를 OK로 변경
            btn.setText("OK");
            btn.setTextColor(0xFFFF0000);
            btn.setBackgroundColor(Color.TRANSPARENT);//투명색
            //btn.setVisibility(View.INVISIBLE);
            num++;
            tv.setText(num+"");
        }

        if(num>25){
            tv.setText("CLEAR!!!");
            //리트라이 버튼이 활성화되도록!!
            btnRetry.setEnabled(true);
        }


    }//clickBtn method..

    public void clickRetry(View v){
        //모든버튼들에 다시 번호를 부여..
        Random rnd= new Random();
        int[] arr= new int[25];
        for(int i=0; i<arr.length; i++){
            arr[i]= rnd.nextInt(25)+1;//1~25
            for(int k=0; k<i; k++){
                if(arr[i]==arr[k]){
                    i--;
                    break;
                }
            }
        }


        //버튼들 모양 원위치...
        for(int i=0; i<btns.length; i++){
            btns[i].setText(arr[i]+"");
            btns[i].setTag(arr[i]);
            btns[i].setTextColor(Color.BLACK);
            btns[i].setBackgroundDrawable(btnBack);
        }

        //num초기화
        num=1;
        tv.setText(num+"");

        btnRetry.setEnabled(false);
    }

}//MainActivity..






















