package com.find.figurefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FigureFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FigureFinderApplication.class, args);
    }

}
