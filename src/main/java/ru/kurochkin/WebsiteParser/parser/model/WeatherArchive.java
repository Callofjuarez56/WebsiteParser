package ru.kurochkin.WebsiteParser.parser.model;

import jakarta.persistence.*;


// Таблица "Статистика по погоде в Москве"
@Entity
@Table(name = "WeatherArchive")
public class WeatherArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "date")
    private String date;
    @Column(name = "min_temperature")
    private String minTemperature;
    @Column(name = "max_temperature")
    private String maxTemperature;
    @Column(name = "atmosphere_pressure")
    private String atmospherePressure;

    public WeatherArchive(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getAtmospherePressure() {
        return atmospherePressure;
    }

    public void setAtmospherePressure(String atmospherePressure) {
        this.atmospherePressure = atmospherePressure;
    }
}
