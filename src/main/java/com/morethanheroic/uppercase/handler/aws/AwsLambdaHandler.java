package com.morethanheroic.uppercase.handler.aws;

import com.morethanheroic.uppercase.domain.HealthFirstMemberRequest;
import com.morethanheroic.uppercase.domain.HealthFirstMemberResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class AwsLambdaHandler extends SpringBootRequestHandler<HealthFirstMemberRequest, HealthFirstMemberResponse> {

}
