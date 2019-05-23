package com.mrhi2018.ex42viewpager;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MyAdapter extends PagerAdapter {

    int[] datas;
    LayoutInflater inflater;

    TextView tv, tv2;
    ToggleButton toggleButton;

    TextView tv, tv2;
    ToggleButton toggleButton;

    TextView tv, tv2;
    ToggleButton toggleButton;

    //생성자
    public MyAdapter(LayoutInflater inflater, int[] datas){
        this.inflater= inflater;
        this.datas= datas;
    }


    //ViewPager에 보여줄 View를 만들어내는 작업 메소드.
    //ViewPager에 의해서 자동으로 호출되는 메소드
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //첫번째 파라미터 (container) : ViewPager참조변수
        //두번째 파리미터 (position) : 페이지번호(0~~~)

        //layout폴더에 있는 page.xml라는 설계도면으로
        //View객체를 생성
        //xml문서를 View객체로 만들어주는(부풀리는 inflate) 객체에게 요청
        if(position==0)View view= inflater.inflate(R.layout.page1, null);
        else if(position==1) View view= inflater.inflate(R.layout.page2, null);

        //xml도면대로 만들어진 페이지(view)의 Contents 연결하기
        ImageView iv= view.findViewById(R.id.iv);
        iv.setImageResource(datas[position]);

       tv= view.findViewById(R.id.tv);

        toggleButton= view.findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText("aaa");
            }
        });


        //만들어진 페이지(view)를 ViewPager에 추가하기!!
        container.addView(view);

        //만들어진 뷰가 ViewPager의 뷰에 맞는지 검증화도록 리턴!!
        return view;
    }

    //뷰페이저가 보여줄 View와 instantiateItem()메소드의 리턴된
    //뷰가 같은지 검증하는 메소드
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view==obj;
    }

    //ViewPager가 필요없다고 생각하는 뷰를 없애는 메소드
    //ViewPager에 의해서 자동으로 호출되는 메소드
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //세번째 파라미턴: 제거대상이 된 View객체(object)
        container.removeView( (View)object );
    }

    @Override
    public int getCount() {
        return datas.length;
    }


}
