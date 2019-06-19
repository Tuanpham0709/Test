package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.test.model.Place.PlaceData;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Placettt extends AppCompatActivity {
    TextView tvContent;
    PlaceData placeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placettt);
        init();
        getData();
    }
    void getData(){
        // Khai bao  + khoi tao retrofit
        getListPlaceBody getListPlaceBody = new getListPlaceBody(0,0,"");
        Retrofit retrofit  = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit
                .create(WonderVNAPIService.class)
                .getListPlace(getListPlaceBody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.e("onResponse", "Response");
                            String strJson = response.body().string();
                            tvContent.setText(strJson);
                            Gson gson =  new Gson();
                            placeData =gson.fromJson(strJson, PlaceData.class);
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("onFailure", "Failure");
                    }
                });

    }
    void init(){
        tvContent = findViewById(R.id.tv_content);
    }
    class getListPlaceBody{
        	int cateID;
            int placeID;
        	String searchKey;

        public getListPlaceBody(int cateID, int placeID, String searchKey) {
            this.cateID = cateID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }

        public int getCateID() {
            return cateID;
        }

        public void setCateID(int cateID) {
            this.cateID = cateID;
        }

        public int getPlaceID() {
            return placeID;
        }

        public void setPlaceID(int placeID) {
            this.placeID = placeID;
        }

        public String getSearchKey() {
            return searchKey;
        }

        public void setSearchKey(String searchKey) {
            this.searchKey = searchKey;
        }
    }
}
