package com.Incubatormsrv.Incubatormsrv.weather.service;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class WeatherService {
    private WeatherApi weatherApi;
    public WeatherService(WeatherApi weatherApi){
        this.weatherApi = weatherApi;
    }

    @Cacheable("WeatherResponse")
    public WeatherResponse getWeather(String cityName, BigDecimal numOfDays) throws IOException {
        Response<WeatherResponse> response = weatherApi.weatherGet(cityName, "json", numOfDays).execute();

        if (response.isSuccessful()) {
            return response.body();
        }else{
            throw new IOException(response.message());
        }
    }
}

