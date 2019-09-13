package com.example.quickiee;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.Service;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;

import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.content.Context.MODE_PRIVATE;


public class alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {





        MediaPlayer player = null;
        int a = context.getSharedPreferences("Hello",MODE_PRIVATE).getInt("INT",2);

        if (a==1){
            player = MediaPlayer.create(context, R.raw.crazy); //select music file
            player.setLooping(true); //set looping
        }else if (a ==2){
            player = MediaPlayer.create(context, R.raw.elegant); //select music file
            player.setLooping(true); //set looping
        }else if (a==3){
            player = MediaPlayer.create(context, R.raw.loud); //select music file
            player.setLooping(true); //set
        }
        player.start();
        System.out.println("hurrrrrrrrrrrrrrrrreeeeeeeeeeeeeeeeeeeeeeeyyyyyyyyyyyyyyyyyyyyyyyyyyyy" );




        //Working DOnt mess it up
//        final MediaPlayer mMediaPlayer;
//        try {
//            Uri alert =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
//            mMediaPlayer = new MediaPlayer();
//            mMediaPlayer.setDataSource(context, alert);
//            final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
//            if (audioManager.getStreamVolume(AudioManager.STREAM_RING) != 0) {
//                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_RING);
//                mMediaPlayer.setLooping(true);
//                mMediaPlayer.prepare();
//                mMediaPlayer.start();
//                Handler handler=new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mMediaPlayer.stop();
//                    }
//                }, 20 * 1000);
//            }
//        } catch(Exception e) {
//        }

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        Intent intentpl = new Intent(context,SService.class);
        PendingIntent contenIntent=PendingIntent.getBroadcast(context,0,intentpl,0);

        Notification notification = new NotificationCompat.Builder(context,Noti.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_access_time_black_24dp)
                .setContentTitle("You Are Reminded")
                .setContentText(NewApproach2.jobbb)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setAutoCancel(true)
                .addAction(R.drawable.circle,"Disable",contenIntent)
                .build();
        notificationManagerCompat.notify(1,notification);
    }
}
