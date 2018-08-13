package com.acrs.userapp.di.component;

import com.acrs.userapp.di.PerActivity;
import com.acrs.userapp.di.module.ActivityModule;
import com.acrs.userapp.ui.base.BaseActivity;
import com.acrs.userapp.ui.dashboard.DashboardActivty;
import com.acrs.userapp.ui.login.LoginActivity;
import com.acrs.userapp.ui.register.RegisterActivity;

import dagger.Component;


/**
 * Created by sreelal on 13/12/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    void inject(LoginActivity activtiy);

    void inject(DashboardActivty activtiy);
    void inject(RegisterActivity activtiy);

   /* void inject(BaseActivity activity);
    void inject(MainActvity activity);

    void inject(LoginActivity activity);

    void inject(RegisterActivity activity);

    void inject(ChangeActivity activity);

    void inject(ForgotActivity activity);
    void inject(SearchActivity activity);
    void inject(AppointmentActivity activity);

    void inject(ProfileActivity activity);
    void inject(NotificationActivity activity);
*/

}
