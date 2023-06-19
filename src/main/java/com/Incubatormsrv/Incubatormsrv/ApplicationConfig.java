package com.Incubatormsrv.Incubatormsrv;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Configuration
public class ApplicationConfig {
    @Bean
    public WeatherApi retrofit(@Value("${weather.baseUrl}") String baseUrl, OkHttpClient.Builder okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build().create(WeatherApi.class);
    }
}
