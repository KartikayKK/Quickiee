package com.example.quickiee;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.widget.Toast;

public class SService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast toast = Toast.makeText(context, "Message here", Toast.LENGTH_LONG);
        toast.show();


        android.os.Process.killProcess(android.os.Process.myPid());

    }
}
