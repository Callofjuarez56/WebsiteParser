package ru.kurochkin.WebsiteParser.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kurochkin.WebsiteParser.parser.model.WeatherArchive;

@Repository
public interface WeatherArchiveRepository extends JpaRepository<WeatherArchive, Long> {
}
