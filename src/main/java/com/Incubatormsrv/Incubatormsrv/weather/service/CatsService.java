package com.Incubatormsrv.Incubatormsrv.weather.service;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.CatsApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.TheCatsResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class CatsService {

    private final String baseUrl;
    private final String key;
    private final BigDecimal limit;
    private final String breed_ids;
    private final CatsApi catsApi;

    public CatsService(@Value("${cats.X-RapidAPI-Key}") String key,
                       @Value("${cats.limit}") BigDecimal limit,
                       @Value("${cats.breed_ids}") String breed_ids,
                       @Value("${cats.baseUrl}") String baseUrl){
        this.key = key;
        this.baseUrl = baseUrl;
        this.limit = limit;
        this.breed_ids = breed_ids;
        this.catsApi = retrofit().create(CatsApi.class);
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
            request.header("limit", String.valueOf(limit));
            return chain.proceed(request.build());
        });

        return httpClient;
    }
    @Cacheable("WeatherResponse")
    public TheCatsResponse getWeather() throws IOException {
        Response<TheCatsResponse> response = catsApi.catsGet(limit,breed_ids).execute();

        if (response.isSuccessful()) {
            return response.body();
        }else{
            throw new IOException(response.message());
        }
    }
}

