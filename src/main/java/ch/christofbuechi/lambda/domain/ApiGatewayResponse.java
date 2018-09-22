package ch.christofbuechi.lambda.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

public class ApiGatewayResponse {

    private static final Logger LOG = Logger.getLogger(ApiGatewayResponse.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public int statusCode = 200;
    public Map<String, String> headers = Collections.emptyMap();
    public String body;
    public boolean base64Encoded = false;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Builds the {@link ApiGatewayResponse} using the passed raw body string.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Builds the {@link ApiGatewayResponse} using the passed object body
     * converted to JSON.
     */
    public void setObjectBody(Object objectBody) {
        try {
            this.body = objectMapper.writeValueAsString(objectBody);
        } catch (JsonProcessingException e) {
            LOG.error("failed to serialize object", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Builds the {@link ApiGatewayResponse} using the passed binary body
     * encoded as base64. {@link #setBase64Encoded(boolean)
     * setBase64Encoded(true)} will be in invoked automatically.
     */
    public void setBinaryBody(byte[] binaryBody) {
        this.body = new String(Base64.getEncoder().encode(binaryBody), StandardCharsets.UTF_8);
        setBase64Encoded(true);
    }

    /**
     * A binary or rather a base64encoded responses requires
     * <ol>
     * <li>"Binary Media Types" to be configured in API Gateway
     * <li>a request with an "Accept" header set to one of the "Binary Media
     * Types"
     * </ol>
     */
    public void setBase64Encoded(boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
    }
}
