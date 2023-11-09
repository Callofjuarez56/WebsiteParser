package ru.kurochkin.WebsiteParser.parser.services;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kurochkin.WebsiteParser.parser.model.WeatherArchive;
import ru.kurochkin.WebsiteParser.parser.repository.WeatherArchiveRepository;

import java.util.List;

@Service
public class WeatherArchiveServiceImpl implements WeatherArchiveService {

    @Autowired
    WeatherArchiveRepository repository;
    @Override
    @Timed
    public void save(WeatherArchive weatherArchive) {
        repository.save(weatherArchive);
    }
    @Override
    @Timed
    public List<WeatherArchive> getAllWeatherInfo() {
        return repository.findAll();
    }
}
