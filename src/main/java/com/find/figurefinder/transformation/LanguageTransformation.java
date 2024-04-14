package com.find.figurefinder.transformation;

import com.deepl.api.*;
import com.find.figurefinder.common.GlobalValiable;
import jakarta.websocket.DecodeException;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LanguageTransformation {

    private final String key = "";

    private String sourceLanguage;
    private String targetLanguage;

    public LanguageTransformation(String sourceLanguage, String targetLanguage) {
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
    }

    public String requestTransWord(String word) {

        if (word.isEmpty()) return "";

        if (GlobalValiable.getLanguageTransCount() == GlobalValiable.getLimitLanguageTransCount()) return "";

        TextResult textResult = null;
        Translator translator = new Translator(key);

        try {

            textResult = translator.translateText(word, sourceLanguage, targetLanguage);

        } catch (DeepLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            GlobalValiable.setLanguageTransCount(GlobalValiable.getLanguageTransCount() + 1);
        }

        return textResult.getText();
    }


//    public String requestTransWord(String words) {
//
//        if (GlobalValiable.getLanguageTransCount() == GlobalValiable.getLimitLanguageTransCount()) return "";
//
//        String transWord = "";
//        WebResource webResource = new WebResourceImpl();
//
//        Map<String, String> requestDataHeader = new HashMap<>();
//        requestDataHeader.put("text", words);
//        requestDataHeader.put("target_lang", targetLanguage);
//
//        Map<Object, Object> requestHeaders = new HashMap<>();
//        requestHeaders.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//        requestHeaders.put("Authorization", key);
//        requestHeaders.put("data", requestDataHeader);
//
//        Iterator<?> transResult = webResource.requestWebResources(apiUrl, HttpMethod.POST, requestHeaders).iterator();
//
//        while (transResult.hasNext()) {
//            JSONObject jsonArray = (JSONObject) transResult.next();
//
//        }
//
//        return transWord;
//    }
}
