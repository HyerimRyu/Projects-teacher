package com.mrhi2018.ex45fragmentpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Page3Fragment extends Fragment {

    //대량의 Data
    ArrayList<String> datas= new ArrayList<>();

    ListView listView;
    ArrayAdapter adapter;

    //프레그먼트가 처음 생성될 때 딱 1번만 호출되는 메소드
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //보통은 이곳에서 DB또는 서버의 데이터를 가져오는 작업수행
        datas.add("aaa");
        datas.add("bbb");
        datas.add("ccc");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_page3, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView= view.findViewById(R.id.listview);
        adapter= new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);

    }
}
