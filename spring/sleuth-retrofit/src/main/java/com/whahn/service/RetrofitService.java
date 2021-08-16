package com.whahn.service;

import com.whahn.config.RetrofitApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RetrofitService {
    private final RetrofitApi retrofitApi;

    public void apiTest() throws IOException {
        Call<Object> call = retrofitApi.test();
        call.execute();
    }
}
