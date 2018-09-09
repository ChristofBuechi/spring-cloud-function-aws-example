package com.morethanheroic.uppercase.handler.aws;

import com.morethanheroic.uppercase.domain.ApiGatewayResponse;
import com.morethanheroic.uppercase.domain.UppercaseRequest;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class UppercaseHandler extends SpringBootRequestHandler<UppercaseRequest, ApiGatewayResponse> {

}
