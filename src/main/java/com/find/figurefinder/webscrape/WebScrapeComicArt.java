package com.find.figurefinder.webscrape;

import com.find.figurefinder.common.FiugreSiteUrl;
import com.find.figurefinder.common.Language;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScrapeComicArt implements WebScrape {

    private FiugreSiteUrl fiugreSiteUrl;
    private final String PRODUCT_LIST_QUERY = "prdList grid8";
    // 아미아미의 이미지는 해당 컨테이너의 자식 노드에 있음
    private final String PRODUCT_NAME_QUERY = ".name > a > span";
    private final String PRODUCT_PRICE_QUERY = ".description > ul > xans-record- halfli2 > span";
    private final String PRODUCT_IMAGE_QUERY = ".description > ul > xans-record- > span";
    private final String PRODUCT_BRAND_QUERY = ".thumbnail > .prdImg > a > img";

    public WebScrapeComicArt() {
        this.fiugreSiteUrl = new FiugreSiteUrl();
    }

    @Override
    public void findFigureList(String searchText, Language language) {

        try {

            Document document = Jsoup.connect(fiugreSiteUrl.getComicArtUrl(searchText))
                    .userAgent("Mozilla/5.0").method(Connection.Method.GET).execute().parse();

            Elements productList = document.getElementsByClass(PRODUCT_LIST_QUERY);

            for (Element productInfo : productList) {

                Element productName = productInfo.select(PRODUCT_NAME_QUERY).last();
                Element productPrice = productInfo.selectFirst(PRODUCT_PRICE_QUERY);
                Element productImgURL = productInfo.selectFirst(PRODUCT_IMAGE_QUERY);
                Element productBrand = productInfo.selectFirst(PRODUCT_BRAND_QUERY);

                List<String> product = getProduct(productName, productPrice, productImgURL, productBrand);

            }

        } catch (IOException exception) {
            throw new RuntimeException("코믹스아트 사이트 연결에 실패하였습니다.");
        }
    }

    @Override
    public void findFigureCost() {

    }

    private List<String> getProduct(Element name, Element price, Element img, Element brand) {

        List<String> product = new ArrayList<>();

        product.add(getProductName(name));
        product.add(getProductPrice(name));
        product.add(getProductImgURL(name));
        product.add(getProductBrand(name));

        return product;
    }

    private String getProductName(Element element) {
        return element.text();
    }

    private String getProductPrice(Element element) {
        return element.text();
    }

    private String getProductImgURL(Element element) {
        return element.attr("href");
    }

    private String getProductBrand(Element element) {
        return element.text();
    }
}
