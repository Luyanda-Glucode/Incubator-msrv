package com.Incubatormsrv.Incubatormsrv.CurrentWeather;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.CurrentWeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeatherResponse;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.weather.WeatherApiException;
import com.Incubatormsrv.Incubatormsrv.weather.mapper.WeatherMapper;
import com.Incubatormsrv.Incubatormsrv.weather.service.WeatherService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    public ResponseEntity<CurrentWeatherResponse> currentWeatherGet(@Valid @RequestParam(value = "cityName", required = true) String cityName, @Valid @RequestParam(value = "num_of_days", required = true) BigDecimal numOfDays) {
        WeatherResponse response;
        try {
            response = weatherService.getWeather(cityName, numOfDays);
        } catch (Exception e) {
            throw new WeatherApiException(e.getMessage());
        }
        var weather = weatherMapper.WeatherModelMapper(response);
        return ResponseEntity.ok(weather);
    }
}
