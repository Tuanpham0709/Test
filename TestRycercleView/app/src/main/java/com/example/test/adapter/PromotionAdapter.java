package com.example.test.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.model.Promotions.Result;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder> {
    Context context;
    List<Result> data;

    public PromotionAdapter(Context context, List<Result> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_promotion, viewGroup, false);

        return new PromotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
        Result result = data.get(i);
        promotionViewHolder.tvTitle.setText(result.getPromotionName());
        promotionViewHolder.tvContent.setText(result.getPlaceDetail().getDescription());
        Picasso.get().load(result.getUrlImage()).into(promotionViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PromotionViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle, tvContent;

        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_logo);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);

        }
    }
}
