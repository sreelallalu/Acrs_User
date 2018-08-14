package com.acrs.userapp.ui.emergency;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

public class EmergencyPresenter<T extends EmergencyView> extends BasePresenter<T> implements Emergency_i_presenter<T> {


    public EmergencyPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
