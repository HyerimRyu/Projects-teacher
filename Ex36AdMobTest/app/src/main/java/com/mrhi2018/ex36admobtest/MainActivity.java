package com.mrhi2018.ex36admobtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //모바일 광고 초기화
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-1614211254887177~2553777898");


        //배너광고객체 참조하기
        adView= findViewById(R.id.adview);

        //광고요청
        AdRequest adRequest= new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void clickBtn(View view) {
        Intent intent= new Intent(this, InterstitialActivity.class);
        startActivity(intent);
    }

    public void clickBtn2(View view) {
        Intent intent= new Intent(this, RewardedActivity.class);
        startActivity(intent);
    }
}
