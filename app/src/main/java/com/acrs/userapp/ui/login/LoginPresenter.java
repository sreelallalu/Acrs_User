package com.acrs.userapp.ui.login;

import com.acrs.userapp.R;
import com.acrs.userapp.data.DataManager;
import com.acrs.userapp.di.service.RestBuilderPro;
import com.acrs.userapp.ui.base.BasePresenter;

import java.util.HashMap;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter<T extends LoginView> extends BasePresenter<T>   implements Login_i_presenter<T>{

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void loginApiCall(HashMap<String,String> hashMap) {

        RestBuilderPro.getService().login(hashMap).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

               if(response.isSuccessful())
               {
                   try {
                       String res=response.body().string();
                       successResponse(res);
                   } catch (Exception e) {
                       e.printStackTrace();

                       getView().SnakBarString("Response error");
                       getView().onFailerApi();

                   }

               }else{
                   getView().SnakBarString("Login failed");
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


        getView().onSuccessApi();
    }
}