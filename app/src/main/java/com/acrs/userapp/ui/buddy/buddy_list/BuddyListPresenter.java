package com.acrs.userapp.ui.buddy.buddy_list;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

public class BuddyListPresenter<T extends BuddyListView> extends BasePresenter<T> implements BuddyList_i_presenter<T> {


    public BuddyListPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
