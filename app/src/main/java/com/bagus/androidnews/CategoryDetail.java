package com.bagus.androidnews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.androidnews.adapter.MyAdapter;
import com.bagus.androidnews.retrofitconfig.GetJsonAll;
import com.bagus.androidnews.retrofitconfig.RetrofitConfigToJson;
import com.bagus.androidnews.retrofitjson.News;
import com.bagus.androidnews.retrofitjson.NewsList;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetail extends AppCompatActivity {

    RecyclerView category_detail;
    String business;
    GridLayoutManager gm;
    MyAdapter adapter;

    GetJsonAll getJsonAll;List<News> news;

    String title;

    SpinKitView spinKitView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_detail);

        spinKitView = findViewById(R.id.spin_kit);

        category_detail=findViewById(R.id.recycler_detail);
        gm = new GridLayoutManager(this,1);
        category_detail.setLayoutManager(gm);
        adapter = new MyAdapter(this,news);

        business=getIntent().getStringExtra("business");
        news = new ArrayList<>();
        getJsonAll = RetrofitConfigToJson.getResponse();

        switch (business){
            case "business":
                //category_detail.setText(business);
                tampilkanCategory("business");
                break;
            case "entertainment":
                //category_detail.setText(business);
                tampilkanCategory("entertainment");

                break;
            case "health":
                //category_detail.setText(business);
                tampilkanCategory("health");

                break;
            case "science":
                //category_detail.setText(business);
                tampilkanCategory("science");

                break;
            case "sports":
                //category_detail.setText(business);
                tampilkanCategory("sports");

                break;
            case "technology":
                //category_detail.setText(business);
                tampilkanCategory("technology");

                break;
            default:
                Toast.makeText(getApplicationContext(),"CATEGORY TIDAK ADA",Toast.LENGTH_LONG).show();
        }
    }
    private void tampilkanCategory(String category){
        getJsonAll.getNewsListCategory("id",category,"4e9e26cdfe464bb29a42c681c2c5089b").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {

                Log.d("berhasil",response + "");

                spinKitView.setVisibility(View.VISIBLE);

                if (response.isSuccessful()){
                    spinKitView.setVisibility(View.GONE);
                    news = response.body().getArticles();
                    title = news.get(0).getTitle();

                    Log.d("titleKu",title + "");

                    adapter = new MyAdapter(getApplicationContext(),news);
                    category_detail.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("gagal",t + "");

            }
        });
    }

}
