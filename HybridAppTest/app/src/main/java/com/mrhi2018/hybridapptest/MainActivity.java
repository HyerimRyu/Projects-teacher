package com.mrhi2018.hybridapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv= findViewById(R.id.wv);


        //웹뷰가 보여줄 웹문서(.html) 로드하기
        //하이브리드앱은 오프라인에서도 당연히 동작되야 하므로
        //웹문서가 이 프로젝트안에 위치해야 함.
        wv.loadUrl("file:///android_asset/test.html");
    }
}
