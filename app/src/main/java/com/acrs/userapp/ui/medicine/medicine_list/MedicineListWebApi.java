package com.acrs.userapp.ui.medicine.medicine_list;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MedicineListWebApi {



    @POST("")
    @FormUrlEncoded
    Call<ResponseBody> medicinelist(@FieldMap HashMap<String,String> hashMap);
}
