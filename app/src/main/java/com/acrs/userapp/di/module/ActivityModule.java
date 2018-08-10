package com.acrs.userapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.acrs.userapp.di.ActivityContext;

import dagger.Module;
import dagger.Provides;


/**
 * Created by sreelal on 13/12/17.
 */
@Module
public class ActivityModule {
    AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {

        this.activity = activity;
    }




    @Provides
    @ActivityContext
    Context provideContext() {

        return activity;
    }


    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }



}
