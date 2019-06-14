package com.example.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.model.Contact.Result;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context context;
    private List<Result> data = new ArrayList<>();
    public void setContext(Context context){
        this.context = context;
    }
    public void setData(List<Result> data ){
        this.data = data;

    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_contact, viewGroup, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        Result result = data.get(i);
        contactViewHolder.tvName.setText(result.getName());
        contactViewHolder.tvPhoneNumber.setText(result.getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPhoneNumber;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhoneNumber = itemView.findViewById(R.id.tv_number);
        }
    }
}
