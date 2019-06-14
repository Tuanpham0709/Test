package com.example.test.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.model.Place.Result;

import java.util.List;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    Context context;
    List<Result> listPlace;

    public void setContext(Context context){
        this.context = context;
    }
    public void setListPlace(List<Result> listPlace){
        this.listPlace = listPlace;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_place, viewGroup, false);
        return  new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder placeViewHolder, int i) {
        Result result = listPlace.get(i);
        if(result.getIsMoreDetail() == 1) {
            placeViewHolder.tvIsMoreDetail.setText("추가 \n 정보");
            placeViewHolder.tvIsMoreDetail.setVisibility(View.VISIBLE);
            placeViewHolder.constraintLayout.setBackgroundColor( Color.parseColor("#FF7E0E"));
        }else {
            placeViewHolder.tvIsMoreDetail.setVisibility(View.GONE);
            placeViewHolder.constraintLayout.setBackgroundColor( Color.parseColor("#FD9D4C"));

        }
        if (result.getIsPromotion() == 1){
            placeViewHolder.tvIsMorePromotion.setText("프로모션");
            placeViewHolder.tvIsMorePromotion.setVisibility(View.VISIBLE);
        }else {
            placeViewHolder.tvIsMorePromotion.setVisibility(View.GONE);
        }
        placeViewHolder.tvTitlePlace.setText(result.getPlaceName());
    }

    @Override
    public int getItemCount() {
        return listPlace.size();
    }

    class PlaceViewHolder extends  RecyclerView.ViewHolder{
        TextView tvTitlePlace, tvIsMoreDetail, tvIsMorePromotion;
        ConstraintLayout constraintLayout;


        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.ct_bg);
            tvIsMoreDetail = itemView.findViewById(R.id.tv_btn_isMoreDetail);
            tvIsMorePromotion = itemView.findViewById(R.id.tv_btn_isMorePromotion);
            tvTitlePlace = itemView.findViewById(R.id.tv_title_place);


        }
    }
}
