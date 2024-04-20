package com.find.figurefinder.webscrape;

import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface WebScrape {

    @Async
    public List<String> scrapeUrl(String searchText, String site);

}
