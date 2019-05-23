package com.kitesoft.widgetex;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView dialogIv;
    ImageView dialogBtn;

    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOverflow(View view) {
        Toast.makeText(this, "overflow", Toast.LENGTH_SHORT).show();
    }

    public void clickHeart(View view) {
        Toast.makeText(this, "Heart", Toast.LENGTH_SHORT).show();
    }

    public void clickComment(View view) {
        Toast.makeText(this, "Comment", Toast.LENGTH_SHORT).show();
    }

    public void clickSend(View view) {
        Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
    }

    public void clickBookmark(View view) {
        Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show();
    }

    public void clickImage(View view) {
        LayoutInflater inflater= getLayoutInflater();
        View layout= inflater.inflate(R.layout.item_cardview, null);

        new AlertDialog.Builder(this).setView(layout).create().show();

        dialogIv= layout.findViewById(R.id.item_iv);
        dialogIv.setImageResource(R.drawable.moana);
        dialogIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                if(n>=5) n=0;
                dialogIv.setImageResource(R.drawable.moana+n);
            }
        });

        dialogBtn= layout.findViewById(R.id.item_btn);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                if(n>=5) n=0;
                dialogIv.setImageResource(R.drawable.moana+n);
            }
        });


    }
}
