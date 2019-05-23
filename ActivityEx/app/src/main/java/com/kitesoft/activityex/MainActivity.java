package com.kitesoft.activityex;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datas= new ArrayList<String>();

    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);
        adapter= new ArrayAdapter(this, R.layout.listview_item, datas);
        listView.setAdapter(adapter);
    }

    public void clickBtn(View view) {

        Intent intent= new Intent(this, EditActivity.class);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch ( requestCode ){
            case 10:
                if(resultCode==RESULT_OK){
                    String name= data.getStringExtra("Name");
                    String nick= data.getStringExtra("Nick");
                    String title= data.getStringExtra("Title");
                    String content= data.getStringExtra("Content");

                    String str= name+"   " + nick + "\n\n" + title + "\n\n" + content;

                    datas.add( 0, str );
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
