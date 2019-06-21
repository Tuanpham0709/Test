package com.example.test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface WonderVNAPIServiceData {
    @POST("Service/GetListPlace")Call<ResponseBody> getListPlace(@Body Object object);
    // khai bao name API, Kieu, data chuyen len , data tra ve;
}
