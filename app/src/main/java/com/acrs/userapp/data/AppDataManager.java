package com.acrs.userapp.data;

import android.content.Context;

import com.acrs.userapp.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by sreelal on 28/12/17.
 */
@Singleton
public class AppDataManager implements DataManager {
    private Context mContext;
    private SharedPresenter mPreferencesHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          SharedPresenter preferencesHelper) {
        mContext = context;

        mPreferencesHelper = preferencesHelper;

    }


    @Override
    public void setUserId(String centerid) {

    }

    @Override
    public void setUserDetails(String userDetails) {

    }
}
