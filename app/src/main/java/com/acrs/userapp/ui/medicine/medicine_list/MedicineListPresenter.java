package com.acrs.userapp.ui.medicine.medicine_list;

import com.acrs.userapp.R;
import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.di.service.RestBuilderPro;
import com.acrs.userapp.ui.base.BasePresenter;

import java.util.ArrayList;
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
                if (response.isSuccessful()) {
                    try {
                        String res = response.body().string();
                        successResponse(res);
                    } catch (Exception e) {
                        e.printStackTrace();

                        getView().SnakBarString("Response error");
                        getView().onFailerApi();

                    }

                } else {
                    getView().SnakBarString("Something went wrong");
                    getView().onFailerApi();

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                getView().SnakBarId(R.string.notconnect);
                getView().onFailerApi();
            }
        });
    }

    private void successResponse(String res) {

        getView().onSuccessApi(new ArrayList<MedicineListModel>());



      /*  if (response.getData() != null) {
            Gson gson = new Gson();
            if (response.getData() instanceof JSONArray) {
                Type listType = new TypeToken<List<ScheduleListModel>>() {
                }.getType();
                List<ScheduleListModel> list = gson.fromJson(response.getData().toString(), listType);
                // TODO: return data
                SuccessCase(list);

            } else {
                getView().snakbarShowString("no data available");
                FailerCase();
            }

        }else{
            FailerCase();
        }
*/
    }
}
