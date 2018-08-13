package com.acrs.userapp.ui.register;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

import javax.inject.Inject;

public class RegisterPresenter<T extends RegisterView> extends BasePresenter<T> implements Register_i_presenter<T> {



    @Inject
    public RegisterPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
