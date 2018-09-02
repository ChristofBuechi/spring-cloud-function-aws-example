package com.morethanheroic.uppercase;

import com.morethanheroic.uppercase.domain.*;
import com.morethanheroic.uppercase.domain.model.TimeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.function.Function;

@SpringBootApplication
public class UpperFunctionApplication {

    Logger logger = LoggerFactory.getLogger(UpperFunctionApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UpperFunctionApplication.class, args);
    }


    @Bean
    public Function<HealthFirstMemberRequest, HealthFirstMemberResponse> members() {
        return member -> {

            String currentTime = "unavailable";
            try {
                String url = "jdbc:mysql://35.187.39.130:3306/carparts";
                String username = "root";
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



            HealthFirstMemberResponse response = new HealthFirstMemberResponse();
            response.setMemberId(currentTime);
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
