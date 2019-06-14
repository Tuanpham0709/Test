package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.test.adapter.PromotionAdapter;
import com.example.test.model.Promotions.PromotionsData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class Promotion extends AppCompatActivity {
    RecyclerView rvPromotion;
    PromotionsData promotionsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        init();
        Gson gson = new Gson();
        String strPromotion = loadJSONFromAsset();
        try {
            promotionsData = gson.fromJson(strPromotion, PromotionsData.class);
            configRvPromotion();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public String loadJSONFromAsset(){
        String data;
        try {
            InputStream is = getAssets().open("Promotion.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            data = new String (buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
    public void configRvPromotion() throws NullPointerException{
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPromotion.setLayoutManager(linearLayoutManager);
        PromotionAdapter promotionAdapter = new PromotionAdapter(this, promotionsData.getResult());
        rvPromotion.setAdapter(promotionAdapter);

    }
    void init(){
        rvPromotion = findViewById(R.id.rv_promotion);
    }
}
