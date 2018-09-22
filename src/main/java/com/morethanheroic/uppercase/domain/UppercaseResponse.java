package com.morethanheroic.uppercase.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.morethanheroic.uppercase.UpperCaseResponseObject;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UppercaseResponse {


    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    private final int statusCode = 200;
    private final String body;
    private final Map<String, String> headers = new HashMap<>();
    private final boolean isBase64Encoded = false;

    private transient static final ObjectMapper objectMapper = new ObjectMapper();
    private transient static final Logger LOG = Logger.getLogger(UppercaseResponse.class);


    public UppercaseResponse(UpperCaseResponseObject body) {
        try {
        this.body = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            LOG.error("failed to serialize object", e);
            throw new RuntimeException(e);
        }
    }
}
