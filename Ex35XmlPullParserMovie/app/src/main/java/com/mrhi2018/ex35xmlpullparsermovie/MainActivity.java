package com.mrhi2018.ex35xmlpullparsermovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String apiKey="2b2401938016fc2c1213dde5615435b5";

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> datas= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);

    }

    public void clickBtn(View view) {
        //안드로이드에서는 네트워크 작업은 무조건 별도의 Thread가 해야함
        //중요!! 인터넷작업은 반드시 허가(permission)을 받아야함.-Manifest.xml에..
        new Thread(){
            @Override
            public void run() {
                //서버로부터 xml문서를 읽어오기!!



                SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");

                Date date= new Date();//오늘 날짜를 가진 객체
                date.setTime(  date.getTime()-1000*60*60*24   );//1일전

                //일별박스오피스의 날짜 문자열
                String day= sdf.format(date);

                //서버 주소(URL)
                String address=" http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml"
                              +"?key="+apiKey
                              +"&targetDt="+day
                              +"&itemPerPage=10";

                //String address="http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=430156241533f1d058c603178cc3ca0e&targetDt=20181219";

                //서버 주소까지 스트림을 만들 수 있는 능력의 해임달(URL)객체 생성
                try {
                    //해임달 객체
                    URL url= new URL(address);

                    //무지개로드 열기
                    InputStream is= url.openStream();//바이트 데이터를 읽어들임
                    InputStreamReader isr= new InputStreamReader(is);//바이트를 문자단위로 변환해서...읽어줌

                    //XML을 분석(parse)해주는 객체 생성
                    XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                    XmlPullParser xpp= factory.newPullParser();
                    xpp.setInput(isr);//이 때 xml문서를 읽어들임.

                    //xpp를 이용해서 xml문서 분석!!
                    int eventType= xpp.getEventType();

                    String tagName=null;
                    String text=null; //태그문 사이의 글씨(값)

                    //String을 만들어 주는 객체
                    StringBuffer buffer=null;

                    while(eventType!=XmlPullParser.END_DOCUMENT){

                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:
                                //별도의 Thread는 화면 변경작업을 할 수 없음.
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "파싱시작!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                                break;

                            case XmlPullParser.START_TAG:
                                tagName= xpp.getName();

                                if(tagName.equals("dailyBoxOffice")){
                                    buffer= new StringBuffer();
                                }else if( tagName.equals("rank")){
                                    buffer.append("순위 : ");
                                    xpp.next();
                                    text= xpp.getText();
                                    buffer.append(text+"\n");

                                }else if( tagName.equals("movieNm")){
                                    buffer.append("제목 : ");
                                    xpp.next();
                                    buffer.append( xpp.getText()+"\n" );

                                }else if( tagName.equals("openDt")){
                                    buffer.append("개봉일 : ");
                                    xpp.next();
                                    buffer.append( xpp.getText()+"\n" );

                                }else if( tagName.equals("audiAcc")){
                                    buffer.append("누적관객수 : ");
                                    xpp.next();
                                    buffer.append( xpp.getText()+"\n" );

                                }

                                break;

                            case XmlPullParser.TEXT:
                                break;

                            case XmlPullParser.END_TAG:
                                tagName= xpp.getName();

                                if( tagName.equals("dailyBoxOffice")){
                                    //하나의 아이템이 끝났다..
                                    String data= buffer.toString();//버퍼에 누적된 글씨들을 문자열객체로 만들기
                                    //ArrayList에 추가.
                                    datas.add(data);
                                    //리스트뷰의 화면 갱신(Adapter에게 데이터 변경사실을 통지)
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });

                                }
                                break;
                        }


                        xpp.next();
                        eventType= xpp.getEventType();

                    }//while

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "파싱완료", Toast.LENGTH_SHORT).show();
                        }
                    });


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


            }
        }.start();


    }
}
