package com.find.figurefinder.webscrape;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Pattern;

public class WebScrape {

    public WebScrape() {

    }

    public void finder(String findWord) {
        try {
            Document document = Jsoup.parse("https://comics-art.co.kr/").connection().get();

            document.body().getElementsMatchingText(Pattern.compile("#re"));


        }catch (Exception ex) {

        }
    }
}
