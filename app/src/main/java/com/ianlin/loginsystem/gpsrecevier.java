package com.ianlin.loginsystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class gpsrecevier extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED"))
        {
            Toast.makeText(context,"GPS off",Toast.LENGTH_SHORT).show();
        }
    }

    public gpsrecevier() {
        super();
    }
}
