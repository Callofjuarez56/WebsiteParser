package ru.kurochkin.WebsiteParser.parser.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kurochkin.WebsiteParser.parser.model.WeatherArchive;
import ru.kurochkin.WebsiteParser.parser.services.WeatherArchiveService;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    WeatherArchiveService weatherArchiveService;

    @GetMapping(value = "/start")
    public List<WeatherArchive> getWeatherInfo(){
        return weatherArchiveService.getAllWeatherInfo();
    }
}
