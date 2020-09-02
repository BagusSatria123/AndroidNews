package com.bagus.androidnews;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bagus.androidnews.retrofitconfig.GetJsonAll;
import com.bagus.androidnews.retrofitconfig.RetrofitConfigToJson;
import com.bagus.androidnews.retrofitjson.News;
import com.bagus.androidnews.retrofitjson.NewsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetail extends AppCompatActivity {

    TextView category_detail;
    String business;

    GetJsonAll getJsonAll;
    List<News> news;
    String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_detail);
        category_detail=findViewById(R.id.category_detail);

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

                news = response.body().getArticles();
                title = news.get(0).getTitle();

                Log.d("titleKu",title + "");

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("gagal",t + "");

            }
        });
    }

}
