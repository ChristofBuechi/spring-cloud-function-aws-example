package ch.christofbuechi.lambda.handler.aws;

import ch.christofbuechi.lambda.domain.JvmTimeRequest;
import ch.christofbuechi.lambda.domain.JvmTimeResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class JvmTimeHandler extends SpringBootRequestHandler<JvmTimeRequest, JvmTimeResponse> {

}
