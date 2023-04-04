package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeatherResponse;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {
    public CurrentWeatherResponse WeatherModelMapper(WeatherResponse weatherResponse) {
        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();
        currentWeatherResponse.setName(weatherResponse.getLocation().getName());
        currentWeatherResponse.setDescription(weatherResponse.getCurrent().getCondition().getText());
        currentWeatherResponse.setImageUri(weatherResponse.getCurrent().getCondition().getIcon());
        return currentWeatherResponse;
    }
}
