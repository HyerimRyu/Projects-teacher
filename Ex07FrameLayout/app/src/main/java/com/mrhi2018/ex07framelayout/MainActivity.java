package com.mrhi2018.ex07framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutBtns;
    LinearLayout layoutTvs;
    LinearLayout layoutImgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutBtns= findViewById(R.id.layout_btns);
        layoutTvs= findViewById(R.id.layout_tvs);
        layoutImgs= findViewById(R.id.layout_imgs);
    }

    public void clickBtn(View view) {

        layoutBtns.setVisibility(View.GONE);
        layoutTvs.setVisibility(View.GONE);
        layoutImgs.setVisibility(View.GONE);

        int id= view.getId();
        switch (id){
            case R.id.btn01:
                layoutBtns.setVisibility(View.VISIBLE);
                break;

            case R.id.btn02:
                layoutTvs.setVisibility(View.VISIBLE);
                break;

            case R.id.btn03:
                layoutImgs.setVisibility(View.VISIBLE);
                break;
        }

    }
}
