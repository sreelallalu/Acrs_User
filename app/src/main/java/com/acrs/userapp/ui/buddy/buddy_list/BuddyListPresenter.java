package com.acrs.userapp.ui.buddy.buddy_list;

import com.acrs.userapp.R;
import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.di.service.RestBuilderPro;
import com.acrs.userapp.ui.base.BasePresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        RestBuilderPro.getService(BuddyListWebApi.class).buddylist(hashMap).enqueue(new Callback<ResponseBody>() {
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

    private void successResponse(String res) throws JSONException {

        JSONObject jsonObject=new JSONObject(res);
        int succ=jsonObject.getInt("success");
        if(succ==1)
        {

            List<BuddyListModel> list_array=new ArrayList<>();
            JSONArray listarr=jsonObject.getJSONArray("data");
            for (int i = 0; i <listarr.length() ; i++) {

                JSONObject object=listarr.getJSONObject(i);
                String buddy_id=object.getString("buddy_id");
                String buddy_name=object.getString("buddy_name");
                String email=object.getString("email");
                String phone_no=object.getString("phone_no");
                String gender=object.getString("gender");
                String firebasetocken=object.getString("firebasetocken");
                String status=object.getString("status");
                String Message=object.getString("Message");

                BuddyListModel model=new BuddyListModel();
                model.setBuddy_id(buddy_id);
                model.setBuddy_name(buddy_name);
                model.setEmail(email);
                model.setFirebasetocken(firebasetocken);
                model.setGender(gender);
                model.setPhone_no(phone_no);
                model.setStatus(status);
                model.setMessage(Message);



                list_array.add(model);



            }
            getView().onSuccessApi(list_array);

        }else{
            getView().onFailerApi();
        }



    }
}

