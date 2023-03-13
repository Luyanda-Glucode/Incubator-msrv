package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import com.Incubatormsrv.Incubatormsrv.weather.dto.weatherModelDto;
import com.Incubatormsrv.Incubatormsrv.weather.model.weatherModel;
import org.mapstruct.Mapper;

@Mapper
public interface weatherMapper {
    weatherModel weatherModelToWeatherModelDto(weatherModel weather);
    weatherModelDto weatherModelDtoToWeatherModel(weatherModelDto weatherDto);
}
