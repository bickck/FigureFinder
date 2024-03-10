package com.find.figurefinder.webscrape;

import com.find.figurefinder.common.FiugreSiteUrl;
import com.find.figurefinder.common.Language;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public interface WebScrape {

    @Async
    public void findFigureList(String searchText, Language language);

    public void findFigureCost();

}
