package com.Incubatormsrv.Incubatormsrv.weather.service;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.SpringFoxConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Component
public class WeatherService {

    private final String baseUrl;
    private final String key;
    private final String host;
    private WeatherApi weatherApi;
    private final Retrofit.Builder builder;
    private final OkHttpClient.Builder httpClient;
    private final SpringFoxConfig springFoxConfig;
    public WeatherService(@Value("${weather.X-RapidAPI-Key}") String key,
                          @Value("${weather.X-RapidAPI-Host}") String host,
                          @Value("${weather.baseUrl}") String baseUrl){
        this.key = key;
        this.baseUrl = baseUrl;
        this.host = host;
        this.springFoxConfig = new SpringFoxConfig();
        this.httpClient = new OkHttpClient.Builder();
        this.builder = springFoxConfig.retrofit(baseUrl, httpClient).newBuilder().client(httpClient().build());
        this.weatherApi = springFoxConfig.retrofit(baseUrl, httpClient).create(WeatherApi.class);
    }
    private OkHttpClient.Builder httpClient() {
        httpClient.addInterceptor(chain -> {
            Request.Builder request = chain.request().newBuilder();
            request.header("X-RapidAPI-Key", key);
            request.header("X-RapidAPI-Host", host);
            return chain.proceed(request.build());
        });

        return httpClient;
    }

    public WeatherResponse getWeather() throws IOException {
        Response<WeatherResponse> response = weatherApi.weatherGet().execute();

        if (response.isSuccessful()) {
            return response.body();
        }else{
            throw new IOException(response.message());
        }
    }
}

