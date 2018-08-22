package com.acrs.userapp.di.service;

import com.acrs.userapp.data.AppDataManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by soorya on 31-05-18.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "firebase";
    private AppDataManager appDataManager;



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {



        if (remoteMessage.getData() != null && remoteMessage.getData().size() > 0) {

            try {
                //JSONObject jsonObject = new JSONObject(remoteMessage.getData().toString());

                String title = remoteMessage.getData().get("title");
                String message = remoteMessage.getData().get("text");
               // String data = remoteMessage.getData().toString();


              /*  if (jsonObject.has("title")) {

                    String title = jsonObject.getString("title");
                    String message="";
                    if(jsonObject.has("text"))
                    {
                        message = jsonObject.getString("text");

                    }
                    String data = jsonObject.toString();*/

                    // TODO: 18/7/18 check user logined
                   /* int trianerId = appDataManager.getmPreferencesHelper().getTrainerId();


                    if (trianerId != 0 || citizenId != 0) {
                        sendNotificationNotification(title, message,remoteMessage.getData(), new int[]{trianerId, citizenId});
                    }
*/
               // }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    private void sendNotificationNotification(String remoteMessage, String message, Map<String,String> data, int[] typeuser) throws Exception {

        //JSONObject jsonObject = new JSONObject()
        int type = 0;
        if (data.containsKey("type")){
            type = Integer.parseInt(data.get("type"));
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
