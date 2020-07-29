package com.bagus.androidnews.retrofitconfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit retrofit = null;

    public static Retrofit getInstance(String url){

        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getSupportSsl().build())
                    .build();
        }

        return retrofit;
    }

    private static OkHttpClient.Builder getSupportSsl(){

    }

}
