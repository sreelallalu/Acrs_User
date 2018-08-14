package com.acrs.userapp.ui.register;


import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterWebApi {

    interface RegisterParms{

        String NAME="name";
        String MOBILE="mobile";
        String EMAIL="email";
        String PASSWORD="password";
    }
    @POST("d")
    @FormUrlEncoded
    Call<ResponseBody> register(@FieldMap HashMap<String,String> hashMap);
}
