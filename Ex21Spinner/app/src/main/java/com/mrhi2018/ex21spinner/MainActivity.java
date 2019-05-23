package com.mrhi2018.ex21spinner;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.spinner);
        adapter= ArrayAdapter.createFromResource(this, R.array.datas, R.layout.spinner_item);
        spinner.setAdapter(adapter);

        //스피터에게 드롭다운 모양을 주는게 아니라
        //어뎁터객체에게 주어야함.
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);



        //스피너의 항목의 선택이 변경되었을 때 반응하도록 리스너설정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resources res= getResources();
                String[] arr= res.getStringArray(R.array.datas);

                Toast.makeText(MainActivity.this, arr[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
















