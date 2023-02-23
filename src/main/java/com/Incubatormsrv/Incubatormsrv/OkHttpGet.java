package com.Incubatormsrv.Incubatormsrv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class OkHttpGet {

    OkHttpClient client = new OkHttpClient();
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.worldweatheronline.com/premium/v1/weather.ashx?q=Pretoria&format=json&num_of_days=5&key=44e29137982b4899be752116232202")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.newBuilder().build())
            .build();

    public void weatherResponse() {
        WeatherService service = retrofit.create(WeatherService.class);
        Call<WeatherModel> callSync = service.getWeather("08:00");

        try {
            Response response = callSync.execute().raw();
            ResponseBody weatherModel = response.body();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
