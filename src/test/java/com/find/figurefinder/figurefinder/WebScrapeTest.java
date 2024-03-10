package com.find.figurefinder.figurefinder;

import com.find.figurefinder.webscrape.WebScrape;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class WebScrapeTest {

    @Test
    public void queryTest() {


        try {
            Document document = Jsoup.connect("http://localhost:3000/").get();

            // 쿼리 표현
            Elements elements = document.select(".test");
            Elements elements1 = document.select(".test.grd");
            Elements elements2 = document.getElementsByClass("test grd");
            Element elements3 = document.select("ul > li > span").last();
            Element elements4 = document.select("ul > li > a").first();

            System.out.println(elements4.attr("href"));


        } catch (IOException ioException) {
            throw new RuntimeException();
        }
    }

    @Test
    public void jsoupTest() {

        try {

            Document document = Jsoup.connect("http://localhost:3000/").get();

            Elements elements = document.select(".test");
            Elements elements1 = document.select(".test.grd");
            Elements elements2 = document.getElementsByClass("test grd");

            int nodeSize = 0;
            String id = null;
            String html = null;

            // 결과 : DataNode 값은 없음
            for (DataNode dataNode : elements2.dataNodes()) {
                String data = dataNode.getWholeData();
                System.out.println(data);
            }

            for (Element element : elements) {
                nodeSize = element.childNodeSize();
                id = element.id();
            }

            html = elements.html();

            System.out.println(elements1.html());
            System.out.println(elements2.html());
            System.out.println(id);
            System.out.println(html);
            System.out.println(nodeSize);


        } catch (IOException ioException) {
            throw new RuntimeException();
        }

    }
}

