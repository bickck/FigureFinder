package com.find.figurefinder.webscrape;

import com.find.figurefinder.common.FigureSiteInfo;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScrapeImpl implements WebScrape {

    public WebScrapeImpl() {

    }

    @Async
    @Override
    public List<String> scrapeUrl(String fiugreSiteUrl, String site) {

        try {

            Document document = Jsoup.connect(fiugreSiteUrl)
                    .userAgent("Chrome")
                    .header("pragma", "no-cache")
                    .header("upgrade-insecure-requests", "1")
                    .header("cache-control", "no-cache")
                    .header("scheme", "https")
                    .header("accept", MediaType.ALL_VALUE)
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,ja;q=0.6")
                    .header("accept-encoding", "gzip, deflate, br, zstd")
                    .method(Connection.Method.GET).execute().parse();

            return getProduct(document, site);

        } catch (IOException exception) {
            throw new RuntimeException("피규어 사이트와의 연결을 실패하였습니다.");
        }
    }

    private List<String> getProduct(Document document, String site) {

        List<String> products = new ArrayList<>();

        Element productList = null;
        Element productName = null;
        Element productPrice = null;
        Element productImgURL = null;
        Element productBrand = null;

        if (site.equals(FigureSiteInfo.AMIAMIEN)) {
            productList = document.getElementsByClass(FigureSiteInfo.AmiAmiEN.PRODUCT_LIST_QUERY).first();
        } else if (site.equals(FigureSiteInfo.AMIAMIJP)) {
            productList = document.getElementsByClass(FigureSiteInfo.AmiAmiJP.PRODUCT_LIST_QUERY).first();
        } else if (site.equals(FigureSiteInfo.COMICSART)) {
            productList = document.getElementsByClass(FigureSiteInfo.ComicsArt.PRODUCT_LIST_QUERY).first();
        } else if (site.equals(FigureSiteInfo.MANIAHOUSE)) {
            productList = document.getElementsByClass(FigureSiteInfo.ManiaHouse.PRODUCT_LIST_QUERY).first();
        }

        for (int i = 0; i < productList.childrenSize(); i++) {

            Element element = productList.child(i);

            if (site.equals(FigureSiteInfo.AMIAMIEN)) {

                productName = element.select(FigureSiteInfo.AmiAmiEN.PRODUCT_NAME_QUERY).last();
                productPrice = element.selectFirst(FigureSiteInfo.AmiAmiEN.PRODUCT_PRICE_QUERY);
                productImgURL = element.selectFirst(FigureSiteInfo.AmiAmiEN.PRODUCT_IMAGE_QUERY);
                productBrand = element.selectFirst(FigureSiteInfo.AmiAmiEN.PRODUCT_BRAND_QUERY);

                products.add(getProductName(productName));
                products.add(getProductPrice(productPrice));
                products.add(getProductImgURL(productImgURL));
                products.add(getProductBrand(productBrand));

            } else if (site.equals(FigureSiteInfo.AMIAMIJP)) {

                productName = element.select(FigureSiteInfo.AmiAmiJP.PRODUCT_NAME_QUERY).last();
                productPrice = element.selectFirst(FigureSiteInfo.AmiAmiJP.PRODUCT_PRICE_QUERY);
                productImgURL = element.selectFirst(FigureSiteInfo.AmiAmiJP.PRODUCT_IMAGE_QUERY);
                //productBrand = element.selectFirst(FigureSiteInfo.AmiAmiJP.PRODUCT_BRAND_QUERY);

                products.add(getProductName(productName));
                products.add(getProductPrice(productPrice));
                products.add(getProductImgURL(productImgURL));
                //products.add(getProductBrand(productBrand));

            } else if (site.equals(FigureSiteInfo.COMICSART)) {

                productName = element.select(FigureSiteInfo.ComicsArt.PRODUCT_NAME_QUERY).last();
                productPrice = element.selectFirst(FigureSiteInfo.ComicsArt.PRODUCT_PRICE_QUERY);
                productImgURL = element.selectFirst(FigureSiteInfo.ComicsArt.PRODUCT_IMAGE_QUERY);
                productBrand = element.selectFirst(FigureSiteInfo.ComicsArt.PRODUCT_BRAND_QUERY);

                products.add(getProductName(productName));
                products.add(getProductPrice(productPrice));
                products.add(getProductImgURL(productImgURL));
                products.add(getProductBrand(productBrand));

            } else if (site.equals(FigureSiteInfo.MANIAHOUSE)) {

                productName = element.select(FigureSiteInfo.ManiaHouse.PRODUCT_NAME_QUERY).last();
                productPrice = element.selectFirst(FigureSiteInfo.ManiaHouse.PRODUCT_PRICE_QUERY);
                productImgURL = element.selectFirst(FigureSiteInfo.ManiaHouse.PRODUCT_IMAGE_QUERY);
                productBrand = element.selectFirst(FigureSiteInfo.ManiaHouse.PRODUCT_BRAND_QUERY);

                products.add(getProductName(productName));
                products.add(getProductPrice(productPrice));
                products.add(getProductImgURL(productImgURL));
                products.add(getProductBrand(productBrand));

            }
        }

        return products;
    }

    private String getProductName(Element element) {
        if (element == null) return "";
        return element.text();
    }

    private String getProductPrice(Element element) {
        if (element == null) return "";
        return element.text();
    }

    private String getProductImgURL(Element element) {
        if (element == null) return "";
        return element.attr("href");
    }

    private String getProductBrand(Element element) {
        if (element == null) return "";
        return element.text();
    }

}
