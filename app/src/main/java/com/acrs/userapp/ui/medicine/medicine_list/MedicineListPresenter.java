package com.acrs.userapp.ui.medicine.medicine_list;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.di.service.RestBuilderPro;
import com.acrs.userapp.ui.base.BasePresenter;
import com.acrs.userapp.ui.medicine.medicine_add.MedicineAddView;

import java.util.HashMap;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicineListPresenter<T extends MedicineListView> extends BasePresenter<T> implements MedicineList_i_presenter<T> {

    @Inject
    public MedicineListPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void medicineListApi(HashMap<String,String> hashMap) {
        RestBuilderPro.getService(MedicineListWebApi.class).medicinelist(hashMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
