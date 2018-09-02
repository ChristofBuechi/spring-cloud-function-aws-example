package com.morethanheroic.uppercase.domain;

import java.util.HashMap;
import java.util.Map;

public class TimeResponse {

    public boolean isBase64Encoded;
    public int statusCode;
    public Map<String,String> headers;
    public String body;

    public TimeResponse() {
        isBase64Encoded=false;
        statusCode=201;
        headers = new HashMap<>();
        body = "1234";
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

        public void setTime(String body) {
            this.body = body;
        }

        public String getBody() {
            return body;
        }
}
