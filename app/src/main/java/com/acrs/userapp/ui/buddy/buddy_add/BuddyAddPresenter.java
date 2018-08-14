package com.acrs.userapp.ui.buddy.buddy_add;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

public class BuddyAddPresenter <T extends BuddyAddView> extends BasePresenter<T> implements BuddyAdd_i_presenter<T> {


    public BuddyAddPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
