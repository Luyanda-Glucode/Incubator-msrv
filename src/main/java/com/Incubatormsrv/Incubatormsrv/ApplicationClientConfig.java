package com.Incubatormsrv.Incubatormsrv;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
@Configuration
public class ApplicationClientConfig {
@Bean
    public OkHttpClient.Builder httpClient(@Value("${weather.X-RapidAPI-Key}") String key,
                                           @Value("${weather.X-RapidAPI-Host}") String host) {
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
