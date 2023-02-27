package com.Incubatormsrv.Incubatormsrv;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.handler.CurrentWeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.callback.Callback;

@RestController
public class WeatherController implements CurrentWeatherApi {

    @Override
    public ResponseEntity<CurrentWeather> currentWeatherGet(String q, String numOfDays, String format, String key) {
        return CurrentWeatherApi.super.currentWeatherGet(q, numOfDays, format, key);
    }
}
