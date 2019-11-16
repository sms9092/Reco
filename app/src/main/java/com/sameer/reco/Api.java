package com.sameer.reco;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {



    @FormUrlEncoded
    @POST("api")
    Call<ResponseBody> RegisterUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password
    );
}
