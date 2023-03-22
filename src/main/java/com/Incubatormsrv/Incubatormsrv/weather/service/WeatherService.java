package com.Incubatormsrv.Incubatormsrv.weather.service;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class WeatherService {

    private final String baseUrl;
    private final String key;
    private final String host;
    public WeatherService(@Value("${weather.X-RapidAPI-Key}") String key,
                          @Value("${weather.X-RapidAPI-Host}") String host,
                          @Value("${weather.baseUrl}") String baseUrl){
        this.key = key;
        this.baseUrl = baseUrl;
        this.host = host;
    }

    public WeatherApi api() {
        return retrofit().create(WeatherApi.class);
    }

    private Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient().build())
                .build();
    }

    private OkHttpClient.Builder httpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {
            Request.Builder request = chain.request().newBuilder();
            request.header("X-RapidAPI-Key", key);
            request.header("X-RapidAPI-Host", host);
            return chain.proceed(request.build());
        });

        return httpClient;
    }
}

