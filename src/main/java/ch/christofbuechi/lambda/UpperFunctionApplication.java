package ch.christofbuechi.lambda;

import ch.christofbuechi.lambda.domain.*;
import ch.christofbuechi.lambda.domain.model.DatabaseTimeObject;
import ch.christofbuechi.lambda.domain.model.TimeSource;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import ch.christofbuechi.lambda.domain.model.JvmTimeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;

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

    public static void main(String[] args) {
        SpringApplication.run(UpperFunctionApplication.class, args);
    }


    @Bean
    public Function<DatabaseTimeRequest, DatabaseTimeResponse> databaseTime() {
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

            DatabaseTimeResponse response = new DatabaseTimeResponse();
            response.setObjectBody(new DatabaseTimeObject(currentTime, TimeSource.DATABASE));
            return response;
        };
    }

    @Bean
    public Function<JvmTimeRequest, JvmTimeResponse> jvmTime() {
        return timeRequest -> {
            Map<String, String> map = new HashMap<>();
            map.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            map.put("X-Powered-By", "AWS Lambda & serverless");
            JvmTimeResponse jvmTimeResponse = new JvmTimeResponse();
            jvmTimeResponse.setBase64Encoded(false);
            jvmTimeResponse.setObjectBody(new JvmTimeObject());
            jvmTimeResponse.setStatusCode(HttpStatus.OK.value());
            jvmTimeResponse.setHeaders(map);
            return jvmTimeResponse;
        };
    }

    @Bean
    public Function<Message<UppercaseRequest>, UppercaseResponse> uppercase() {
        return message -> {
            APIGatewayProxyRequestEvent headers = message.getHeaders().get("request", APIGatewayProxyRequestEvent.class);
            logger.warn("sourceIP: {}", headers.getRequestContext().getIdentity().getSourceIp());

            UppercaseRequest uppercaseRequest = message.getPayload();
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
