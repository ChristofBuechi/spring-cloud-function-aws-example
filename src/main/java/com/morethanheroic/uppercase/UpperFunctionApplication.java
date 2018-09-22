package com.morethanheroic.uppercase;

import com.morethanheroic.uppercase.domain.*;
import com.morethanheroic.uppercase.domain.model.TimeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class UpperFunctionApplication {

    Logger logger = LoggerFactory.getLogger(UpperFunctionApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UpperFunctionApplication.class, args);
    }


    @Bean
    public Function<HealthFirstMemberRequest, ApiGatewayResponse> members() {
        return databaseTime -> {

            String currentTime = "unavailable";
            try {
                String url = "jdbc:mysql://185.101.158.55:3306/cbuechi_carparts_test";
                String username = "cbuechi_carparts";
                String password = "hidden";

                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT NOW()");

                if (resultSet.next()) {
                    currentTime = resultSet.getObject(1).toString();
                }

                logger.debug("Successfully executed query.  Result: " + currentTime);

            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("Caught exception: " + e.getMessage());
            }


            ApiGatewayResponse apiGatewayResponse = new ApiGatewayResponse();
            DatabaseFirstResponse response = new DatabaseFirstResponse();
            response.setMemberId(currentTime);
            response.setCoverage(DatabaseFirstResponse.Coverage.DATABASETIME);


            apiGatewayResponse.setObjectBody(response);
            return apiGatewayResponse;
        };
    }

    @Bean
    public Function<TimeRequest, TimeResponse> time() {
        return member -> {
            Map<String, String> map = new HashMap<>();
            map.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            map.put("X-Powered-By", "AWS Lambda & serverless");
            TimeResponse timeResponse = new TimeResponse();
            timeResponse.setBase64Encoded(false);
            timeResponse.setObjectBody(new TimeObject());
            timeResponse.setStatusCode(HttpStatus.OK.value());
            timeResponse.setHeaders(map);
            return timeResponse;
        };
    }

    @Bean
    public Function<UppercaseRequest, UppercaseResponse> uppercase() {
        return uppercaseRequest -> {
            UppercaseResponse response = new UppercaseResponse();
            String variable;
            logger.warn("is request empty ? {}" , uppercaseRequest == null);
            if (uppercaseRequest == null) {
                variable = "emptyRequest";
            } else {
                logger.warn("is request.getUserId empty ? {}" , uppercaseRequest.getUserId() == null);
                if (uppercaseRequest.getUserId() == null) {
                    variable = "emptyValue";
                } else {
                    variable = uppercaseRequest.getUserId();
                }
            }

            response.setUserId(variable.toUpperCase(Locale.ENGLISH));

            return response;
        };
    }
}
