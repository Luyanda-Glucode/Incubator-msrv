package com.Incubatormsrv.Incubatormsrv.weather.mapper;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.HelloWorld;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.TheCatsResponse;
import org.springframework.stereotype.Component;

@Component
public class CatsMapper {
    public HelloWorld helloWorldMapper(TheCatsResponse theCatsResponse) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName(theCatsResponse.get(0).getBreeds().get(0).getName());
        return helloWorld;
    }
}
