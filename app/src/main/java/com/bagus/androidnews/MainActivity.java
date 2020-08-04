package com.bagus.androidnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bagus.androidnews.adapter.MyAdapter;
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
    String title,description;

    RecyclerView recycler_view;
    MyAdapter myAdapter;
    GridLayoutManager gm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        gm = new GridLayoutManager(this,1);
        recycler_view.setLayoutManager(gm);
        myAdapter = new MyAdapter(this,newsList);
        recycler_view.setAdapter(myAdapter);

        newsList = new ArrayList<>();
        getJsonAll = RetrofitConfigToJson.getResponse();


        getJsonAll.getNewsList("id","4e9e26cdfe464bb29a42c681c2c5089b").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("berhasil",response + "");

                newsList = response.body().getArticles();

                title = newsList.get(1).getTitle();
                description = newsList.get(1).getDescription();
                Log.d("titleBerita","Judul " + title + " " + "Deskriptis " + description);

                myAdapter = new MyAdapter(getApplicationContext(),newsList);
                recycler_view.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

                Log.d("gagal",t + "");
            }
        });
    }
}