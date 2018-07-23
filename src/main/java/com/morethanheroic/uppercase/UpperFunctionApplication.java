package com.morethanheroic.uppercase;

import com.morethanheroic.uppercase.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;
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
            TimeResponse response = new TimeResponse();
            response.setTime(LocalDateTime.now( ZoneId.of("Europe/Paris")).toString());
            return response;
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
