package com.morethanheroic.uppercase.handler.aws;

import com.morethanheroic.uppercase.domain.ApiGatewayResponse;
import com.morethanheroic.uppercase.domain.HealthFirstMemberRequest;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class DatabaseTimeHandler extends SpringBootRequestHandler<HealthFirstMemberRequest, ApiGatewayResponse> {

}
