package ru.kurochkin.WebsiteParser.parser.services;

import org.springframework.stereotype.Service;
import ru.kurochkin.WebsiteParser.parser.model.WeatherArchive;

import java.util.List;


@Service
public interface WeatherArchiveService {
    public void save(WeatherArchive weatherArchive);
    public List<WeatherArchive> getAllWeatherInfo(); // показ всех новостей в бд
}
