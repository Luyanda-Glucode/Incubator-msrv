package com.Incubatormsrv.Incubatormsrv.CurrentWeather;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.CurrentWeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeatherResponse;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.weather.mapper.WeatherMapper;
import com.Incubatormsrv.Incubatormsrv.weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
public class CurrentWeatherController implements CurrentWeatherApi {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    public CurrentWeatherController(WeatherService weatherService,
                                    WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
        this.weatherService = weatherService;
    }
    @Override
    public ResponseEntity<CurrentWeatherResponse> currentWeatherGet() throws IOException {
        WeatherResponse response;
        try {
            response = weatherService.getWeather();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
        var weather = weatherMapper.WeatherModelMapper(response);
        return ResponseEntity.ok(weather);
    }
}
