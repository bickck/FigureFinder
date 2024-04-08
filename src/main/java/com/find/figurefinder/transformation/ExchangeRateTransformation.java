package com.find.figurefinder.transformation;

import com.fasterxml.jackson.core.io.DataOutputAsStream;
import com.find.figurefinder.common.Language;
import com.find.figurefinder.common.Money;
import com.sun.net.httpserver.Headers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateTransformation {

    //https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=tUUrjkzvMfDay4eNUnyRxBRA3u8IjQWC&searchdate=20240402&data=AP01
    private final String apiUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
    private final String key = "";

    private String currentDate;

    public ExchangeRateTransformation() {

    }

    public JSONArray requestTransExchangeRate() {

        String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String requestUrl = apiUrl + "?authkey=" + key + "&searchdate=" + currentDate + "&data=" + "AP01";

        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Accept", MediaType.ALL_VALUE);

        return parer(get(requestUrl, requestHeaders));
    }

    private String get(String apiUrl, Map<String, Object> requestHeaders) {

        HttpURLConnection connection = connect(apiUrl);

        try {

            connection.setRequestMethod(HttpMethod.GET.name());
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            for (Map.Entry<String, Object> property : requestHeaders.entrySet()) {
                connection.setRequestProperty(property.getKey(), property.getValue().toString());
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readBody(connection.getInputStream());
            } else {
                return readBody(connection.getErrorStream());
            }

        } catch (IOException ioException) {
            throw new RuntimeException("");
        } finally {
            connection.disconnect();
        }
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

    private String readBody(InputStream body) {

        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

    private JSONArray parer(String data) {

        if (data == null) return null;

        try {
            JSONParser jsonParser = new JSONParser();
            return (JSONArray) jsonParser.parse(data);
        } catch (ParseException exception) {
            throw new RuntimeException("파싱 오류가 발생하였습니다.");
        }

    }
}
