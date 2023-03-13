package com.Incubatormsrv.Incubatormsrv.HelloWorld;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.HelloWorldApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.HelloWorld;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController implements HelloWorldApi {
    @GetMapping(value = "/helloWorld")
    public String custom() {
        return "helloWorld";
    }

    @PostMapping(value = "/helloWorld")
    public String postHelloWorld( @RequestBody String hello) {
        return hello;
    }

    @Override
    public ResponseEntity<HelloWorld> getText() {
        return HelloWorldApi.super.getText();
    }
}
