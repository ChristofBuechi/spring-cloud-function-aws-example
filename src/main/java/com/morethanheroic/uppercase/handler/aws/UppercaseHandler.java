package com.morethanheroic.uppercase.handler.aws;

import com.morethanheroic.uppercase.domain.UppercaseRequest;
import com.morethanheroic.uppercase.domain.UppercaseResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class UppercaseHandler extends SpringBootRequestHandler<UppercaseRequest, UppercaseResponse> {

}
