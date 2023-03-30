package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.HelloWorld;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {
    public HelloWorld WeatherModelMapper(WeatherResponse weatherResponse) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName(weatherResponse.getLocation().getName());
        return helloWorld;
    }
}
