package com.mrhi2018.ex02_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //View들의 참조변수
    TextView tv;
    Button btn;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv1);
        btn= findViewById(R.id.btn);
        et= findViewById(R.id.et);

        //버튼이 클릭되는 것을 듣는 리스너객체 생성 및 설정
        btn.setOnClickListener(new View.OnClickListener() {
            //버튼이 클릭되는 자동으로 실행되는 메소드 : callback method.
            @Override
            public void onClick(View v) {
                //EditText에 써있는 글씨를 얻어오기
                Editable editable = et.getText();
                String str= editable.toString();

                //얻어온 글씨를 TextView에 설정하기
                tv.setText(str);

                //EditText의 글씨 지우기
                et.setText("");
            }
        });

    }
}
