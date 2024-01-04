package com.example.news2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {

    ArrayList<NewsModel> datalist;
    Context context;

    public NewsRecyclerAdapter(ArrayList<NewsModel> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }


    @NonNull
    @Override
    public NewsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerAdapter.ViewHolder holder, int position) {
        holder.textTitle.setText(datalist.get(position).getTitle());
        holder.textDescription.setText(datalist.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.recycler_news_title);
            textDescription = itemView.findViewById(R.id.recycler_news_description);
        }
    }
}