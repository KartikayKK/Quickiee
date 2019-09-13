package com.example.quickiee;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Noti extends Application {
    public static final String CHANNEL_1="Channel1";
    public static final String CHANNEL_2="Channel2";


    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationsChannels();
    }
    private void createNotificationsChannels(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1,
                    "You Are Reminded",
                    NotificationManager.IMPORTANCE_HIGH
            ) ;
//            channel1.setLightColor();
            channel1.setDescription("This is channel !");
            //@
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2,
                    "You Are Reminded",
                    NotificationManager.IMPORTANCE_LOW
            ) ;
//            channel1.setLightColor();
            channel2.setDescription("This is a channel !");

            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
