package com.acrs.userapp.ui.medicine.medicine_add;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

import javax.inject.Inject;

public class MedicineAddPresenter<T extends MedicineAddView> extends BasePresenter<T> implements MedicineAdd_i_presenter<T> {

    @Inject
    public MedicineAddPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
