package com.find.figurefinder.transformation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class WebResourceImpl implements WebResource {


    @Override
    public JSONObject requestWebOneResource(String requestUrl, HttpMethod httpMethod, Map<Object, Object> requestHeader) {
        return null;
    }

    @Override
    public JSONArray requestWebResources(String requestUrl, HttpMethod httpMethod, Map<Object, Object> requestHeader) {

        String result = null;

        if (HttpMethod.GET.matches(httpMethod.name())) {
            result = get(requestUrl, requestHeader);
        } else if (HttpMethod.POST.matches(httpMethod.name())) {
            result = post(requestUrl, requestHeader);
        }

        return parer(result);
    }

    private String get(String requestUrl, Map<Object, Object> requestHeader) {

        HttpURLConnection connection = connect(requestUrl);

        try {
            for (Map.Entry<Object, Object> header : requestHeader.entrySet()) {
                connection.setRequestProperty(header.getKey().toString(), header.getValue().toString());
            }

            connection.setRequestMethod(HttpMethod.GET.name());
            return getString(connection);
        } catch (IOException exception) {
            throw new RuntimeException("API 요청과 응답 실패", exception);
        } finally {
            connection.disconnect();
        }
    }

    private String post(String requestUrl, Map<Object, Object> requestHeader) {

        HttpURLConnection connection = connect(requestUrl);

        try {
            for (Map.Entry<Object, Object> header : requestHeader.entrySet()) {
                connection.setRequestProperty(header.getKey().toString(), header.getValue().toString());
            }

            connection.setRequestMethod(HttpMethod.POST.name());
            return getString(connection);
        } catch (IOException exception) {
            throw new RuntimeException("API 요청과 응답 실패", exception);
        } finally {
            connection.disconnect();
        }
    }

    private String getString(HttpURLConnection connection) throws IOException {
        connection.setDoOutput(true);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
            return readBody(connection.getInputStream());
        } else {  // 에러 응답
            return readBody(connection.getErrorStream());
        }
    }

    private HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException exception) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, exception);
        } catch (IOException exception) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, exception);
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
