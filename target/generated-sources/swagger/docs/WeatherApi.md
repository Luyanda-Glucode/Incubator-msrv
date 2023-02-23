# WeatherApi

All URIs are relative to *https://weather.swagger.io/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getWeather**](WeatherApi.md#getWeather) | **GET** /weather | Get weather summery


<a name="getWeather"></a>
# **getWeather**
> getWeather(body)

Get weather summery



### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.WeatherApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: weather_auth
OAuth weather_auth = (OAuth) defaultClient.getAuthentication("weather_auth");
weather_auth.setAccessToken("YOUR ACCESS TOKEN");

WeatherApi apiInstance = new WeatherApi();
WeatherModel body = new WeatherModel(); // WeatherModel | Current weather
try {
    apiInstance.getWeather(body);
} catch (ApiException e) {
    System.err.println("Exception when calling WeatherApi#getWeather");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**WeatherModel**](WeatherModel.md)| Current weather |

### Return type

null (empty response body)

### Authorization

[weather_auth](../README.md#weather_auth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

