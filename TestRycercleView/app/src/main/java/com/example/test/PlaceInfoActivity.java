package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.squareup.picasso.Picasso;

public class PlaceInfoActivity extends AppCompatActivity {
    TextView tvNamePlace,tvPhonePlace,tvAddressPlace, tvUrlWeb, tvDecreption;
    ImageView imgLogoPlace ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);
        init();
        Bundle bundle= getIntent().getExtras();
        InfoPlace infoPlace = bundle.getParcelable("data");
        tvPhonePlace.setText(infoPlace.getmPhone());
        tvAddressPlace.setText(infoPlace.getmAddress());
        tvUrlWeb.setText(infoPlace.getmUrlWeb());
        tvNamePlace.setText(infoPlace.getmPlaceName());
        tvDecreption.setText(infoPlace.getmDescription());
        try {
            Picasso.get().load(infoPlace.getmUrlLogoPlace()).into(imgLogoPlace);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    void init(){
        tvAddressPlace = findViewById(R.id.tv_address_place);
        tvNamePlace  = findViewById(R.id.tv_name_place);
        tvDecreption = findViewById(R.id.tv_decreption);
        tvUrlWeb = findViewById(R.id.tv_url_web);
        tvPhonePlace = findViewById(R.id.tv_phone_number_place);
        imgLogoPlace = findViewById(R.id.img_logoPlace);

    }
}
