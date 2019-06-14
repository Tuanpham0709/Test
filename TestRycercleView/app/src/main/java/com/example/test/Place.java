package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.test.adapter.PlaceAdapter;
import com.example.test.model.Place.PlaceData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class Place extends AppCompatActivity {
    RecyclerView rvPlace;
    PlaceData placeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        Gson gson = new Gson();
        String strPlace = loadJSONFronAsset();
        Log.e("Place", strPlace);
        try {
            placeData = gson.fromJson(strPlace, PlaceData.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            configRvPlace();
            }catch (NullPointerException e){
            e.printStackTrace();
        }


    }
    void init(){
        rvPlace = findViewById(R.id.rc_place);
    }
    public String loadJSONFronAsset(){
        String data;
        try {
            InputStream is = getAssets().open("Place.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            data = new String (buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
            return "cccc";
        }

        return data;
    }
    public void configRvPlace() throws NullPointerException{
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlace.setLayoutManager(linearLayoutManager);
        PlaceAdapter placeAdapter = new PlaceAdapter();
        placeAdapter.setContext(this);
        placeAdapter.setListPlace(placeData.getResult());
        rvPlace.setAdapter(placeAdapter);
    }
}
