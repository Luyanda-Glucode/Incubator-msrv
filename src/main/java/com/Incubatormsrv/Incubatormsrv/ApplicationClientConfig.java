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
    public OkHttpClient.Builder httpClient(@Value("${weather.Key}") String key) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request.Builder request = chain.request().newBuilder();
            request.header("Key", key);
            return chain.proceed(request.build());
        });
        return httpClient;
    }
}