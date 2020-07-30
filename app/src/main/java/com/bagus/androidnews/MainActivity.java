package com.bagus.androidnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bagus.androidnews.retrofitconfig.GetJsonAll;
import com.bagus.androidnews.retrofitconfig.RetrofitConfigToJson;
import com.bagus.androidnews.retrofitjson.News;
import com.bagus.androidnews.retrofitjson.NewsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<News> newsList;
    GetJsonAll getJsonAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsList = new ArrayList<>();
        getJsonAll = RetrofitConfigToJson.getResponse();

        getJsonAll.getNewsList("id","4e9e26cdfe464bb29a42c681c2c5089b").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("berhasil",response + "");
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

                Log.d("gagal",t + "");
            }
        });
    }
}