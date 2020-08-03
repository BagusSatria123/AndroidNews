package com.bagus.androidnews.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.androidnews.R;
import com.bagus.androidnews.retrofitjson.News;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<News> newsList;

    public MyAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    class MyClassAdapter extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;
        private ImageLoader imageLoader;

        public MyClassAdapter(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            imageLoader = ImageLoader.getInstance();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_news,viewGroup,false);

        return new MyClassAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((MyClassAdapter) viewHolder).title.setText(newsList.get(i).getTitle());
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .build();

        ((MyClassAdapter) viewHolder).imageLoader.init(configuration);
        ((MyClassAdapter) viewHolder).imageLoader.displayImage(newsList.get(i).getUrlToImage(), ((MyClassAdapter) viewHolder).img);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
