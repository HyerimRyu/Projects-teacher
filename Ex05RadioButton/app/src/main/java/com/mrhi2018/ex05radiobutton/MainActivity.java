package com.mrhi2018.ex05radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView tv;

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg= findViewById(R.id.rg);
        tv= findViewById(R.id.tv);

        //RadioButton의 체크상태변경에 반응하려면..
        // RadioGroup에게 리스너를 설정해 주는 것이 좋음
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //체크된 RadioButton 참조하기
                RadioButton rb= findViewById(checkedId);
                tv.setText( rb.getText().toString() );

            }
        });


        ratingBar= findViewById(R.id.rating);
        ratingBar.setRating(2.5f);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText( rating +"점" );
            }
        });


    }

    public void clickBtn(View view) {

        //체크되어 있는 RadioButton을 알아내기!!
        //RadioGroup에게 물어보기.
        int checkedID= rg.getCheckedRadioButtonId();

        RadioButton rb= findViewById(checkedID);
        String text= rb.getText().toString();

        tv.setText(text);


    }
}
