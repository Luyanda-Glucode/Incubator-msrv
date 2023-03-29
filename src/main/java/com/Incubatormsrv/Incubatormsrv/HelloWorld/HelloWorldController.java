package com.Incubatormsrv.Incubatormsrv.HelloWorld;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.HelloWorldApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.HelloWorld;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.TheCatsResponse;
import com.Incubatormsrv.Incubatormsrv.weather.mapper.CatsMapper;
import com.Incubatormsrv.Incubatormsrv.weather.service.CatsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloWorldController implements HelloWorldApi {

    private final CatsService catsService;
    private final CatsMapper catsMapper;

    HelloWorldController(CatsService catsService,
                         CatsMapper catsMapper) {
        this.catsMapper = catsMapper;
        this.catsService = catsService;
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
        TheCatsResponse response;
        try {
            response = catsService.getWeather();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }

        var weather = catsMapper.helloWorldMapper(response);

        return ResponseEntity.ok(weather);
    }
}
