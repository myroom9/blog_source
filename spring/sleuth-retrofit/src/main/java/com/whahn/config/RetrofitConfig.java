package com.whahn.config;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class RetrofitConfig {

    private final Tracer tracer;
    private static final String API_TEST_URL = "http://localhost:9001/";

    @Bean(name="okHttpClient")
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request.Builder builder = chain.request().newBuilder();
                        ifSpanNotEmptyAddHeader(builder);
                        return chain.proceed(builder.build());
                    }

                    private void ifSpanNotEmptyAddHeader(Request.Builder builder) {
                        if (tracer.currentSpan() != null) {
                            builder.header("x-b3-traceid", tracer.currentSpan().context().traceIdString());
                            builder.header("x-b3-spanid", tracer.nextSpan().context().spanIdString());
                        }
                    }
                })
                .build();
    }

    @Bean(name="commonRetrofit")
    public Retrofit retrofit(@Qualifier("okHttpClient") OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(API_TEST_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client).build();
    }

    @Bean(name="restService")
    public RetrofitApi restService(@Qualifier("commonRetrofit") Retrofit retrofit) {
        return retrofit.create(RetrofitApi.class);
    }
}
