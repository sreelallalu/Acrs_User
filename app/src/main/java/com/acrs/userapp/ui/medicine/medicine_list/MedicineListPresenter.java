package com.acrs.userapp.ui.medicine.medicine_list;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

public class MedicineListPresenter<T extends MedicineListView> extends BasePresenter<T> implements MedicineList_i_presenter<T> {


    public MedicineListPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
