package com.Incubatormsrv.Incubatormsrv;

import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.api.WeatherApi;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.CurrentWeatherResponse;
import _Users_luyanda_glucode.com_Documents_GitHub_Incubator_msrv.model.WeatherResponse;
import com.Incubatormsrv.Incubatormsrv.CurrentWeather.CurrentWeatherController;
import com.Incubatormsrv.Incubatormsrv.weather.ThreadExecutor;
import com.Incubatormsrv.Incubatormsrv.weather.WeatherApiException;
import com.Incubatormsrv.Incubatormsrv.weather.mapper.WeatherMapper;
import com.Incubatormsrv.Incubatormsrv.weather.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;


import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class IncubatorMsrvApplicationTests {
	@Mock
	ThreadExecutor threadExecutor;
	@Mock
	CurrentWeatherController currentWeatherController;
	@Mock
	WireMockServer wireMock;
	@InjectMocks
	private static WeatherMapper weatherMapper;
	static WeatherService weatherService;
	@BeforeAll
	static void setup(){
		weatherMapper = new WeatherMapper();
		weatherService  = Mockito.mock(WeatherService.class);
	}

	private WeatherApi weatherApi;
	@Test
	void test_getWeather_mock() throws IOException, ExecutionException, InterruptedException {

		File jsonFile = new File("src/test/java/mocks/weather.json");
		String Path = jsonFile.getAbsolutePath();
		String jsonFileData = FileUtils.readFileToString(jsonFile,"UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		WeatherResponse mockedWeatherResponse = objectMapper.readValue(jsonFileData, WeatherResponse.class);

		CurrentWeatherResponse mockedCurrentWeather = weatherMapper.WeatherModelMapper(mockedWeatherResponse);
		wireMock.stubFor(get(urlPathMatching("/weather"))
				.willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type", "application/json")
				.withBody(jsonFileData)));

		ResponseEntity<CurrentWeatherResponse> response = currentWeatherController.currentWeatherGet("Pretoria", BigDecimal.valueOf(0));
		wireMock.verify(getRequestedFor(urlEqualTo("/weather")));

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(mockedCurrentWeather, response.getBody());
	}
	@Test
	void test_weather_with_filter_number_of_days() throws IOException, ExecutionException, InterruptedException {
		WeatherResponse weatherResponseMocked = new WeatherResponse();

		File jsonFile = new File("src/test/java/mocks/weatherFilter.json");
		String Path = jsonFile.getAbsolutePath();
		String jsonFileData = FileUtils.readFileToString(jsonFile,"UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		WeatherResponse mockedWeatherResponse = objectMapper.readValue(jsonFileData, WeatherResponse.class);

		weatherResponseMocked = new Gson().fromJson(jsonFileData,WeatherResponse.class);
		weatherService.getWeather("Pretoria", BigDecimal.valueOf(4));
		Mockito.verify(weatherService.getWeather("Pretoria", BigDecimal.valueOf(4)));
		assertNull(weatherService.getWeather("Pretoria", BigDecimal.valueOf(7)));

		Mockito.when(weatherService.getWeather("Pretoria", BigDecimal.valueOf(4))).thenReturn(weatherResponseMocked);
		assertEquals(weatherResponseMocked,weatherService.getWeather("Pretoria", BigDecimal.valueOf(4)));

		CurrentWeatherController currentWeatherController1 = new CurrentWeatherController(weatherService, weatherMapper, threadExecutor);

		ResponseEntity<CurrentWeatherResponse> response = currentWeatherController1.currentWeatherGet("Pretoria", BigDecimal.valueOf(4));
		CurrentWeatherResponse currentWeatherResponse = weatherMapper.WeatherModelMapper(mockedWeatherResponse);

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(currentWeatherResponse, response.getBody());
	}

	@Test
	public void testCurrentWeatherGet_Success() throws Exception {
		String cityName = "Pretoria";
		BigDecimal numOfDays = BigDecimal.valueOf(4);
		WeatherResponse weatherResponse = new WeatherResponse();
		CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();
		CompletableFuture<WeatherResponse> completableFuture = CompletableFuture.completedFuture(weatherResponse);

		wireMock.stubFor(get(urlPathMatching("/weather"))
				.withQueryParam("q", equalTo(cityName))
				.withQueryParam("num_of_days", equalTo(String.valueOf(numOfDays)))
				.willReturn(aResponse()));

		Mockito.when(weatherService.getWeather(cityName, numOfDays)).thenReturn(weatherResponse);
		Mockito.when(weatherMapper.WeatherModelMapper(weatherResponse)).thenReturn(currentWeatherResponse);
		Mockito.when(threadExecutor.getExecutor()).thenReturn(Executors.newSingleThreadExecutor());

		ResponseEntity<CurrentWeatherResponse> response = currentWeatherController.currentWeatherGet(cityName, numOfDays);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(currentWeatherResponse, response.getBody());
	}

	@Test
	public void testCurrentWeatherGet_Exception() throws Exception {
		String cityName = "Pretoria";
		BigDecimal numOfDays = BigDecimal.valueOf(4);
		WeatherApiException weatherApiException = new WeatherApiException("An error occurred while getting weather data");

		Mockito.when(weatherService.getWeather(cityName, numOfDays)).thenThrow(weatherApiException);
		Mockito.when(threadExecutor.getExecutor()).thenReturn(Executors.newSingleThreadExecutor());

		Exception exception = Assert.assertThrows(ExecutionException.class, () -> currentWeatherController.currentWeatherGet(cityName, numOfDays));

		Assert.assertTrue(exception.getCause() instanceof WeatherApiException);
		Assert.assertEquals(weatherApiException.getMessage(), exception.getCause().getMessage());
	}

	@Test
	public void testGetWeather_Success() throws Exception {

		WeatherResponse weatherResponseMocked = new WeatherResponse();

		File jsonFile = new File("src/test/java/mocks/weather.json");
		String Path = jsonFile.getAbsolutePath();
		String jsonFileData = FileUtils.readFileToString(jsonFile,"UTF-8");

		weatherResponseMocked = new Gson().fromJson(jsonFileData,WeatherResponse.class);

		Response<WeatherResponse> response = Response.success(weatherResponseMocked);

		wireMock.stubFor(get(urlPathMatching("/weather"))
				.withQueryParam("q", equalTo("Pretoria"))
				.withQueryParam("format", equalTo("json"))
				.withQueryParam("num_of_days", equalTo(String.valueOf(BigDecimal.valueOf(4))))
				.willReturn(aResponse()));

		doReturn(response).when(weatherApi).weatherGet("Pretoria", "json",  BigDecimal.valueOf(4));
		WeatherResponse result = weatherService.getWeather("Pretoria", BigDecimal.valueOf(4));

		Assert.assertEquals(weatherResponseMocked, result);
	}

	@Test
	public void testGetWeather_Failure() throws Exception {
		String errorMessage = "An error occurred while getting weather data";
		Response<WeatherResponse> response = Response.error(400, ResponseBody.create(MediaType.parse("text/plain"), errorMessage));

		wireMock.stubFor(get(urlPathMatching("/weather"))
				.withQueryParam("q", equalTo("Pretoria"))
				.withQueryParam("format", equalTo("json"))
				.withQueryParam("num_of_days", equalTo(String.valueOf(BigDecimal.valueOf(4))))
				.willReturn(aResponse().withStatus(400).withBody(errorMessage)));

		doReturn(response).when(weatherApi).weatherGet("Pretoria", "json",  BigDecimal.valueOf(4));
		Exception exception = Assert.assertThrows(IOException.class, () -> weatherService.getWeather("Pretoria", BigDecimal.valueOf(4)));
		Assert.assertEquals(errorMessage, exception.getMessage());
	}
	@After
	public void teardown() {
		wireMock.stop();
	}
}
