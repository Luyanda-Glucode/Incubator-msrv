package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.weather.model.weatherModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface weatherMapper {

    @Mapper
    public interface weatherModelMappingWithApi {

        weatherModel weatherMapper(WeatherResponse weatherResponse);

        WeatherResponse weatherApiMapper(weatherModel weather);
    }


//    public default weatherModel weatherMapper(WeatherApi weatherApi) {
//        weatherModel weather = new weatherModel();
//
//        return weather;
//    }
//
//    private weatherModel weatherModelMappingWithApi(WeatherResponse weatherResponse) {
//        weatherModel weather = new weatherModel();
//
//        weather.setName(weatherResponse.getLocation().getName());
//        weather.setRegion(weatherResponse.getLocation().getRegion());
//        weather.setCountry(weatherResponse.getLocation().getCountry());
//        weather.setLocaltime(weatherResponse.getLocation().getLocaltime());
//        weather.setTemp_c(weatherResponse.getCurrent().getTempC());
//        weather.setTemp_f(weatherResponse.getCurrent().getTempF());
//        weather.setLast_updated(weatherResponse.getCurrent().getLastUpdated());
//        weather.setText(weatherResponse.getCurrent().getCondition().getText());
//        weather.setIcon(weatherResponse.getCurrent().getCondition().getIcon());
//
//        return weather;
//    }
}
