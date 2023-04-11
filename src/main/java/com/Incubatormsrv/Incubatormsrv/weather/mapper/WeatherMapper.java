package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeatherResponse;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {
    public CurrentWeatherResponse WeatherModelMapper(WeatherResponse weatherResponse) {
        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();
        currentWeatherResponse.setName(weatherResponse.getData().getRequest().get(0).getType());
        currentWeatherResponse.setDescription(weatherResponse.getData().getCurrentCondition().get(0).getWeatherDesc().get(0).getValue());
        currentWeatherResponse.setImageUri(weatherResponse.getData().getCurrentCondition().get(0).getWeatherIconUrl().get(0).getValue());
        return currentWeatherResponse;
    }
}
