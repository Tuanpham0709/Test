package com.example.test;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.test.adapter.PlaceAdapter;
import com.example.test.model.Place.PlaceData;
import com.example.test.model.Place.Result;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Place extends AppCompatActivity implements PlaceAdapter.OnNoteListener{
    RecyclerView rvPlace;
    PlaceData placeData;
    ConstraintLayout clBtn;
    private  int mPlaceID;
    private  String mPlaceName;
    private  String mUrlLogoPlace;
    private  int mCategoryId;
    private  String mAddress;
    private  String mPhone;
    private  String mUrlWeb;
    private  String mDescriptionn;
    private  Object mUrlBanner;
    private  long mIsMorDetail;
    private  long mIsPromotion;
    private  double mLongitude;
    private  double mLatitude;
    private  String mKakaoTalk;
    private List<Object> listMedia;
    InfoPlace infoPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        getData();

    }
    private void getData(){

        GetListPlaceBody getListPlaceBody = new GetListPlaceBody(0, 0, "");
        Retrofit retrofit  = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(WonderVNAPIServiceData.class)
                .getListPlace(getListPlaceBody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                             String strJson = response.body().string();
                             Gson gson = new Gson();
                             placeData = gson.fromJson(strJson, PlaceData.class);
                            Log.e("PlaceData", placeData.getResult().toString());
                            configRvPlace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("onFaolure", "Failure");
                    }
                });

    }
    void init(){
        rvPlace = findViewById(R.id.rc_place);
        clBtn = findViewById(R.id.ct_bg);
    }
    public void configRvPlace() throws NullPointerException{
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlace.setLayoutManager(linearLayoutManager);
        PlaceAdapter placeAdapter = new PlaceAdapter();
        placeAdapter.setContext(this);
        placeAdapter.setListPlace(placeData.getResult(), this);
        rvPlace.setAdapter(placeAdapter);

    }
    public   void aadInfoPlace(int posititon){
        mPlaceID = placeData.getResult().get(posititon).getPlaceID();
        mPlaceName= placeData.getResult().get(posititon).getPlaceName();
        mUrlLogoPlace = placeData.getResult().get(posititon).getUrlLogoPlace();
        mCategoryId = placeData.getResult().get(posititon).getCategoryID();
        mAddress = placeData.getResult().get(posititon).getAddress();
        mPhone = placeData.getResult().get(posititon).getPhone();
        mUrlWeb = placeData.getResult().get(posititon).getUrlWeb();
        mUrlBanner = placeData.getResult().get(posititon).getUrlBanner();
        mLongitude = placeData.getResult().get(posititon).getLongitude();
        mLatitude = placeData.getResult().get(posititon).getLatitude();
        mKakaoTalk = placeData.getResult().get(posititon).getKakaoTalk();
        listMedia = placeData.getResult().get(posititon).getListMedia();
        mIsMorDetail = placeData.getResult().get(posititon).getIsMoreDetail();
        mIsPromotion = placeData.getResult().get(posititon).getIsPromotion();
        mCategoryId = placeData.getResult().get(posititon).getCategoryID();
        mDescriptionn = placeData.getResult().get(posititon).getDescription();
        infoPlace = new InfoPlace(mPlaceID,mPlaceName,mUrlLogoPlace,mCategoryId,mAddress,mPhone,mUrlWeb,mDescriptionn,mUrlBanner,mIsMorDetail,mIsPromotion,mLongitude,mLatitude,mKakaoTalk,listMedia);
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(Place.this, PlaceInfoActivity.class);
        Bundle bundle = new Bundle();
        aadInfoPlace(position);
        bundle.putParcelable("data",infoPlace );
        intent.putExtras(bundle);
        startActivity(intent);

    }

    class GetListPlaceBody{
        int cateID;
        int placeID;
        String searchKey;

        public GetListPlaceBody(int cateID, int placeID, String searchKey) {
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
