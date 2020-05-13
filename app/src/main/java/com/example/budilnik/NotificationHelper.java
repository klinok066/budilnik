package com.example.budilnik;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    private NotificationManager mManager;

//    Uri ringURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//    Uri ringURI = Uri.(R.raw.daldal);
//    MediaPlayer mPlayer = MediaPlayer.create(this,ringURI);
//    long[] vibrate = new long[] { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000 };

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }
    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder getChannelNotification() {
        NotificationCompat.Builder Notification = new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Alarm!")
                .setContentText("WAKE UP!!!!!!!!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setOngoing(true)
//                .setSound(R.raw.daldal)
//                .setDefaults(Notification.DEFAULT_LIGHTS|
//                        Notification.DEFAULT_VIBRATE)
;

//        Notification.setSound(ringURI)
//                .setVibrate(vibrate);

        return  Notification;

    }
}