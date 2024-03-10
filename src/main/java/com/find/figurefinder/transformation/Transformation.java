package com.find.figurefinder.transformation;

import com.fasterxml.jackson.core.io.DataOutputAsStream;
import org.springframework.http.HttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Transformation {

    private final String apiUrl = "https://openapi.naver.com/v1/papago/n2mt";
    private final String id = "SzFXp9sZz8i2w8HVfKJX";
    private final String securityCode = "Zl3VoFLzx3";

    private String targetLanguage = "ko";

    public Transformation(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public String transWord(String words){

        String text = null;

        try {
            text = URLEncoder.encode(words, "UTF-8");
        }
        catch (Exception ex) {

        }

        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("",id);
        requestHeaders.put("",securityCode);

        return post(apiUrl,requestHeaders,text);
    }

    private String post(String apiUrl,Map<String,String> requestHeaders, String text) {
        HttpURLConnection connection = connect(apiUrl);
        String postParams = "source=ko&target="+targetLanguage+"&text=" + text;

        try {
            connection.setRequestMethod(HttpMethod.POST.toString());

            for(Map.Entry<String,String> header : requestHeaders.entrySet()) {
                connection.setRequestProperty(header.getKey(),header.getValue());
            }
            connection.setDoOutput(true);
            try (DataOutputAsStream wr = new DataOutputAsStream((DataOutput) connection.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(connection.getInputStream());
            } else {  // 에러 응답
                return readBody(connection.getErrorStream());
            }
        } catch (IOException exception) {
            throw new RuntimeException("API 요청과 응답 실패",exception);
        }finally {
            connection.disconnect();
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

    private String readBody(InputStream body){
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


}
