package com.bagus.androidnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.androidnews.R;
import com.bagus.androidnews.retrofitjson.News;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<News> newsList;

    public MyAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    class MyClassAdapter extends RecyclerView.ViewHolder{

        public MyClassAdapter(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_news,viewGroup,false);

        return new MyClassAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
