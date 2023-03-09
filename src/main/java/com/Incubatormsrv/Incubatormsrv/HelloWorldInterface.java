package com.Incubatormsrv.Incubatormsrv;

import org.springframework.http.ResponseEntity;

public interface HelloWorldInterface {
    ResponseEntity getHelloWorld();
    HelloWorldModel addName(HelloWorldModel hello);
}
