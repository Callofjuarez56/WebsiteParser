package ru.kurochkin.WebsiteParser.parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.kurochkin.WebsiteParser.parser.task.ParseTask;

@SpringBootApplication
@EnableScheduling
public class WebsiteParserApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebsiteParserApplication.class, args);
	}
}
