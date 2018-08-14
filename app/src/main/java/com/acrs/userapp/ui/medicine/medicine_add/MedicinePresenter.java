package com.acrs.userapp.ui.medicine.medicine_add;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

public class MedicinePresenter<T extends MedicineView> extends BasePresenter<T> implements Medicine_i_presenter<T> {


    public MedicinePresenter(DataManager dataManager) {
        super(dataManager);
    }
}
