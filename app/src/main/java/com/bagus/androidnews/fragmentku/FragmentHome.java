package com.bagus.androidnews.fragmentku;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.androidnews.R;
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

public class FragmentHome extends Fragment {

    List<News> newsList;
    GetJsonAll getJsonAll;
    String title,description;

    RecyclerView recycler_view;
    MyAdapter myAdapter;
    GridLayoutManager gm;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);

        recycler_view = view.findViewById(R.id.recycler_view);
        gm = new GridLayoutManager(getContext(),1);
        recycler_view.setLayoutManager(gm);
        newsList = new ArrayList<>();
        myAdapter = new MyAdapter(getContext(),newsList);
        recycler_view.setAdapter(myAdapter);


        getJsonAll = RetrofitConfigToJson.getResponse();


        getJsonAll.getNewsList("id","4e9e26cdfe464bb29a42c681c2c5089b").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("berhasil",response + "");

                newsList = response.body().getArticles();

                title = newsList.get(1).getTitle();
                description = newsList.get(1).getDescription();
                Log.d("titleBerita","Judul " + title + " " + "Deskriptis " + description);

                myAdapter = new MyAdapter(getContext(),newsList);
                recycler_view.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

                Log.d("gagal",t + "");
            }
        });

        return view;
    }

}
