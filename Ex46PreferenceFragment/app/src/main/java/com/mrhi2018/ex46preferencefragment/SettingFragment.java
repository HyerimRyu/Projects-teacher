package com.mrhi2018.ex46preferencefragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class SettingFragment extends PreferenceFragment {

    //설정 데이터를 보관 및 관리하는 객체 참조변수
    SharedPreferences pref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //별도의 화면 레이아웃파일(layout폴더)을 사용하지 않고
        //설정 xml문서를 통해 화면이 자동 생성

        //res폴더안에 xml폴더를 만들고
        //이 폴더안에 .xml문서를 만들고
        //<PreferenceScreen>클래스를 통해
        //화면 설계시작!- 미리보기도 가능
        addPreferencesFromResource(R.xml.setting);

        //Preference객체를 참조해오기..
        pref= PreferenceManager.getDefaultSharedPreferences(getActivity());

        //저장값 얻어오기
        final boolean isMessage= pref.getBoolean("message", false);
        Toast.makeText(getActivity(), ""+isMessage, Toast.LENGTH_SHORT).show();

        //설정값 변경 리스너 등록
        pref.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                if( key.equals("message")){
                    Toast.makeText(getActivity(), ""+isMessage, Toast.LENGTH_SHORT).show();
                }else if( key.equals("vibrate")){
                    boolean b= pref.getBoolean(key, false);
                    Toast.makeText(getActivity(), ""+b, Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
