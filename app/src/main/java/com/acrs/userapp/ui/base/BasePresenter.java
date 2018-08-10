package com.acrs.userapp.ui.base;

import android.content.Context;

/**
 * Created by sreelal on 22/1/18.
 */

public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {
    Context context;

   /* public BasePresenter(DataManager dataManager) {

        this.dataManager = dataManager;
    }
*/
    private T mMvpView;

    @Override
    public void onAttach(T mvpView) {

        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {

        mMvpView = null;
    }

    /*public DataManager getDataManager() {

        return dataManager;
    }

    public T getView() {
        return mMvpView;
    }*/
}
