package com.acrs.userapp.ui.medicine.medicine_list;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.acrs.userapp.data.SharedHelper;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MedicineNotificationCancel extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            int notifiId = intent.getIntExtra("notification_id", 0);
            SharedPreferences editor = context.getSharedPreferences(SharedHelper.MAIN_DATA, Context.MODE_PRIVATE);
            editor.edit().putBoolean(SharedHelper.USER_NOTIFY, false).commit();
            NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            manager.cancel(notifiId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
