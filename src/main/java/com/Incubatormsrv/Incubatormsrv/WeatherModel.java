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

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public String getTemp_C() {
        return temp_C;
    }

    public void setTemp_C(String temp_C) {
        this.temp_C = temp_C;
    }

    public String getTemp_F() {
        return temp_F;
    }

    public void setTemp_F(String temp_F) {
        this.temp_F = temp_F;
    }
}
