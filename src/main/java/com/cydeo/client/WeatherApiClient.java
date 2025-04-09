package com.cydeo.client;

import com.cydeo.dto.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com", name = "WEATHER-CLIENT")
public interface WeatherApiClient {
    //http://api.weatherstack.com -->Base URL
    // /current --> end point
    // ?  --> end of the url
    // access_key=509094dfd4045a5b50ba0e5c3059a5d7 -->query param1
    // &
    // query=Paris -->query param2
    @GetMapping("/current")
    WeatherResponse getCurrentWeather(@RequestParam(value = "access_key") String accessKey,
                                      @RequestParam(value = "query") String city);
    //how can we access to temperature stated in json?
    //create pojo class and use it here


}
