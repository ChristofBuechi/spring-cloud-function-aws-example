package com.morethanheroic.uppercase;

import com.morethanheroic.uppercase.domain.*;
import com.morethanheroic.uppercase.domain.model.TimeObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

@SpringBootApplication
public class UpperFunctionApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UpperFunctionApplication.class, args);
    }


    @Bean
    public Function<HealthFirstMemberRequest, HealthFirstMemberResponse> members() {
        return member -> {
            HealthFirstMemberResponse response = new HealthFirstMemberResponse();
            response.setMemberId(member.getMemberId());
            response.setCoverage(HealthFirstMemberResponse.Coverage.MEDICAL);
            return response;
        };
    }

    @Bean
    public Function<TimeRequest, TimeResponse> time() {
        return member -> {
            Map<String, String> map = new HashMap<>();
            map.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            map.put("X-Powered-By", "AWS Lambda & serverless");
            return TimeResponse
                    .builder()
                    .setBase64Encoded(false)
                    .setObjectBody(new TimeObject())
                    .setStatusCode(HttpStatus.OK.value())
                    .setHeaders(map)
                    .build();
        };
    }

    @Bean
    public Function<UppercaseRequest, UppercaseResponse> uppercase() {
        return member -> {
            UppercaseResponse response = new UppercaseResponse();
            response.setUserId(member.getUserId().toUpperCase(Locale.ENGLISH));
            return response;
        };
    }
}
