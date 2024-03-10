package com.find.figurefinder.webscrape;

import com.find.figurefinder.common.FiugreSiteUrl;
import com.find.figurefinder.common.Language;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScrapeAmiAmiEN implements WebScrape {

    private FiugreSiteUrl fiugreSiteUrl;

    // UL태크 하위 노드
    private final String PRODUCT_LIST_QUERY = "new-items__inner";
    private final String PRODUCT_NAME_QUERY = "newly-added-items__item__name";
    // 아미아미의 이미지는 해당 컨테이너의 자식 노드에 있음
    private final String PRODUCT_IMAGE_QUERY = "newly-added-items__item__image_item";
    private final String PRODUCT_PRICE_QUERY = "newly-added-items__item__price";
    private final String PRODUCT_BRAND_QUERY = "newly-added-items__item__brand";

    public WebScrapeAmiAmiEN() {
        this.fiugreSiteUrl = new FiugreSiteUrl();
    }

    @Async
    @Override
    public void findFigureList(String searchText, Language language) {

        try {
            //2024-02-27 유저 에이전트 문제 해결 방법 찾기
            Document document = Jsoup.connect(fiugreSiteUrl.getAmiamiUrl(searchText, Language.EN))
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
            throw new RuntimeException("아미아미 사이트와의 연결을 실패하였습니다.");
        }

    }

    protected List<String> getProduct(Element name, Element price, Element img, Element brand) {

        List<String> product = new ArrayList<>();

        product.add(getProductName(name));
        product.add(getProductPrice(name));
        product.add(getProductImgURL(name));
        product.add(getProductBrand(name));

        return product;
    }

    protected String getProductName(Element element) {
        return element.text();
    }

    protected String getProductPrice(Element element) {
        return element.text();
    }

    protected String getProductImgURL(Element element) {
        return element.attr("href");
    }

    protected String getProductBrand(Element element) {
        return element.text();
    }
}
