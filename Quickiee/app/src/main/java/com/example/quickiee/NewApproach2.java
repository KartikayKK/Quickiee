package com.example.quickiee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NewApproach2 extends AppCompatActivity {
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    static String jobbb;
    static int FIne;
    Integer time;
    TextView y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main3);
        y=findViewById(R.id.textView7);
        Intent in =getIntent();
        Bundle b=in.getExtras();
        if(b!=null){
            jobbb=b.getString("Task");
            time=b.getInt("Time");}
        y.setText(jobbb);
//Notify First
        //
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);

        Intent intentil = new Intent(getApplicationContext(),NewApproach2.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,0,intentil,0);
        //disable
        Intent intentpl = new Intent(getApplicationContext(),SService.class);
        PendingIntent contenIntent=PendingIntent.getBroadcast(this,0,intentpl,0);


        Notification notification = new NotificationCompat.Builder(this,Noti.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_access_time_black_24dp)
                .setContentTitle("You Will Be Reminded")
                .setContentText(NewApproach2.jobbb)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setColor(Color.BLUE)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                //.setContentIntent(contentIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.circle,"Disable",contenIntent)
                .build();
        notificationManagerCompat.notify(1,notification);
//Mainnnn
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, time);
        alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(NewApproach2.this,alarm.class);
        ComponentName receiver = new ComponentName(this, alarm.class);
        PackageManager pm = this.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);

        pendingIntent= PendingIntent.getBroadcast(NewApproach2.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        alarmManager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);


        //Extra

    }
    public void cancelAlarm(View view)
    {
        Intent intent = new Intent(this, alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
    }

     public void disable(View view) {
//Lets see
         ComponentName receiver = new ComponentName(this, alarm.class);
         PackageManager pm = this.getPackageManager();

         pm.setComponentEnabledSetting(receiver,
                 PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                 PackageManager.DONT_KILL_APP);
         android.os.Process.killProcess(android.os.Process.myPid());

         Toast.makeText(this, "Disabled broadcst receiver", Toast.LENGTH_SHORT).show();



        Intent intent=new Intent(NewApproach2.this,imp.class);
        startActivity(intent);
        super.onDestroy();
    }

}
