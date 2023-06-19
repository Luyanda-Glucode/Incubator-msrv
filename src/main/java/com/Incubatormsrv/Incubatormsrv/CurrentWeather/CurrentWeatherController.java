package com.Incubatormsrv.Incubatormsrv.CurrentWeather;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.CurrentWeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeatherResponse;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.weather.ThreadExecutor;
import com.Incubatormsrv.Incubatormsrv.weather.WeatherApiException;
import com.Incubatormsrv.Incubatormsrv.weather.mapper.WeatherMapper;
import com.Incubatormsrv.Incubatormsrv.weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class CurrentWeatherController implements CurrentWeatherApi {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    private final ThreadExecutor threadExecutor;
    public CurrentWeatherController(WeatherService weatherService,
                                    WeatherMapper weatherMapper,
                                    ThreadExecutor threadExecutor) {
        this.weatherMapper = weatherMapper;
        this.weatherService = weatherService;
        this.threadExecutor = threadExecutor;
    }
    @Override
    public ResponseEntity<CurrentWeatherResponse> currentWeatherGet(@Valid @RequestParam(value = "cityName", required = true) String cityName, @Valid @RequestParam(value = "num_of_days", required = true) BigDecimal numOfDays) throws ExecutionException, InterruptedException {
        CompletableFuture<WeatherResponse> completableFuture = new CompletableFuture<>();
        threadExecutor.getExecutor().submit(() -> {
            try {
                WeatherResponse response = weatherService.getWeather(cityName, numOfDays);
                completableFuture.complete(response);
            } catch (Exception e) {
                completableFuture.completeExceptionally(new WeatherApiException(e.getMessage()));
            }
        }, RequestContextHolder.currentRequestAttributes());

        var weather = completableFuture.get();
        var currentWeather = weatherMapper.WeatherModelMapper(weather);
        return ResponseEntity.ok(currentWeather);
    }
}
