package com.bagus.androidnews.retrofitconfig;

import com.bagus.androidnews.retrofitjson.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetJsonAll {

    @GET("v2/top-headlines")
    Call<NewsList> getNewsListCategory(

            @Query("country")
            String country,

            @Query("category")
            String category,

            @Query("apiKey")
            String apiKey
    );

    @GET("v2/top-headlines")
    Call<NewsList> getNewsListCategory(

            @Query("country")
                    String country,

            @Query("apiKey")
                    String apiKey
    );



}
