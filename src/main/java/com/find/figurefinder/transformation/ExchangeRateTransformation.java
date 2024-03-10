package com.find.figurefinder.transformation;

import com.find.figurefinder.common.Language;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ExchangeRateTransformation {

    private final String apiUrl = "kebhnb/ldm/v1/inquiry/**";

    private final String key = "";

    public String transExchangeRate(String money, Language language) {

        String exhangeMoney = null;

        try {

        } catch (Exception exception) {

        }

        return "";
    }

    private String post(String apiUrl, Map<String, String> requestHeaders, String text) {

        HttpURLConnection connection = connect(apiUrl);

        return "";
    }

    private HttpURLConnection connect(String apiUrl) {

        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
