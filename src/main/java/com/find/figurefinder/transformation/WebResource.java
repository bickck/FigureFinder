package com.find.figurefinder.transformation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;

import java.util.Map;

public interface WebResource {

    public JSONObject requestWebOneResource(String requestUrl, HttpMethod httpMethod, Map<Object, Object> requestHeader);

    public JSONArray requestWebResources(String requestUrl, HttpMethod httpMethod, Map<Object, Object> requestHeader);

}

