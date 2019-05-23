package com.mrhi2018.ex62broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "TEST 리시버입니다.!!!!", Toast.LENGTH_SHORT).show();
    }
}
