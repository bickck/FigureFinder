package com.find.figurefinder.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FiugreSiteUrl {

    private final String amiamiEN = "https://www.amiami.com/";
    private final String amiamiJP = "https://www.amiami.jp/";
    private final String comicArt = "https://comics-art.co.kr/";
    private final String maniaHouse = "https://maniahouse.co.kr/";
    private final String heroTime = "https://herotime.co.kr/";
    private final String nonno21 = "http://nonno21.com/shop/main/index.php";
    private final String figurePresso = "https://figurepresso.com/";
    private final String rabitCompany = "https://rabbits.kr/";
    private final String figureSailer = "https://figuresailer.com/";


    public String getAmiamiUrl(String searchText, Language language) throws UnsupportedEncodingException {
        String text = URLEncoder.encode(searchText, "UTF-8");
        String url = null;

        if (Language.JP.equals(language)) {

        } else {
            url = amiamiEN + "eng/search/list/?s_keywords=" + text + "&s_cate_tag=1&s_st_list_preorder_available=1";
        }

        return url;
    }

    public String getComicArtUrl(String searchText) throws UnsupportedEncodingException {
        String text = URLEncoder.encode(searchText, "UTF-8");
        return comicArt + "product/search.html?view_type=list&supplier_code=&category_no=1215&search_type=product_name&keyword=" + text
                + "&exceptkeyword=&product_price1=&product_price2=&order_by=price";
    }

    public String getManiaHouseUrl(String searchText) throws UnsupportedEncodingException {
        String text = URLEncoder.encode(searchText, "UTF-8");
        return maniaHouse + "/product/search.html?banner_action=&keyword=" + text;
    }

    public String getHeroTimeUrl(String searchText) throws UnsupportedEncodingException {
        String text = URLEncoder.encode(searchText, "UTF-8");
        return heroTime + text;
    }

    private String getNonno21(String searchText) throws UnsupportedEncodingException{
        String text = URLEncoder.encode(searchText, "UTF-8");
        return nonno21 + text;
    }

}
