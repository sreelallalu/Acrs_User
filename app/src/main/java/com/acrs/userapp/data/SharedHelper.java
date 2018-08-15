package com.acrs.userapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.acrs.userapp.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by sreelal on 14/12/17.
 */
@Singleton
public class SharedHelper implements SharedPresenter {
    private SharedPreferences mSharedPreferences;

    String MAIN_DATA="main_data";
    String USER_ID="user_id";
    String USER_DATA="user_data";
    String USER_NOTIFY="user_notifify";


    @Inject
    public SharedHelper(@ApplicationContext Context context) {

        this.mSharedPreferences = context.getSharedPreferences(MAIN_DATA, Context.MODE_PRIVATE);
    }


    @Override
    public void setUserId(String centerid) {
        mSharedPreferences.edit().putString(USER_ID,centerid).commit();
    }

    @Override
    public void setUserDetails(String userDetails) {
        mSharedPreferences.edit().putString(USER_DATA,userDetails).commit();

    }

    @Override
    public String getUserId() {
        return mSharedPreferences.getString(USER_ID,null);
    }

    @Override
    public String getUserdata() {
        return mSharedPreferences.getString(USER_DATA,null);
    }

    @Override
    public void setNotificationCancel(int id, boolean cancel) {
        mSharedPreferences.edit().putBoolean(USER_NOTIFY+id,true).commit();
    }

    @Override
    public boolean getNotificationCancel(int id) {
        return  mSharedPreferences.getBoolean(USER_NOTIFY+id,false);
    }
}
