package ch.christofbuechi.lambda.handler.aws;

import ch.christofbuechi.lambda.domain.ApiGatewayResponse;
import ch.christofbuechi.lambda.domain.DatabaseTimeRequest;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class DatabaseTimeHandler extends SpringBootRequestHandler<DatabaseTimeRequest, ApiGatewayResponse> {

}
