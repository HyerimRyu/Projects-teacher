package com.mrhi2018.listviewheadertest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);

        View view= getLayoutInflater().inflate(R.layout.header, listView, false);
        listView.addHeaderView(view);

        final EditText et01= view.findViewById(R.id.et01);
        final EditText et02= view.findViewById(R.id.et02);

        et01.setText("01012345678");

        imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        et01.setOnFocusChangeListener(focusChangeListener);
        et02.setOnFocusChangeListener(focusChangeListener);

    }

    View.OnFocusChangeListener focusChangeListener= new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Log.i("TAG", v.getTag()+":"+hasFocus+" - touched : "+v.requestFocusFromTouch());
        }
    };


}
