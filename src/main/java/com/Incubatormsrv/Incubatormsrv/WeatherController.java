package com.Incubatormsrv.Incubatormsrv;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.handler.WeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherModel;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.callback.Callback;

@RestController
public class WeatherController implements WeatherApi  {

    @Override
    public WeatherModel getWeather(WeatherModel body) {
        return null;
    }

    /**
     * Get weather summery
     * Async method
     *
     * @param body Current weather (required)
     * @param cb   callback method
     */
    @Override
    public void getWeather(WeatherModel body, retrofit.Callback<WeatherModel> cb) {
        try {
            getWeather(body);
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

}
