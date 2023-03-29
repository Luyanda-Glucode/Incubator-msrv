package com.Incubatormsrv.Incubatormsrv.HelloWorld;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.HelloWorldApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.HelloWorld;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.weather.mapper.WeatherMapper;
import com.Incubatormsrv.Incubatormsrv.weather.service.WeatherService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloWorldController implements HelloWorldApi {

    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    HelloWorldController(WeatherService weatherService,
                         WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/helloWorld")
    public String custom() {
        return "helloWorld";
    }

    @PostMapping(value = "/helloWorld")
    public String postHelloWorld( @RequestBody String hello) {
        return hello;
    }

    @Override
    public ResponseEntity<HelloWorld> getText() throws IOException {
        WeatherResponse response;
        try {
            response = weatherService.getWeather();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }

        var weather = weatherMapper.helloWorldMapper(response);

        return ResponseEntity.ok(weather);
    }
}
