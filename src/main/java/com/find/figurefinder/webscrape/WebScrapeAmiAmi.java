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

public class WebScrapeAmiAmi implements WebScrape {

    private FiugreSiteUrl fiugreSiteUrl;

    // UL태크 하위 노드
    private final String itemListClassName = "new-items__inner";
    // 아미아미의 이미지는 해당 컨테이너의 자식 노드에 있음
    private final String contentItemImgUrl = "newly-added-items__item__image_item";
    private final String contentItemName = "newly-added-items__item__name";
    private final String contentItemPrice = "newly-added-items__item__price";
    private final String contentItemBrand = "newly-added-items__item__brand";

    public WebScrapeAmiAmi() {
        this.fiugreSiteUrl = new FiugreSiteUrl();
    }

    @Async
    @Override
    public void findFigureList(String searchText, Language language) {

        try {
            //2024-02-27 유저 에이전트 문제 해결 방법 찾기
            Document document = Jsoup.connect(fiugreSiteUrl.getAmiamiUrl(searchText, Language.EN))
                    .userAgent("Mozilla/5.0").method(Connection.Method.GET).execute().parse();
            Elements itemList = document.getElementsByClass("new-items__inner");
            List<DataNode> li = itemList.dataNodes();
            for (DataNode dataNode : li) {
                String data = dataNode.getWholeData();
                System.out.println(data);
            }
        } catch (IOException exception) {
            throw new RuntimeException();
        }

    }

    @Override
    public void findFigureCost() {

    }

}
