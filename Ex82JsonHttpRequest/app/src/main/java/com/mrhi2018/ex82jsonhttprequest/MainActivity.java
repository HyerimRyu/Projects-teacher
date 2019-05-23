package com.mrhi2018.ex82jsonhttprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    ArrayList<ItemVO> items= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycler);
        itemAdapter= new ItemAdapter(items, this);
        recyclerView.setAdapter(itemAdapter);

        //리사이클러뷰의 아이템뷰들 배치 관리자설정
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void clickLoad(View view) {
        //Volley+ 라이브러리를 이용하여 서버의 "loadDBtoJson.php"파일에 접속하여 결과를 받기!!
        String serverURL="http://mrhi2019.dothome.co.kr/Android/loadDBtoJson.php";

        //결과를 JSONArray로 받을 것이므로..JsonArrayRequest요청하고 결과를 받는 객체 생성
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(serverURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //응답을 성공적으로 받았을 때...
                //서버로부터 echo된 데이터..: 매개변수로 온 JsonArray
                try{

                    items.clear();//배열을 모든 요소 삭제
                    itemAdapter.notifyDataSetChanged();

                    for(int i=0; i<response.length(); i++){
                        JSONObject jsonObject= response.getJSONObject(i);

                        String num= jsonObject.getString("num");
                        String name= jsonObject.getString("name");
                        String msg= jsonObject.getString("msg");
                        String filePath= jsonObject.getString("filepath");
                        String date= jsonObject.getString("date");

                        //파일경로의 경우 서버IP가 제외된 주소(uploads/xxx.jpg)로 전달되어옴.
                        //그래서 바로 사용할 수 없음.
                        filePath= "http://mrhi2019.dothome.co.kr/Android/"+filePath;

                        //아이템데이터들을 가지고 있는 ArrayList에 추가
                        items.add(0, new ItemVO(num, name, msg, filePath, date) );
                        //화면갱신
                        itemAdapter.notifyItemInserted(0);
                    }

                }catch (Exception e){
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        //위에서 만든 JsonArrayRequest 요청객체를 동작되도록 하기위해
        //우체통에 넣기!!
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }

}
