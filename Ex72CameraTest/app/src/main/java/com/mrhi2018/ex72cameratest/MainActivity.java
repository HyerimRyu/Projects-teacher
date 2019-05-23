package com.mrhi2018.ex72cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= findViewById(R.id.iv);
    }

    public void clickBtn(View view) {
        //Camera앱을 실행시키는 Intent생성
        Intent intent= new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        //새로운 액티비티(카메라앱)실행
        startActivityForResult(intent, 10);
    }

    //startActivityForResult()메소드로 실행한 화면이 종료되면
    //자동으로 실행되는 콜백메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:

                if( resultCode == RESULT_OK ){

                    //취득된 사진의 결과를 이미지뷰에 보여주기

                    //결과를 가지고 돌아온 3번째 파라미터(Intent객체 : data)에게
                    //결과를 달라고...
                    Uri uri= data.getData();//캡쳐된 사진 경로(Uri)를 얻어오기

                    //디바이스마다 프로그래밍으로 실행한 카메라앱은 자동 파일저장을
                    //안하도록!!! 대신 캡쳐된 이미지를 Bitmap객체로 전달해줌.
                    //만약, Bitmap으로 전달되었다면 파일이 저장되지 않았으므로
                    //파일경로인 Uri가 null이 됨.
                    if( uri != null ){
                        Toast.makeText(this, "uri", Toast.LENGTH_SHORT).show();
                        //iv.setImageURI(uri);

                        //Picasso라이브러리 사용
                        Picasso.get().load(uri).into(iv);

                    }else{
                        Toast.makeText(this, "Bitmap", Toast.LENGTH_SHORT).show();

                        //Bitmap객체를 Intent의 EXTRA데이터로 줌
                        //전달된 Bitmap이미지는 thumbnail 이미지임
                        Bundle bundle=data.getExtras();
                        Bitmap bm= (Bitmap)bundle.get("data");

                        Glide.with(this).load(bm).into(iv);

                        //요즘 대부분의 디바이스들이 Bitmap방식을 사용하므로
                        //캡쳐된 사진을 저장하려면 추가적인 작업들이 필요함.
                        //이 방법도 예전에 수월했느나 Nougat버전부터 어려워짐.
                        //File Provider 사용을 권장하고 있어서...
                    }


                }
                break;
        }

    }
}
