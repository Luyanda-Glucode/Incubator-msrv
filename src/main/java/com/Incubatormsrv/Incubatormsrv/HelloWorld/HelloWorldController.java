package com.Incubatormsrv.Incubatormsrv.HelloWorld;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/helloWorld")
    public String custom() {
        return "helloWorld";
    }

    @PostMapping(value = "/helloWorld")
    public String postHelloWorld( @RequestBody String hello) {
        return hello;
    }
}
