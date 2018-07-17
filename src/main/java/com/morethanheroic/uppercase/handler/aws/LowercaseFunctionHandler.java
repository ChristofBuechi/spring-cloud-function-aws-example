package com.morethanheroic.uppercase.handler.aws;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.morethanheroic.uppercase.domain.LowercaseResponse;
import com.morethanheroic.uppercase.domain.UppercaseRequest;

public class LowercaseFunctionHandler extends SpringBootRequestHandler<UppercaseRequest, LowercaseResponse> {
}
