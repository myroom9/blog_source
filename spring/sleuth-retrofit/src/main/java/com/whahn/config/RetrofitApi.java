package com.whahn.config;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("/test")
    Call<Object> test();
}
