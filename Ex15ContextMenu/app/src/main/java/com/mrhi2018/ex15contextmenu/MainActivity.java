package com.mrhi2018.ex15contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);

        //액티비티에게 btn객체를 ContextMenu로 등록!
        registerForContextMenu(btn);

    }

    //ContextMenu로 등록된  View(btn)가 롱~클릭되면
    //컨텍스트메뉴를 만드는 메소드가 자동으로 실행!
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //메뉴아이템 추가
        //res>>menu>>context.xml문서를 읽어와서
        //메뉴객체로 생성시켜주는 능력을 가진 객체를 얻어오기
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.context, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //ContextMenu아이템을 선택했을때 자동으로 실행되는 메소드
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.menu_save:
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void clickBtn(View view) {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }
}
