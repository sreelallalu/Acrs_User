package com.acrs.userapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.acrs.userapp.di.ActivityContext;
import com.acrs.userapp.ui.dashboard.DashboardPresenter;
import com.acrs.userapp.ui.dashboard.DashboardView;
import com.acrs.userapp.ui.dashboard.Dashboard_i_presenter;
import com.acrs.userapp.ui.login.LoginPresenter;
import com.acrs.userapp.ui.login.LoginView;
import com.acrs.userapp.ui.login.Login_i_presenter;
import com.acrs.userapp.ui.register.RegisterPresenter;
import com.acrs.userapp.ui.register.RegisterView;
import com.acrs.userapp.ui.register.Register_i_presenter;

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

    @Provides
    Login_i_presenter<LoginView> login_i_presenter(LoginPresenter<LoginView> loginPresenter) {
        return loginPresenter;
    }

    @Provides
    Dashboard_i_presenter<DashboardView> dashboard_i_presenter(DashboardPresenter<DashboardView> presenter) {
        return presenter;
    }

    @Provides
    Register_i_presenter<RegisterView> register_i_presenter(RegisterPresenter<RegisterView> presenter) {
        return presenter;
    }


}
