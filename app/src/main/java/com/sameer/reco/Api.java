package com.sameer.reco;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {



    @FormUrlEncoded
    @POST("register")
    Call<User> RegisterUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("mobile") String mobile,
            @Field("blood") String blood,
            @Field("dob") String dob
    );

    @POST("login")
    Call<User> loginUser(
            @Query("username") String username,
            @Query("password") String password
    );





}
