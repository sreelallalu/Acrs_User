package com.acrs.userapp.ui.buddy.buddy_list;

import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.ui.base.BasePresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class BuddyListPresenter<T extends BuddyListView> extends BasePresenter<T> implements BuddyList_i_presenter<T> {

     @Inject
    public BuddyListPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void buddyList(HashMap<String, String> hashMap) {
        try {
            successResponse("");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    /*    RestBuilderPro.getService(BuddyListWebApi.class).buddylist(hashMap).enqueue(new Callback<ResponseBody>() {
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
        */

    }

    private void successResponse(String res) throws JSONException {

        String respo=BuddyListView.tempData;
        JSONObject jsonObject=new JSONObject(respo);
        List<BuddyListModel> list_array=new ArrayList<>();
        JSONArray listarr=jsonObject.getJSONArray("list");
        for (int i = 0; i <listarr.length() ; i++) {

            JSONObject object=listarr.getJSONObject(i);
            String name=object.getString("name");
            String number=object.getString("phone");
            int active=object.getInt("active");
            list_array.add(new BuddyListModel(name,number,active));

        }
        getView().onSuccessApi(list_array);


    }
}
