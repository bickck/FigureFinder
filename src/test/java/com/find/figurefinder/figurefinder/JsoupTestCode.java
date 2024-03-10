package com.find.figurefinder.figurefinder;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class JsoupTestCode {


//    @Test
//    public void jsoupTest(){
//        try {
//
//            Document document = Jsoup.connect(fiugreSiteUrl.getAmiamiUrl(searchText))
//                    .userAgent("Mozilla/5.0").method(Connection.Method.GET).execute().parse();
//            Elements itemList = document.getElementsByClass("new-items__inner");
//            List<DataNode> li = itemList.dataNodes();
//            for(DataNode dataNode : li) {
//                String data = dataNode.getWholeData();
//                System.out.println(data);
//            }
//        }catch (IOException exception) {
//            throw new RuntimeException();
//        }
//
//    }
}
