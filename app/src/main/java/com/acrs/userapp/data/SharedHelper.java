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


    @Inject
    public SharedHelper(@ApplicationContext Context context) {

        this.mSharedPreferences = context.getSharedPreferences(MAIN_DATA, Context.MODE_PRIVATE);
    }


    @Override
    public void setUserId(String centerid) {

    }

    @Override
    public void setUserDetails(String userDetails) {

    }
}
