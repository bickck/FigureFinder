package com.find.figurefinder.transformation;


import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExchangeRateTransformation {

    private final String apiUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

    private final String key = "";

    public ExchangeRateTransformation() {

    }

    public Map<Object, Object> requestTransExchangeRate() {

        WebResource webResource = new WebResourceImpl();
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String requestUrl = apiUrl + "?authkey=" + key + "&searchdate=" + currentDate + "&data=" + "AP01";

        Map<Object, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Accept", MediaType.ALL_VALUE);

        JSONArray exchangeRates = webResource.requestWebResources(requestUrl, HttpMethod.GET, requestHeaders);

        Map<Object, Object> countryExchageRates = new ManagedMap<>();
        if (exchangeRates.size() != 0 && exchangeRates != null) {

            Iterator<JSONObject> jsonObjectIterator = exchangeRates.iterator();

            while (jsonObjectIterator.hasNext()) {

                JSONObject countryExchangeRate = (JSONObject) jsonObjectIterator.next();

                String countryCode = countryExchangeRate.get("cur_unit").toString().substring(0, 3);
                String rate = countryExchangeRate.get("bkpr").toString();

                countryExchageRates.put(countryCode, rate);
            }
        }

        return countryExchageRates;
    }


}
