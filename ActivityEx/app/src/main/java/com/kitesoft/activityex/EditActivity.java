package com.kitesoft.activityex;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    EditText etName, etNick, etTitle;
    EditText etContent;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etName= findViewById(R.id.ed_name);
        etNick= findViewById(R.id.ed_nick);
        etTitle= findViewById(R.id.ed_title);
        etContent= findViewById(R.id.ed_content);

        tv= findViewById(R.id.tv);

        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv.setText("글자수 : "+s.length()+"/500");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void clickComplete(View view) {
        AlertDialog dialog= new AlertDialog.Builder(this).setMessage("작성을 완료하시겠습까?").setNegativeButton("아니오", null).setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name= etName.getText().toString();
                String nick= etNick.getText().toString();
                String title= etTitle.getText().toString();
                String content= etContent.getText().toString();

                Intent intent= getIntent();
                intent.putExtra("Name", name);
                intent.putExtra("Nick", nick);
                intent.putExtra("Title", title);
                intent.putExtra("Content", content);

                setResult(RESULT_OK, intent);
                finish();
            }
        }).create();

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void clickCancel(View view) {

        AlertDialog dialog= new AlertDialog.Builder(this).setMessage("정말로 취소하시겠습니까?").setNegativeButton("아니오", null).setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).create();

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
}
