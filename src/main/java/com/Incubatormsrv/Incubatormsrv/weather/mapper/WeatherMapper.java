package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.weather.model.WeatherModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface WeatherMapper {

    @Mapper
    public interface weatherModelMappingWithApi {

        WeatherModel weatherModelMapper(WeatherResponse weatherResponse);

        WeatherResponse weatherApiMapper(WeatherModel weather);
    }
}
