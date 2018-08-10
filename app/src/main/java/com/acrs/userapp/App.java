package com.acrs.userapp;

import android.app.Application;

import com.acrs.userapp.di.component.ApplicationComponent;
import com.acrs.userapp.di.component.DaggerApplicationComponent;
import com.acrs.userapp.di.module.ApplicationModule;

public class App extends Application {

    public ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
        // applicationComponent.provideSharedpreference(this);



    }

    public ApplicationComponent getComponent() {

        return applicationComponent;
    }
}
