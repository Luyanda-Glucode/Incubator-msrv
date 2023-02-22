package com.Incubatormsrv.Incubatormsrv;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface WeatherService {
    @GET("/weatherModel")
    public Call<List<WeatherModel>> getWeatherList(
            @Query("per_page") int per_page,
            @Query("page") int page);

    @GET("/weatherModel/{observation_time}")
    public Call<WeatherModel> getWeather(@Path("observation_time") String observation_time);
}
