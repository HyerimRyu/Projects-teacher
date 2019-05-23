package com.mrhi2018.ex33threadprogress;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;

    int gauge=0;//막대바 프로그레스의 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //다이얼로그가 이미 있으면 새로 만들지 마시오!!
        if(dialog!=null) return;

        //wheel type progress dialog
        dialog= new ProgressDialog(this);
        dialog.setTitle("wheel dialog");
        dialog.setMessage("downloading.....");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        //3초뒤에 다이얼로그 종료.
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    Handler handler= new Handler(){
        //sendMessage()하면 자동으로 호출되는 메소드
        //우리는 딜레이를 주었으므로 3초 후에 실행되는 메소드
        @Override
        public void handleMessage(Message msg) {
            dialog.dismiss();
            dialog=null;
        }
    };

    public void clickBtn2(View view) {
        if( dialog!=null) return;

        //막대바 형태의 다이얼로그
        dialog= new ProgressDialog(this);
        dialog.setTitle("막대바 다이얼로그");
        dialog.setMessage("다운로딩 중.....");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.setMax(100); //기본값 : 100

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        dialog.setProgress(gauge);

        //상태바를 진행시키는 별도의 스레드 실행
        new Thread(){
            @Override
            public void run() {
                gauge=0;

                while (gauge<100){
                    gauge++;
                    dialog.setProgress(gauge);
                    //0.05초..대기
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                dialog.dismiss();
                dialog=null;
            }
        }.start();


    }
}
