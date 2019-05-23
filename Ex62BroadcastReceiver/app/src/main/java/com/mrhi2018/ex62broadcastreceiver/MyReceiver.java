package com.mrhi2018.ex62broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //리시버가 방속을 수신하였을 때 자동 실행되는 메소드

        String action= intent.getAction();

        if(action.equals("aaa")){

            Toast.makeText(context, "aaa 받았다!!!!", Toast.LENGTH_SHORT).show();

        }else if( action.equals("bbb")){

            Toast.makeText(context, "bbb 받았다!!!!", Toast.LENGTH_SHORT).show();

        }else if( action.equals("android.provider.Telephony.SMS_RECEIVED")){

            Toast.makeText(context, "SMS 받았다!!!!", Toast.LENGTH_SHORT).show();

        }


    }
}
