package ru.kurochkin.WebsiteParser.parser.task;

import io.micrometer.core.annotation.Timed;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kurochkin.WebsiteParser.parser.model.WeatherArchive;
import ru.kurochkin.WebsiteParser.parser.services.WeatherArchiveService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class ParseTask {

    @Autowired
    WeatherArchiveService weatherArchiveService;

    @Value("${url}")
    String url;

    @Scheduled(fixedDelay = 10000)
    @Timed
    public void parsLatestWeather() throws IOException {
        Document document = Jsoup.connect(url)
                .userAgent("Yandex")
                .timeout(5000)
                .referrer("https://google.com")
                .get();

        Elements table = document.getElementsByClass("table_res");
        Elements table_resTagsElements = table.select("tr");

        int counter = 1;
        for (Element element: table_resTagsElements){
            Element trTagsElements = table_resTagsElements.get(counter);
            Elements tdTagsElements = trTagsElements.getElementsByClass("td_res");
            ArrayList<String> list = new ArrayList<>();

            for (Element el: tdTagsElements){
               String title = el.ownText();
               list.add(title);
            }
            counter++;
            if (counter > 301){
                break;
            }

            WeatherArchive obj = new WeatherArchive();
            obj.setDate(list.get(0));
            obj.setMinTemperature(list.get(2));
            obj.setMaxTemperature(list.get(1));
            obj.setAtmospherePressure(list.get(4));
            weatherArchiveService.save(obj);
        }
    }
}
