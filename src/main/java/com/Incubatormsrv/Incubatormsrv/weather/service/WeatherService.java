package com.Incubatormsrv.Incubatormsrv.weather.service;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.ApplicationConfig;
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
    private WeatherApi weatherApi;
    public WeatherService(WeatherApi weatherApi){
        this.weatherApi = weatherApi;
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

