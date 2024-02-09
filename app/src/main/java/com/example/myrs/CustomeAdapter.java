package com.example.myrs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    ArrayList<DataModel> dataset;
    public CustomeAdapter(ArrayList<DataModel> dataSet) {

        this.dataset=dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textname;
        TextView textversion;
        ImageView imageView;

        public MyViewHolder (View itemView){ //תוכן הקארד
            super(itemView);

            textname=itemView.findViewById(R.id.textView);
            textversion=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //יוצר אצ הקארד

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent,false);
        MyViewHolder myVHolder=new MyViewHolder(view);

        return myVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) { //עוברים על תאי המערך ומשבצים על גבי הרשומות

        holder.textname.setText(dataset.get(position).getName());
        holder.textversion.setText(dataset.get(position).getVersion());
        holder.imageView.setImageResource(dataset.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }
}
