# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.WeatherApi;

import java.io.File;
import java.util.*;

public class WeatherApiExample {

    public static void main(String[] args) {
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://weather.swagger.io/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*WeatherApi* | [**getWeather**](docs/WeatherApi.md#getWeather) | **GET** /weather | Get weather summery


## Documentation for Models

 - [ModelApiResponse](docs/ModelApiResponse.md)
 - [WeatherModel](docs/WeatherModel.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### api_key

- **Type**: API key
- **API key parameter name**: api_key
- **Location**: HTTP header

### weather_auth

- **Type**: OAuth
- **Flow**: implicit
- **Authorization URL**: https://weather.swagger.io/oauth/authorize
- **Scopes**: 
  - read:weather: read your weather


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

apiteam@swagger.io

