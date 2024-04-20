package com.find.figurefinder.figurefinder;

import com.find.figurefinder.common.Language;
import com.find.figurefinder.common.Money;
import com.find.figurefinder.transformation.ExchangeRateTransformation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateClassTest {


    @Test
    public void requestTransExchangeRateFunctionTest() {

        ExchangeRateTransformation exchangeRateTransformation = new ExchangeRateTransformation();

        Map<Object, Object> countryExchageRates = exchangeRateTransformation.requestTransExchangeRate();

        Assert.assertNotNull(countryExchageRates);
    }


    @Test
    public void requestParamTest() {


        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());

        Map<String, String> nhRequestHeaders = new HashMap<>();
        nhRequestHeaders.put("ApiNm", "InquireExchangeRate");
        nhRequestHeaders.put("Tsymd", currentDate);
        nhRequestHeaders.put("Iscd", "002376");
        nhRequestHeaders.put("FintechApsno", "001");
        nhRequestHeaders.put("ApiSvcCd", "DrawingTransferA");
        nhRequestHeaders.put("IsTuno", "0000");
        nhRequestHeaders.put("AccessToken", "key");

        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Header", nhRequestHeaders);
        requestHeaders.put("Btb", "0001");
        requestHeaders.put("Crcd", Money.JP.toString());
        requestHeaders.put("Inymd", currentDate);

        for (Map.Entry<String, Object> property : requestHeaders.entrySet()) {
            System.out.println("Key : " + property.getKey() + ", Value : " + property.getValue().toString());
        }

    }


}
