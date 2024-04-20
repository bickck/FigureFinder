package com.find.figurefinder.figurefinder;

import com.find.figurefinder.common.FigureSiteUrl;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UrlConnectionTest {


    private final String amiamiEN = "https://www.amiami.com/";

    @Test
    public void amiamiConnectionTest() throws IOException {

        FigureSiteUrl figureSiteUrl = new FigureSiteUrl();

        Document document = Jsoup.connect(figureSiteUrl.getComicArtUrl("Blue"))
                .userAgent("Mozilla/5.0").method(Connection.Method.GET).execute().parse();

        Assert.assertNotNull(document);
    }
}
