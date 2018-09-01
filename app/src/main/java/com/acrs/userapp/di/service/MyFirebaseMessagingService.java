package com.acrs.userapp.di.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.acrs.userapp.R;
import com.acrs.userapp.data.AppDataManager;
import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.dashboard.DashboardActivty;
import com.acrs.userapp.ui.medicine.medicine_list.MedicineListActvity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by soorya on 31-05-18.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "firebase";
    private AppDataManager appDataManager;

    @Inject
    DataManager dataManager;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        if (remoteMessage.getData() != null && remoteMessage.getData().size() > 0) {

            try {

                String title = remoteMessage.getData().get("title");
                String message = remoteMessage.getData().get("text");

                {
                    sendNotificationNotification(title, message, remoteMessage.getData());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    private void sendNotificationNotification(String remoteMessage, String message, Map<String, String> data) throws Exception {
        String type = "";
        if (data.containsKey("type")) {
            type = data.get("type");
        }
        if (type.equals("medicine_add")) {

            String medicinetime = data.get("med_time");
            String title = data.get("title");
            String med_name = data.get("med_name");
            String who = data.get("who");
            String med_note = data.get("med_note");
            alarmSetting(medicinetime);

            Intent intent = new Intent(this, MedicineListActvity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(DashboardActivty.class);

            stackBuilder.addNextIntentWithParentStack(intent);
            //intent.putExtra(FIREBASE_DATA, remoteMessage);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent =
                    stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);



            //intent.putExtra(FIREBASE_DATA, remoteMessage);

            notifyMsg(title,med_name+" added by "+who,pendingIntent);


        }


//        int type = !data.isNull("type") ? data.get("type") : 0;

        // TODO: 18/7/18   type 1 for trainer and type 0 for citizen

        /*f (type == 1 && typeuser[0] != 0) {

            Intent intent = new Intent(this, ScheduleListActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(DashScheduleActivity.class);

            stackBuilder.addNextIntentWithParentStack(intent);
            //intent.putExtra(FIREBASE_DATA, remoteMessage);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent =
                    stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            notifyMsg(remoteMessage, message,pendingIntent);


        } else if (type == 0) {

            // TODO: 18/7/18 citizen logined
            if (typeuser[1] != 0) {
                Intent intent = new Intent(this, CitizenContentActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                stackBuilder.addParentStack(PublicDashActivity.class);
                stackBuilder.addNextIntentWithParentStack(intent);


                //        intent.putExtra(FIREBASE_DATA, remoteMessage);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent =
                        stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                notifyMsg(remoteMessage, message,pendingIntent);


            }
            // TODO: 18/7/18 trainer logined
            else if (typeuser[0] != 0) {
                Intent intent = new Intent(this, ContentsActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                stackBuilder.addParentStack(DashScheduleActivity.class);
                stackBuilder.addNextIntentWithParentStack(intent);
                // intent.putExtra(FIREBASE_DATA, remoteMessage);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent =
                        stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                notifyMsg(remoteMessage, message,pendingIntent);


            }


        }*/


    }

    private void alarmSetting(String medicinetime) {


    }

    private void notifyMsg(String title, String message, PendingIntent pendingIntent) throws Exception {
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.btn_star)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher))
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 ,notificationBuilder.build());

    }




    /*private void sendNotification(RemoteMessage remoteMessage) throws Exception {

        String messagebody = "";
        String data = null;

        if (remoteMessage != null && remoteMessage.getNotification() != null && remoteMessage.getNotification().getBody() != null) {
            messagebody = remoteMessage.getNotification().getBody().toString();
            if (remoteMessage.getData() != null && remoteMessage.getData().size() > 0) {
                data = remoteMessage.getData().toString();


              //  sendNotificationNotification(data);
                return;


            }




          *//*  Intent pintent = new Intent (this, Splash.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(NotificationActivity.class);



            Intent intent1 = new Intent(this, DashScheduleActivity.class);
            Intent intent2 = new Intent(this, Splash.class);
            Intent intent = new Intent(this, NotificationActivity.class);
            intent.putExtra(FIREBASE_DATA, data);
            stackBuilder.addNextIntent(intent2);
            stackBuilder.addNextIntent(intent1);
            stackBuilder.addNextIntent(intent);*//*

            Intent start = new Intent();





           *//* TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addNextIntentWithParentStack(intent);*//*

            Intent notifyIntent = new Intent(this, NotificationActivity.class);
            Intent dashIntent = new Intent(this, DashScheduleActivity.class);
            Intent splashIntent = new Intent(this, Splash.class);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

            stackBuilder.addNextIntent(splashIntent);
            stackBuilder.addNextIntentWithParentStack(dashIntent);

            dashIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent =
                    *//* stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
     *//*

                    PendingIntent.getActivity(this, 0, dashIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT);

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(android.R.drawable.btn_star)
                    .setContentTitle("Digital literacy")
                    .setContentText(messagebody)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0 *//* ID of notification *//*, notificationBuilder.build());
        }
    }*/


  /*  public void notifyMsg(String title, String message,PendingIntent pendingIntent) throws Exception{
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notification_small_one)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher))
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 *//* ID of notification *//*, notificationBuilder.build());
    }*/
}
