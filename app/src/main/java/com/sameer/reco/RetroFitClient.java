package com.sameer.reco;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroFitClient {
    private static final String BASE_URL = "http://192.168.1.112/android_login/";
    private static RetroFitClient nInstance;
    private Retrofit retrofit;
    private RetroFitClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized  RetroFitClient getInstance(){
        if(nInstance == null){
            nInstance = new RetroFitClient();
        }
        return nInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
