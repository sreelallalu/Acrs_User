package com.acrs.userapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.dashboard.DashboardActivty;
import com.acrs.userapp.ui.login.LoginActivity;

import javax.inject.Inject;

public class Splash extends AppCompatActivity {


    @Inject
    DataManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent=null;
        if (manager.getUserId() != null) {
             intent = new Intent(this, DashboardActivty.class);

        }else{
             intent = new Intent(this, LoginActivity.class);

        }
        final Intent finalIntent = intent;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(finalIntent);
            }
        },3000);

    }

    @Override
    public void onBackPressed() {

    }
}
