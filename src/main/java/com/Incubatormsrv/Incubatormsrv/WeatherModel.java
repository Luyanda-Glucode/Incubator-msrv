package com.Incubatormsrv.Incubatormsrv;

public class WeatherModel {
    private String observation_time;
    private String temp_C;
    private String temp_F;

    public WeatherModel(String observation_time, String temp_C, String temp_F){
        this.observation_time = observation_time;
        this.temp_C = temp_C;
        this.temp_F = temp_F;
    }
}
