package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.test.adapter.ContactAdapter;
import com.example.test.model.ContactData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class Contact extends AppCompatActivity {
    ContactData contactData;
    RecyclerView rcContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        String strContact = loadJSONFronAsset();
        Log.e("Contact" , strContact);
        Gson gson = new Gson();
        contactData = gson.fromJson(strContact, ContactData.class);
        configRvContact();



    }


    public void  configRvContact(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcContact.setLayoutManager(linearLayoutManager);
        ContactAdapter adapter = new ContactAdapter();
        adapter.setContext(this);
        adapter.setData(contactData.getResult());
        rcContact.setAdapter(adapter);

    }
    void init(){
        rcContact = findViewById(R.id.rc_contact);

    }
    public  String loadJSONFronAsset(){
        String data;
        try {
            InputStream is = getAssets().open("Contact.json");
            int size = is.available();
            byte[]  buffer = new byte[size];
            is.read(buffer);
            is.close();
            data = new String (buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
}
