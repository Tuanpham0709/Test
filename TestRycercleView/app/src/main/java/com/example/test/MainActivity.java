package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Button btn_contact, btn_place, btn_promotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Place.class);
                startActivity(intent);
            }
        });
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Contact.class);
                startActivity(intent);
            }
        });
        btn_promotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, Promotion.class);
            }
        });

    }
    void init(){
        btn_contact = findViewById(R.id.btn_contact);
        btn_promotion = findViewById(R.id.btn_promotion);
        btn_place = findViewById(R.id.btn_place);

    }
}
