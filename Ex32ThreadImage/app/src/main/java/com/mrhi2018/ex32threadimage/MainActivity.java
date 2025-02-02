package com.mrhi2018.ex32threadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= findViewById(R.id.iv);
    }

    public void clickBtn(View view) {


        //Glide라이브러리로 인터넷 이미지 읽어서
        //이미지뷰에 보여주기
        String imgUrl="https://i.pinimg.com/originals/88/2a/9d/882a9deb197de85fc2d79c2f1d86dc8a.jpg";
        Glide.with(this).load(imgUrl).into(iv);
        //별도로 AndroidManifest.xml에 인터넷퍼미션 작성해야함.







        //Network에 있는 이미지를 읽어와서 이미지뷰에 설정!
        //안드로이드는 Net작업은 반드시 별도의 Thread가 해야만 함.
        new Thread(){
            @Override
            public void run() {

                //이미지파일의 인터넷주소(URL)
                String imgUrl="https://i.pinimg.com/originals/88/2a/9d/882a9deb197de85fc2d79c2f1d86dc8a.jpg";

                //저 위의 인터넷서버 주소와 다리(Stream)를 연결하기 위해
                //해임달(URL) 객체 생성
                try {
                    URL url= new URL(imgUrl);
                    //해임달(url)로부터 무지개로드(Stream) 얻어오기
                    InputStream is= url.openStream();

                    //스트림을 통해서 이미지를 읽어와서 Bitmap객체로 참조
                    final Bitmap bm= BitmapFactory.decodeStream(is);
                    //이를 이미지뷰에 설정!
                    //ui변경작업은 UI스레드(Main스레드)에서 실행
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bm);
                        }
                    });

                } catch (MalformedURLException e) {
                    showToast("주소가 잘못되었습니다.");
                } catch (IOException e) {
                    showToast("데이터를 읽어올 수 없습니다.");
                }
            }//run method..

            void showToast(final String msg){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }.start();
    }
}













