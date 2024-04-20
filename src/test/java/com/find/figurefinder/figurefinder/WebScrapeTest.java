package com.find.figurefinder.figurefinder;

import com.find.figurefinder.common.FigureSiteInfo;
import com.find.figurefinder.common.FigureSiteUrl;
import com.find.figurefinder.common.Language;
import com.find.figurefinder.webscrape.WebScrape;
import com.find.figurefinder.webscrape.WebScrapeImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class WebScrapeTest {


    @Test
    public void connectAmiAmiJPTest() throws IOException {

        FigureSiteUrl figureSiteUrl = new FigureSiteUrl();
        String siteUrl = figureSiteUrl.getAmiamiUrl("BlueArchive", Language.JP);

        WebScrape webScrape = new WebScrapeImpl();
        webScrape.scrapeUrl(siteUrl, FigureSiteInfo.AMIAMIJP);

    }

    @Test
    public void connectAmiAmiENTest() throws IOException {

        FigureSiteUrl figureSiteUrl = new FigureSiteUrl();
        String siteUrl = figureSiteUrl.getAmiamiUrl("BlueArchive", Language.EN);

        WebScrape webScrape = new WebScrapeImpl();
        webScrape.scrapeUrl(siteUrl, FigureSiteInfo.AMIAMIEN);

    }

    @Test
    public void connectComicsArtTest() throws IOException {

        FigureSiteUrl figureSiteUrl = new FigureSiteUrl();
        String siteUrl = figureSiteUrl.getAmiamiUrl("BlueArchive", Language.JP);

        WebScrape webScrape = new WebScrapeImpl();
        webScrape.scrapeUrl(siteUrl, FigureSiteInfo.AMIAMIJP);

    }

    @Test
    public void connectRabbitCompanyTest() throws IOException {

        FigureSiteUrl figureSiteUrl = new FigureSiteUrl();
        String siteUrl = figureSiteUrl.getAmiamiUrl("BlueArchive", Language.JP);

        WebScrape webScrape = new WebScrapeImpl();
        webScrape.scrapeUrl(siteUrl, FigureSiteInfo.AMIAMIJP);

    }

    @Test
    public void connectManiaHouseTest() throws IOException {

        FigureSiteUrl figureSiteUrl = new FigureSiteUrl();
        String siteUrl = figureSiteUrl.getAmiamiUrl("BlueArchive", Language.JP);

        WebScrape webScrape = new WebScrapeImpl();
        webScrape.scrapeUrl(siteUrl, FigureSiteInfo.AMIAMIJP);

    }
}

