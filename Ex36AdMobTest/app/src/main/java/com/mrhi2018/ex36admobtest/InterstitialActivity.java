package com.mrhi2018.ex36admobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        //전면광고 객체 생성
        interstitialAd= new InterstitialAd(this);
        //광고단위 ID 부여
        interstitialAd.setAdUnitId("ca-app-pub-1614211254887177/5601122375");

        //광고요청
        AdRequest adRequest= new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        //광고가 load되는 것에 대한 리스너 객체 설정
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                //로드가 완료된 후 보여주도록!!
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                Toast.makeText(InterstitialActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });


        //광고보여줘 - 바로 보여지지 않음.
        //interstitialAd.show();


    }

    public void clickBtn(View view) {
        //광고 다시 보이도록 요청
        AdRequest adRequest= new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

    }
}
