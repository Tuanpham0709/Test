package com.example.test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WonderVNAPIService {

    // khai bao name API , Type, du lieu truyen len, data tra ve;
    @POST("Service/GetListPlace")
    Call<ResponseBody> getListPlace(@Body Object object);


}
