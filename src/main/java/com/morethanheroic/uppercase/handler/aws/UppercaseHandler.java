package com.healthfirst.memberfunction;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class UppercaseHandler extends SpringBootRequestHandler<UppercaseRequest, UppercaseResponse> {

}
