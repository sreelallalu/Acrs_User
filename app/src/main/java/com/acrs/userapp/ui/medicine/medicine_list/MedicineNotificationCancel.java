package com.acrs.userapp.ui.medicine.medicine_list;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.acrs.userapp.data.DataManager;

import javax.inject.Inject;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MedicineNotificationCancel extends BroadcastReceiver {


    @Inject
    DataManager dataManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            int notifiId = intent.getIntExtra("notification_id", 0);

            NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            manager.cancel(notifiId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
