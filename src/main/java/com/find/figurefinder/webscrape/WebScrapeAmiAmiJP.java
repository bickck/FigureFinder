package com.find.figurefinder.webscrape;

import com.find.figurefinder.common.FiugreSiteUrl;
import com.find.figurefinder.common.Language;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class WebScrapeAmiAmiJP implements WebScrape {

    private FiugreSiteUrl fiugreSiteUrl;

    // UL태크 하위 노드
    private final String PRODUCT_LIST_QUERY = "product_table_list";
    private final String PRODUCT_NAME_QUERY = ".product_box > a > .product_name > .product_name_inner";
    // 아미아미의 이미지는 해당 컨테이너의 자식 노드에 있음
    private final String PRODUCT_IMAGE_QUERY = ".product_box > a > .product_img > img ";
    private final String PRODUCT_PRICE_QUERY = ".product_box > a > .product_price";
    private final String PRODUCT_BRAND_QUERY = "";

    @Override
    public void findFigureList(String searchText, Language language) {

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
        if(element == null) return "";
        return element.text();
    }

    private String getProductPrice(Element element) {
        if(element == null) return "";
        return element.text();
    }

    private String getProductImgURL(Element element) {
        if(element == null) return "";
        return element.attr("href");
    }

    private String getProductBrand(Element element) {
        if(element == null) return "";
        return element.text();
    }

}
